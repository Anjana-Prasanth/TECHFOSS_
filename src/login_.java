import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


abstract class admin{
	abstract void adminlogin();
}
@SuppressWarnings("serial")
public class login_ extends admin {
	public static String user_id;

	java.sql.Connection conn = null;
	
	void adminlogin(){
	conn = postconnection.dbconnector();
		JFrame frame = new JFrame("Login Page");
	  frame.getContentPane();
	  
	  Image icon = Toolkit.getDefaultToolkit().getImage("/Users/anjan/eclipse-workspace/PROJECT/src/LOGO.png");  
		frame.setIconImage(icon);
		
	 JPanel panel = new JPanel();
	  panel.setLayout(null);
	  panel.setBounds(0,80,400,450);
      frame.add(panel);
	 
      JPanel Lp = new JPanel();
	  frame.add(Lp); 
	  
	  JLabel L = new JLabel("LOGIN");
	  L.setBounds(143,35,150,20);
	  L.setFont(new Font("Times New Roman",Font.BOLD,30));
	  L.setForeground(new Color(255,255,255));
	  Lp.setBackground(new Color(0, 89, 100));
	  Lp.add(L);
	  
	  JLabel U= new JLabel("User ID :");
	  U.setBounds(12,80,250,25); 
	  panel.add(U);
	  
	  JTextField Ut = new JTextField("");
	  Ut.setEditable(true);
	  Ut.setBounds(100,80,230,25);
	  panel.add(Ut);
	  
	  JLabel P= new JLabel("Password :");
	  P.setBounds(12,150,230,25); 
	  panel.add(P);
	  
	  JPasswordField pass = new JPasswordField();
	  pass.setBounds(100, 150, 230, 25);
	  panel.add(pass);
	  
	  
	 
	  JButton b = new JButton("Login");
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				String  query="select admin_id,password from login where admin_id=? and password=? ";
				PreparedStatement stmt=conn.prepareStatement(query);
				stmt.setString(1,Ut.getText()); 
				stmt.setString(2,pass.getText()); 
				ResultSet rs=stmt.executeQuery();
				int count=0;
				while(rs.next())
				{
					count=count+1;
				}
				if(count==1)
				{
					JOptionPane.showMessageDialog(null,"user_id and password correct");
					user_id=Ut.getText();
					frame.dispose();
					adminhome obj1=new adminhome();
					obj1.setVisible(true);
					
					
				}
				else if(count>1)
				{
					JOptionPane.showMessageDialog(null," duplicate user_id and password ");
				}
				else
				{
					JOptionPane.showMessageDialog(null," incorrect user_id and password!");
				}
				rs.close();
				stmt.close();
				frame.dispose();}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"show  problem!");
				e1.printStackTrace();
			}
		}

	
	});
    b.setBounds(15,209,100,47);
    b.setBackground(new Color(0, 89, 100));
    b.setForeground(new Color(255,255,255));
    b.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	//admin home 
        }
    });
    b.setFont(new Font("Times New Roman",Font.BOLD,14));
	  panel.add(b);
	  
	  frame.setSize(400, 450);
    frame.setVisible(true);
    
   
	}
	public static void main(String[] args) {
	 login_ al= new login_();
	 al.adminlogin();
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}}
