package simplechatting.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class ChattingClient extends JFrame {

	private Socket socket;
	private String username;
	
	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextArea contentView;
	private JScrollPane userListScroll;
	private JTextField messageInput;
	private JList userList;
	private DefaultListModel<String> userListModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = new ChattingClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChattingClient() {
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
		
		JButton connectButton = new JButton("연결");
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;								// 들어가야 할 ip와 port 선언
				int port = 0;
				
				ip = ipInput.getText();							// ip, port 가져오고,
				port = Integer.parseInt(portInput.getText());	// port는 int로 변환
				
				try {
					socket = new Socket(ip, port);
					
					JOptionPane.showMessageDialog(null, socket.getInetAddress() + "서버 접속",
							"접속성공", JOptionPane.INFORMATION_MESSAGE);
					
					InputStream inputStream = socket.getInputStream();					// 서버로부터 데이터가 들어오는 통로를 만드는 작업
					BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
					
					if(in.readLine().equals("join")){
							username = JOptionPane.showInputDialog(null, "사용자이름을 입력하세요.", JOptionPane.INFORMATION_MESSAGE);
							
							OutputStream outputStream = socket.getOutputStream();		// 다시, 서버한테 값을 주는 통로를 열어줌
							PrintWriter out = new PrintWriter(outputStream, true);
							
							out.println(username);										// << 이 내용을 줌
							
//							String welcomeMessage = in.readLine();						// welcome메세지를 서버에서 다시 받아오고 변수에 담음
//							
//							contentView.append(welcomeMessage);							// 그 후 변수를 contentView에 append 담음
					}
					
					Thread thread = new Thread(() -> {
						try {
							InputStream input = socket.getInputStream();
							BufferedReader reader = new BufferedReader(new InputStreamReader(input));
							
							while(true) {
								String message = reader.readLine();
								if(message.startsWith("@welcome")) {
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1);
								}else if(message.startsWith("@userList")) {
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1);
									String[] usernames = message.split(",");
									userListModel.clear();
									for(String username : usernames) {
										userListModel.addElement(username);
									}
									continue;
								}
								contentView.append(message + "\n");
							}
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					});
					
					thread.start();
					
				} catch (ConnectException e1) {
					JOptionPane.showMessageDialog(null, "서버 접속 실패",
							"접속실패", JOptionPane.ERROR_MESSAGE);
					
				} catch (UnknownHostException e1) {
					JOptionPane.showMessageDialog(null, "서버 접속 실패",
							"접속실패", JOptionPane.ERROR_MESSAGE);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
		contentScroll.setViewportView(contentView);
		
		userListScroll = new JScrollPane();
		userListScroll.setBounds(387, 110, 186, 265);
		contentPane.add(userListScroll);
		
		userListModel = new DefaultListModel<>();
		userList = new JList(userListModel);
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
					if(!messageInput.getText().isBlank()) {
						try {
							OutputStream outputStream = socket.getOutputStream();
							PrintWriter out = new PrintWriter(outputStream, true);
							
							out.println(username + " : " + messageInput.getText());
							
							messageInput.setText("");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		messageScroll.setViewportView(messageInput);
		
		JButton sendButton = new JButton("전송");
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!messageInput.getText().isBlank()) {
					try {
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);
						
						out.println(username + " : " + messageInput.getText());
						
						messageInput.setText("");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		sendButton.setBounds(488, 385, 85, 38);
		contentPane.add(sendButton);
	}
}
