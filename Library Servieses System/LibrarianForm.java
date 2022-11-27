import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LibrarianForm extends JFrame {
	static  LibrarianForm frame;
	private Container c;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibrarianForm();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LibrarianForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 30, 550, 600);
		c =getContentPane();
		c.setLayout(null);
		
		JLabel addLibrarian = new JLabel("Add Librarian");
		addLibrarian.setForeground(Color.DARK_GRAY);
		addLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 22));
		addLibrarian.setBounds(190, 10, 500, 50);
		c.add(addLibrarian);
		
		// 1
		JLabel Name = new JLabel("Name :");
		Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Name.setBounds(120,100,100,20);
		c.add(Name);

		// 2
		JLabel Password = new JLabel("Password :");
		Password.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Password.setBounds(120,150,100,20);
		c.add(Password);
		
		// 3
		JLabel Email = new JLabel("Email :");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Email.setBounds(120,200,100,20);
		c.add(Email);
		
		// 4
		JLabel Address = new JLabel("Address :");
		Address.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Address.setBounds(120,250,100,20);
		c.add(Address);
		
		// 5
		JLabel City = new JLabel("City :");
		City.setFont(new Font("Tahoma", Font.PLAIN, 14));
        City.setBounds(120,300,100,20);
		c.add(City);

		// 6
		JLabel ContactNo = new JLabel("Contact No :");
		ContactNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ContactNo.setBounds(120,350,100,20);
		c.add(ContactNo);
		

		// 1
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField.setBounds(220,100,160,20);
		c.add(textField);
		
		// 2
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setBounds(220,150,160,20);
		c.add(passwordField);

		// 3
		textField_1 = new JTextField();
	    textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_1.setBounds(220,200,160,20);
		c.add(textField_1);
		
		// 4
		textField_2 = new JTextField();
	    textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_2.setBounds(220,250,160,20);
		c.add(textField_2);
		
		// 5
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_3.setBounds(220,300,160,20);
		c.add(textField_3);
		
		// 6
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_4.setBounds(220,350,160,20);
		c.add(textField_4);

		
		
		JButton btnNewButton = new JButton("Add Librarian");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
			String email=textField_1.getText();
			String address=textField_2.getText();
			String city=textField_3.getText();
			String contact=textField_4.getText();
            
			
			int i=LibrarianDao.save(name, password, email, address, city, contact);
			if(i>0){
				JOptionPane.showMessageDialog(LibrarianForm.this,"Librarian added successfully!");
				AdminSection.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(LibrarianForm.this,"Sorry, unable to save!");
			}
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(190,400,150,40);
		c.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminSection.main(new String[]{});
			frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBack.setBounds(220,490,100,40);
		c.add(btnBack);
	}
}
