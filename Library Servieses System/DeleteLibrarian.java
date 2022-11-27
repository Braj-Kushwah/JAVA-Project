import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteLibrarian extends JFrame {
	static DeleteLibrarian frame;
	private Container c;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteLibrarian();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteLibrarian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 450, 400);
		c=getContentPane();
		c.setLayout(null);
		
		JLabel lblEnterId = new JLabel("Enter Id :");
		lblEnterId.setForeground(Color.DARK_GRAY);
		lblEnterId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterId.setBounds(10, 50, 100, 20);
		c.add(lblEnterId);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(100, 50, 150, 20);
		c.add(textField);
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=textField.getText();
				if(sid==null||sid.trim().equals("")){
					JOptionPane.showMessageDialog(DeleteLibrarian.this,"Id can't be blank");
				}else{
					int id=Integer.parseInt(sid);
					int i=LibrarianDao.delete(id);
					if(i>0){
						JOptionPane.showMessageDialog(DeleteLibrarian.this,"Record deleted successfully");
					}else{
						JOptionPane.showMessageDialog(DeleteLibrarian.this,"Unable to delete given id!");
					}
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setForeground(Color.DARK_GRAY);
		btnDelete.setBounds(150, 150, 150, 30);
		c.add(btnDelete);

		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSection.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBounds(300, 250, 100, 30);
		c.add(btnNewButton);
		
	}
}
