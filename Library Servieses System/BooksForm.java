import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BooksForm extends JFrame {
	static BooksForm frame;
	private  Container c;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BooksForm();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public BooksForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 500, 500);
		c=getContentPane();
		c.setLayout(null);
	
		JLabel lblAddBooks = new JLabel("Add Books");
		lblAddBooks.setForeground(Color.GRAY);
		lblAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddBooks.setBounds(200,8,200,50);
		c.add(lblAddBooks);
		
		JLabel lblCallNo = new JLabel("Call No:");
		lblCallNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCallNo.setBounds(100,60,100,20);
		c.add(lblCallNo);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblName.setBounds(100,110,100,20);
		c.add(lblName);
		
		JLabel lblAuthor = new JLabel("Author:");
	    lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAuthor.setBounds(100,160,100,20);
		c.add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("Publisher:");
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPublisher.setBounds(100,210,100,20);
		c.add(lblPublisher);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQuantity.setBounds(100,260,100,20);
		c.add(lblQuantity);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(200,60,150,20);
		c.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_1.setBounds(200,110,150,20);
		c.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_2.setBounds(200,160,150,20);
		c.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setBounds(200,210,150,20);
		c.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_4.setBounds(200,260,150,20);
		c.add(textField_4);
		
		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String callno=textField.getText();
			String name=textField_1.getText();
			String author=textField_2.getText();
			String publisher=textField_3.getText();
			String squantity=textField_4.getText();
			int quantity=Integer.parseInt(squantity);
			int i=BookDao.save(callno, name, author, publisher, quantity);
			if(i>0){
				JOptionPane.showMessageDialog(BooksForm.this,"Books added successfully!");
				LibrarianSection.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(BooksForm.this,"Sorry, unable to save!");
			}
			}
		});
		btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAddBooks.setBounds(190,320,120,40);
		c.add(btnAddBooks);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSection.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBounds(360,380,90,35);
		c.add(btnBack);
		
	}

}
