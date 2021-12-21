import javax.swing.*;
import com.sun.jdi.connect.spi.Connection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
abstract class user{
	abstract void userlogin();
}
@SuppressWarnings("serial")
public class logreg extends user {
	public static String user_id;
    java.sql.Connection conn = null;	
    
	void userlogin(){
   conn=postconnection.dbconnector();
		
	JFrame frame = new JFrame("Welcome");
	frame.setSize(365,440);
	frame.setLayout(null);
	
	
	Image icon = Toolkit.getDefaultToolkit().getImage("/Users/anjan/eclipse-workspace/PROJECT/src/LOGO.png");  
	frame.setIconImage(icon);
	
	JPanel L = new JPanel();
	L.setBounds(0, 80, 300, 350);
	L.setLayout(null);
	frame.add(L);
	
	JPanel R = new JPanel();
	R.setBounds(0, 80, 400, 450);
	R.setLayout(null);
	frame.add(R);
	
	
	JTabbedPane tabs = new JTabbedPane();
	tabs.setBounds(0, 0, 350, 400);
	tabs.add("LOGIN",L);
	tabs.add("REGISTER",R);
	tabs.setBackground(new Color(0, 89, 100));
	tabs.setForeground(new Color(255, 255, 255));
	frame.add(tabs);
	
	  JLabel U= new JLabel("User ID :");
	  U.setBounds(12,80,250,25); 
	  L.add(U);
	  
	  JTextField Ut = new JTextField("");
	  Ut.setEditable(true);
	  Ut.setBounds(100,80,180,25);
	  L.add(Ut);
	  
	 JLabel P= new JLabel("Password :");
	  P.setBounds(12,150,180,25); 
	  L.add(P);
	  
	  JPasswordField pass = new JPasswordField();
	  pass.setBounds(100, 150, 180, 25);
	  L.add(pass);
	  
	 JButton b = new JButton("LOGIN");
	  b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="select client_id,password from login where client_id=? and password=? ";
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
						dispose();
						clienthome obj1=new clienthome();
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

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
      b.setBounds(100,209,100,47);
      b.setBackground(new Color(0, 89, 100));
      b.setForeground(new Color(255, 255, 255));
	  L.add(b);
	
	 JLabel fname= new JLabel("First Name :");
	  fname.setBounds(10,50, 180, 25);
	  R.add(fname);
	  
	  JTextField n= new JTextField("");
	  n.setBounds(100, 50, 190, 25);
	  R.add(n);
	  
	  JLabel EM= new JLabel("	Last Name :");
	  EM.setBounds(10,90, 180, 25);
	  R.add(EM);
	  
	  JTextField lname = new JTextField("");
	  lname.setBounds(100, 90, 190, 25);
	  R.add(lname);
	  
	  JLabel PS= new JLabel("Password :");
	  PS.setBounds(10,130,180,25); 
	  R.add(PS);
	  
	 JPasswordField p = new JPasswordField();
	  p.setBounds(100, 130, 190, 25);
	  R.add(p);
	  
	  JLabel ph = new JLabel("Phone Number :");
	  ph.setBounds(10, 170, 190, 25);
	  R.add(ph);
	  
	  JTextField pht = new JTextField("");
	  pht.setColumns(10);
	  pht.setBounds(100, 170, 190, 25);
	  R.add(pht);
	  
	  JLabel EMAIL_ID = new JLabel("EMAIL_ID");
	  EMAIL_ID.setBounds(10, 210, 190, 25);
	  R.add(EMAIL_ID);
	  
	  JTextField EMAIL = new JTextField("");
	  EMAIL.setBounds(100, 210, 190, 25);
	  R.add(EMAIL);
	  
	  JButton reg = new JButton("REGISTER");
	  reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                   String orde = null;
					String  incr="SELECT * FROM increment ORDER BY increment DESC LIMIT 1";
					PreparedStatement stmt=conn.prepareStatement(incr);
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						orde=rs.getString("increment");
					}
					String ord="c-"+orde;
					rs.close();
					stmt.close();
					
					
					
						String  query="insert into client values(?,?,?,?,?)";
						PreparedStatement stmt11=conn.prepareStatement(query);
						
						stmt11.setString(1,ord);
						stmt11.setString(2,fname.getText());
						stmt11.setString(3,lname.getText());
						stmt11.setString(4,EMAIL.getText());
						stmt11.setString(5,pht.getText());
						stmt11.execute();
						stmt11.close();
						
						String  pass="insert into login(client_id,password) values(?,?)";
						PreparedStatement stmt111=conn.prepareStatement(pass);
						
						stmt111.setString(1,ord);
						stmt111.setString(2,p.getText());
						JOptionPane.showMessageDialog(null,"registerd");
						JOptionPane.showMessageDialog(null,"your login_id : "+ord);
						stmt111.execute();
						
						
						stmt111.close();		
					
				
						int i=(Integer.parseInt(orde))+1;
						String  incre="insert into increment values(?)";
						PreparedStatement stmt1=conn.prepareStatement(incre);
						stmt1.setInt(1,i);
						stmt1.execute();
						stmt1.close();
					
					
					
					logreg obj=new logreg();
					obj.setVisible(true);
					frame.dispose();
								}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"updated problem");
					ex.printStackTrace();
 
				}
			}
		});
	  reg.setBounds(100,245,100,47);
	  reg.setBackground(new Color(0, 89, 100));
	  reg.setForeground(new Color(255, 255, 255));
	  R.add(reg);
	  frame.setVisible(true);
	  
	  
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		logreg lr= new logreg();	
		lr.userlogin();
	}
}