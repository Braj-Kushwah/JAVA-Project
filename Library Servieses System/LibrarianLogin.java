import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibrarianLogin extends JFrame {
	static LibrarianLogin frame;
	private Container c;
	private JTextField textField;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibrarianLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LibrarianLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 500, 500);
		c = getContentPane();
		c.setLayout(null);
		
		JLabel LibrarianLoginForm = new JLabel("Librarian Login Form");
		LibrarianLoginForm.setForeground(Color.GRAY);
		LibrarianLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LibrarianLoginForm.setBounds(160,50,500,50);
		c.add(LibrarianLoginForm);
		
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
			
			if(LibrarianDao.validate(name, password)){
				LibrarianSection.main(new String[]{});
				frame.dispose();
			}else{
				JOptionPane.showMessageDialog(LibrarianLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
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
