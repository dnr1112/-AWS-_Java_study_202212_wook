package usermanagement.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.JsonObject;

import usermanagement.service.UserService;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserManagementFrame extends JFrame {

	private List<JTextField> loginFields;
	private List<JTextField> registerFields;
	
	private CardLayout mainCard;
	private JPanel mainPanel;
	private JTextField loginUsernameField;
	private JPasswordField loginPasswordField;
	private JTextField registerUsernameField;
	private JPasswordField registerPasswordField;
	private JTextField registerNameField;
	private JTextField registerEmailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagementFrame frame = new UserManagementFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserManagementFrame() {
		loginFields = new ArrayList<>();
		registerFields = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(null);

		setContentPane(mainPanel);
		
		mainCard = new CardLayout();
		mainPanel.setLayout(mainCard);
		
		JPanel loginPanel = new JPanel();
		
		mainPanel.add(loginPanel, "loginPanel");
		loginPanel.setLayout(null);
		
		JLabel logoText = new JLabel("User Management");
		logoText.setFont(new Font("CookieRun Regular", Font.BOLD, 20));
		logoText.setHorizontalAlignment(SwingConstants.CENTER);
		logoText.setBounds(55, 28, 272, 54);
		loginPanel.add(logoText);
		
		JLabel loginText = new JLabel("Login");
		loginText.setFont(new Font("CookieRun Regular", Font.PLAIN, 14));
		loginText.setHorizontalAlignment(SwingConstants.CENTER);
		loginText.setBounds(102, 92, 170, 54);
		loginPanel.add(loginText);
		
		loginUsernameField = new JTextField();
		loginUsernameField.setBounds(12, 186, 360, 27);
		loginPanel.add(loginUsernameField);
		loginUsernameField.setColumns(10);
		
		loginPasswordField = new JPasswordField();
		loginPasswordField.setBounds(12, 245, 360, 27);
		loginPanel.add(loginPasswordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(12, 316, 360, 36);
		loginPanel.add(loginButton);
		
		JLabel loginUsernameLabel = new JLabel("Username or email");
		loginUsernameLabel.setBounds(12, 161, 122, 15);
		loginPanel.add(loginUsernameLabel);
		
		JLabel loginPasswordLabel = new JLabel("password");
		loginPasswordLabel.setBounds(12, 223, 122, 15);
		loginPanel.add(loginPasswordLabel);
		
		JLabel signupDesc = new JLabel("Don't have an accout?");
		signupDesc.setHorizontalAlignment(SwingConstants.CENTER);
		signupDesc.setBounds(73, 377, 133, 15);
		loginPanel.add(signupDesc);
		
		JLabel signupLink = new JLabel("Sign up");
		signupLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "registerPanel");
				clearFields(loginFields);
			}
		});
		signupLink.setHorizontalAlignment(SwingConstants.CENTER);
		signupLink.setBounds(218, 377, 57, 15);
		loginPanel.add(signupLink);
		
		JLabel forgotPasswordLink = new JLabel("Forgot your password?");
		forgotPasswordLink.setHorizontalAlignment(SwingConstants.CENTER);
		forgotPasswordLink.setBounds(122, 402, 140, 15);
		loginPanel.add(forgotPasswordLink);
		
		JPanel registerPanel = new JPanel();
		mainPanel.add(registerPanel, "registerPanel");
		registerPanel.setLayout(null);
		
		JLabel signInLink = new JLabel("Sign in");
		signInLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "loginPanel");
				clearFields(loginFields);
			}
		});
		signInLink.setHorizontalAlignment(SwingConstants.CENTER);
		signInLink.setBounds(315, 436, 57, 15);
		registerPanel.add(signInLink);
		
		JLabel registerLogoText = new JLabel("User Management");
		registerLogoText.setHorizontalAlignment(SwingConstants.CENTER);
		registerLogoText.setFont(new Font("CookieRun Regular", Font.BOLD, 20));
		registerLogoText.setBounds(55, 28, 272, 54);
		registerPanel.add(registerLogoText);
		
		JLabel registerText = new JLabel("Register");
		registerText.setHorizontalAlignment(SwingConstants.CENTER);
		registerText.setFont(new Font("CookieRun Regular", Font.PLAIN, 14));
		registerText.setBounds(102, 92, 170, 54);
		registerPanel.add(registerText);
		
		registerUsernameField = new JTextField();
		registerUsernameField.setColumns(10);
		registerUsernameField.setBounds(12, 181, 360, 27);
		registerPanel.add(registerUsernameField);
		
		registerPasswordField = new JPasswordField();
		registerPasswordField.setBounds(12, 240, 360, 27);
		registerPanel.add(registerPasswordField);
		
		JLabel registerUsernameLabel = new JLabel("Username");
		registerUsernameLabel.setBounds(12, 156, 122, 15);
		registerPanel.add(registerUsernameLabel);
		
		JLabel registerPasswordLabel = new JLabel("password");
		registerPasswordLabel.setBounds(12, 218, 122, 15);
		registerPanel.add(registerPasswordLabel);
		
		registerNameField = new JTextField();
		registerNameField.setColumns(10);
		registerNameField.setBounds(12, 302, 360, 27);
		registerPanel.add(registerNameField);
		
		JLabel registerNameLabel = new JLabel("name");
		registerNameLabel.setBounds(12, 277, 122, 15);
		registerPanel.add(registerNameLabel);
		
		JLabel registerEmailLabel = new JLabel("email");
		registerEmailLabel.setBounds(12, 339, 122, 15);
		registerPanel.add(registerEmailLabel);
		
		registerEmailField = new JTextField();
		registerEmailField.setColumns(10);
		registerEmailField.setBounds(12, 364, 360, 27);
		registerPanel.add(registerEmailField);
		
		JButton registerButton = new JButton("Register");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JsonObject userJson = new JsonObject();
				userJson.addProperty("username", registerUsernameField.getText());
				userJson.addProperty("password", registerPasswordField.getText());
				userJson.addProperty("name", registerNameField.getText());
				userJson.addProperty("email", registerEmailField.getText());
								
				UserService userService = UserService.getInstance();
				
				userService.register(userJson.toString());
				
				Map<String, String> response = userService.register(userJson.toString());
				
				if(response.containsKey("error")) {
					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				JOptionPane.showMessageDialog(null, response.get("ok"), "ok", JOptionPane.INFORMATION_MESSAGE);
				mainCard.show(mainPanel, "loginPanel");
				clearFields(registerFields);
			}
		});
		registerButton.setBounds(12, 401, 360, 36);
		registerPanel.add(registerButton);
		
		loginFields.add(loginUsernameField);
		loginFields.add(loginPasswordField);
		
		registerFields.add(registerUsernameField);
		registerFields.add(registerPasswordField);
		registerFields.add(registerNameField);
		registerFields.add(registerEmailField);
		
	}
	
	private void clearFields(List<JTextField> textFields) {
		for(JTextField field : textFields) {
			if(field.getText().isEmpty()) {
				continue;
			}
			field.setText("");
		}
	}
}
