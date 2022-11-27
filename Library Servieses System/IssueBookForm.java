import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IssueBookForm extends JFrame {
	static IssueBookForm frame;
	private Container c;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new IssueBookForm();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IssueBookForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 500, 500);
		c = getContentPane();
		c.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issue Book ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(200, 10, 200, 50);
		c.add(lblNewLabel);
		
		JLabel lblBookName = new JLabel("Book Callno:");
		lblBookName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookName.setBounds(70, 90, 200, 20);
		c.add(lblBookName);


		JLabel lblStudentId = new JLabel("Student Id:");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentId.setBounds(70, 150, 200, 20);
		c.add(lblStudentId);
		
		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentName.setBounds(70, 220, 200, 20);
		c.add(lblStudentName);
		
		JLabel lblStudentContact = new JLabel("Student Contact:");
		lblStudentContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentContact.setBounds(70, 291, 200, 20);
		c.add(lblStudentContact);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(200, 90, 200, 20);
		c.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setBounds(200, 150, 200, 20);
		c.add(textField_2);
	
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setBounds(200, 220, 200, 20);
		c.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setBounds(200, 291, 200, 20);
		c.add(textField_4);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			String bookcallno=textField_1.getText();
			int studentid=Integer.parseInt(textField_2.getText());
			String studentname=textField_3.getText();
			String studentcontact=textField_4.getText();
			
			if(IssueBookDao.checkBook(bookcallno)){
			
			int i=IssueBookDao.save(bookcallno, studentid, studentname, studentcontact);
			if(i>0){
				JOptionPane.showMessageDialog(IssueBookForm.this,"Book issued successfully!");
				LibrarianSection.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(IssueBookForm.this,"Sorry, unable to issue!");
			}
			
			}else{
				JOptionPane.showMessageDialog(IssueBookForm.this,"Sorry, Callno doesn't exist!");
			}
			
			}
		});
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIssueBook.setBounds(190, 345, 120, 40);
		c.add(btnIssueBook);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSection.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(355, 350, 80, 30);
		c.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("Note: Please check Student ID Carefully before issuing book !");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(25, 400, 500, 20);
		c.add(lblNewLabel_1);
		
	}
}
