package simplechatting2.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import lombok.Data;
import lombok.Getter;
import simplechatting2.dto.JoinReqDto;
import simplechatting2.dto.MessageReqDto;
import simplechatting2.dto.RequestDto;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Getter
public class ChattingClient extends JFrame {
	private static ChattingClient instance;
	
	public static ChattingClient getInstance() {
		if(instance == null) {
			instance = new ChattingClient();
		}
		return instance;
	}
	
	
	private Socket socket;
	private Gson gson;
	private String username;
	
	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextArea contentView;
	private JScrollPane userListScroll;
	private JTextField messageInput;
	private JList<String> userList;
	private DefaultListModel<String> userListModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = ChattingClient.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ChattingClient() {
		gson = new Gson();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ipInput = new JTextField();
		ipInput.setText("127.0.0.1");
		ipInput.setBounds(387, 10, 78, 26);
		contentPane.add(ipInput);
		ipInput.setColumns(10);
		
		JButton connectButton = new JButton("??????");
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;
				int port = 0;
				
				ip = ipInput.getText();
				port = Integer.parseInt(portInput.getText());
				
				try {
					socket = new Socket(ip, port);
					
					JOptionPane.showMessageDialog(null, socket.getInetAddress() + "?????? ??????",
							"????????????", JOptionPane.INFORMATION_MESSAGE);
					ClientRecieve clientRecieve = new ClientRecieve(socket);
					clientRecieve.start();
					
					username = JOptionPane.showInputDialog(null, "????????? ????????? ??????????????????.", "????????????", JOptionPane.INFORMATION_MESSAGE);
					
					JoinReqDto joinReqDto = new JoinReqDto(username);
					String joinReqDtoJson = gson.toJson(joinReqDto);
					RequestDto requestDto = new RequestDto("join", joinReqDtoJson);
					String requestDtoJson = gson.toJson(requestDto);
					
					OutputStream outputStream = socket.getOutputStream();
					PrintWriter out = new PrintWriter(outputStream, true);
					out.println(requestDtoJson);
					
					
					} catch (ConnectException e1) {
					JOptionPane.showMessageDialog(null, "?????? ?????? ??????",
							"????????????", JOptionPane.ERROR_MESSAGE);
					
				} catch (UnknownHostException e1) {
					JOptionPane.showMessageDialog(null, "?????? ?????? ??????",
							"????????????", JOptionPane.ERROR_MESSAGE);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				connectButton.setEnabled(false);
				connectButton.removeMouseListener(this);
			}
		});
		connectButton.setBounds(509, 11, 64, 23);
		contentPane.add(connectButton);
		
		portInput = new JTextField();
		portInput.setText("9090");
		portInput.setColumns(10);
		portInput.setBounds(470, 10, 37, 26);
		contentPane.add(portInput);
		
		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(12, 10, 363, 365);
		
		contentPane.add(contentScroll);
		
		contentView = new JTextArea();
		contentView.setFont(new Font("CookieRun Regular", Font.PLAIN, 13));
		contentView.setEnabled(false);
		contentScroll.setViewportView(contentView);
		
		userListScroll = new JScrollPane();
		userListScroll.setBounds(387, 110, 186, 265);
		contentPane.add(userListScroll);
		
		userListModel = new DefaultListModel<>();
		userList = new JList<String>(userListModel);
		userList.setFont(new Font("CookieRun Regular", Font.PLAIN, 12));
		userListScroll.setViewportView(userList);
		
		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(12, 385, 471, 38);
		contentPane.add(messageScroll);
		
		messageInput = new JTextField();
		messageInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					sendMessage();
				}
			}
		});
		messageScroll.setViewportView(messageInput);
		
		JButton sendButton = new JButton("??????");
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sendMessage();
			}
		});
		sendButton.setBounds(488, 385, 85, 38);
		contentPane.add(sendButton);
	}
	
	private void sendRequest(String resource, String body) {
		OutputStream outputStream;
		try {
			outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);
			
			RequestDto requestDto = new RequestDto(resource, body);
			
			out.println(gson.toJson(requestDto));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void sendMessage() {
		if(!messageInput.getText().isBlank()) {
			
			String toUser = userList.getSelectedIndex() == 0 ? "all" : userList.getSelectedValue();
			
			MessageReqDto messageReqDto = new MessageReqDto(toUser, username, messageInput.getText());
			
			sendRequest("sendMessage", gson.toJson(messageReqDto));
			messageInput.setText("");
			
		}
	}
}
