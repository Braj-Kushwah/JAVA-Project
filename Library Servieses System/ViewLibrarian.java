import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;

public class ViewLibrarian extends JFrame {

	private JPanel c;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLibrarian frame = new ViewLibrarian();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewLibrarian() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(400, 100, 600, 500);
		c=new JPanel();
		c.setBorder(new EmptyBorder(5,5,50,5));
		c.setLayout(new BorderLayout(0,0));
		setContentPane(c);

		String data[][]=null;
		String column[]=null;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from librarian",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}	
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		c.add(sp,BorderLayout.CENTER);
		}
}
