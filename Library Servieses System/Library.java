import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Library extends JFrame {
	static Library frame;
	private Container c;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new Library();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Library() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 500, 500);
		c = getContentPane();
		c.setLayout(null);
		
		
		
		JLabel libman = new JLabel("Library Servise System(B.K.)");
	    libman.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    libman.setForeground(Color.GRAY);
        libman.setBounds(160,50 ,500 ,50 );
		c.add(libman);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminLogin.main(new String[]{});
			frame.dispose();
			}
		});
		btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdminLogin.setBounds(180,150,150,50);
		c.add(btnAdminLogin);
		
		JButton btnLibrarianLogin = new JButton("Librarian Login");
		btnLibrarianLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LibrarianLogin.main(new String[]{});
			}
		});
		btnLibrarianLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLibrarianLogin.setBounds(180,250,150,50);

		c.add(btnLibrarianLogin);	
	}
}
