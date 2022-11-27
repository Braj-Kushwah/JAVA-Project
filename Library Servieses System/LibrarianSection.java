import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LibrarianSection extends JFrame {
	static LibrarianSection frame;
	private Container c;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibrarianSection();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LibrarianSection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 50, 500, 550);
		c = getContentPane();
		c.setForeground(Color.GRAY);
		c.setLayout(null); 
		
		JLabel lblLibrarianSection = new JLabel("Librarian Section");
		lblLibrarianSection.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLibrarianSection.setBounds(170,8,300,50);
		c.add(lblLibrarianSection);

		JButton btnAddBook = new JButton("Add Books");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			BooksForm.main(new String[]{});
			frame.dispose();
			}
		});
		btnAddBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    btnAddBook.setBounds(150,60,200,40);
		c.add(btnAddBook);

		JButton btnViewBooks = new JButton("View Books");
		btnViewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				ViewBooks.main(new String[]{});
			}
		});
		btnViewBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewBooks.setBounds(150,130,200,40);
		c.add(btnViewBooks);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IssueBookForm.main(new String[]{});
				frame.dispose();
			}
		});
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIssueBook.setBounds(150,200,200,40);
		c.add(btnIssueBook);
		
		JButton btnViewIssuedBooks = new JButton("View Issued Books");
		btnViewIssuedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewIssuedBooks.main(new String[]{});
			}
		});
		btnViewIssuedBooks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewIssuedBooks.setBounds(150,270,200,40);
		c.add(btnViewIssuedBooks);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook.main(new String[]{});
				frame.dispose();
			}
		});
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReturnBook.setBounds(150,340,200,40);
		c.add(btnReturnBook);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(150,410,200,40);
		c.add(btnLogout);
	}
}
