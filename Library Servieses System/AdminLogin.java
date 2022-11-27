import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminLogin extends JFrame {
	static AdminLogin frame;
	private Container c;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminLogin();
					frame.setResizable(false);
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 500, 500);
		c = getContentPane();
		c.setLayout(null);
		
		JLabel AdminLoginForm = new JLabel("Admin Login Form");
		AdminLoginForm.setForeground(Color.GRAY);
		AdminLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminLoginForm.setBounds(170,50,500,50);
		c.add(AdminLoginForm);
		
		JLabel Name = new JLabel("Enter Name:");
		Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Name.setBounds(130,150,100,20);
		c.add(Name);
	
		JLabel Password = new JLabel("Enter Password:");
		Password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Password.setBounds(130,200,130,20);
		c.add(Password);
		
		textField = new JTextField();
		textField.setBounds(260,150,100,20);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		c.add(textField);
		
		JButton Login = new JButton("Login");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
			if(name.equals("Brajesh")&&password.equals("Brajesh@2002")){
				AdminSection.main(new String[]{});
				frame.dispose();
			}else{
				JOptionPane.showMessageDialog(AdminLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
				passwordField.setText("");
			}
			}
		});

        Login.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Login.setBounds(200,300,100,50);
		c.add(Login);

		passwordField = new JPasswordField();
		passwordField.setBounds(260,200,100,20);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		c.add(passwordField);
		
	}
}
