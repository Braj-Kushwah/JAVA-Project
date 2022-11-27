import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminSection extends JFrame {
	static AdminSection frame;
	private Container c;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminSection();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AdminSection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 500, 500);
		c=getContentPane();
		c.setLayout(null);
		
		JLabel Admin = new JLabel("Admin Section");
		Admin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Admin.setForeground(Color.GRAY);
		Admin.setBounds(160,20,500,50);
		c.add(Admin);
		
		JButton addLibrarian = new JButton("Add Librarian");
		addLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    addLibrarian.setBounds(150,90,200,50);
		c.add(addLibrarian);
		
		addLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LibrarianForm.main(new String[]{});
			frame.dispose();
			}
		});
		
		JButton viewLibrarian = new JButton("View Librarian");
		viewLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewLibrarian.setBounds(150,180,200,50);
		c.add(viewLibrarian);
		viewLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ViewLibrarian.main(new String[]{});
			}
		});
		JButton deleteLibrarian = new JButton("Delete Librarian");
		deleteLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DeleteLibrarian.main(new String[]{});
			frame.dispose();
			}
		});
		deleteLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteLibrarian.setBounds(150,280,200,50);
		c.add(deleteLibrarian);
		
		JButton Logout = new JButton("Logout");
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		Logout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Logout.setBounds(200,380,100,50);
		c.add(Logout);
		
	}
}
