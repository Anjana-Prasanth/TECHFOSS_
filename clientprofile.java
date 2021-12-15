import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

@SuppressWarnings("serial")
public class clientprofile extends JFrame{
    JFrame a;
    JPanel b, c, d,f;
    JLabel  c0, c1, c2, c3, c4, i,j;
    JTextField d1, d2, d3, d0, d4;
    JButton save, editp, clr, home;
    editclient edit;
    Border brd;
    
    clientprofile(){
    	a = new JFrame("TECHFOSS");
    	b = new JPanel();
        j = new JLabel("PROFILE");
        f = new JPanel();
        b.setLayout(new GridLayout(7,1,25,25));

        c = new JPanel();
        c.setLayout(new FlowLayout());
        c.setBackground(new Color(0, 89, 100));
        c.setBounds(0,0,600,70);
        
        d = new JPanel();
        d.setLayout(new FlowLayout());
        d.setBounds(50, 300, 70, 25);
        
        c0=new JLabel("Client id", JLabel.CENTER);//i have to connect to table
        c1=new JLabel("First Name", JLabel.CENTER);
        c2=new JLabel("Second Name", JLabel.CENTER);
        c3=new JLabel("Phone Number", JLabel.CENTER);
        c4=new JLabel("Email id", JLabel.CENTER);
        
        d1=new JTextField(10);
        d2=new JTextField(10);
        d3=new JTextField(10);
        d4=new JTextField(10);
        d0=new JTextField(10);
        
        d0.setBorder(null);
        
        d1.addActionListener(new editclient());
        d2.addActionListener(new editclient());
        d3.addActionListener(new editclient());
        d0.addActionListener(new editclient());
        d4.addActionListener(new editclient());
        
        
        d1.setEditable(false);
        d2.setEditable(false);
        d3.setEditable(false);
        d0.setEditable(false);
        d4.setEditable(false);
        
        b.add(c0);
        b.add(d0);
        b.add(c1);
        b.add(d1);
        b.add(c2);
        b.add(d2);
        b.add(c3);
        b.add(d3);
        b.add(c4);
        b.add(d4);
        b.setBounds(100, 100, 300, 300);
        
        save=new JButton("save");
        save.setBounds(270, 370, 70, 25);
        save.addActionListener(new editclient());
        a.add(save);
        editp=new JButton("Edit Profile");
        editp.setBounds(400,30,120,25);
        editp.addActionListener(new editclient());
        a.add(editp);
        clr = new JButton("Clear");
        clr.setBounds(370, 370, 70, 25);
        clr.addActionListener(new editclient());
        a.add(clr);
        home=new JButton("Home");
        ImageIcon i = new ImageIcon(new ImageIcon("/Users/anjan/eclipse-workspace/PROJECT/src/homeicon.png").getImage().getScaledInstance(25, 25, 5));
		home.setIcon(i);
		home.setBackground(new Color(0, 89, 100));
      	home.setForeground(Color.white);
		home.setBounds(10, 10, 100, 25);
		home.setBorder(null);
      	home.addActionListener(new editclient());
        a.add(home);
        
        
        
      //icon
      	Image icon = Toolkit.getDefaultToolkit().getImage("/Users/anjan/eclipse-workspace/PROJECT/src/LOGO.png");  
      	a.setIconImage(icon);
        
		
		
		/*Statement sta=null; 
		try {
	    	 
	         Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Janvi@2003");
	         String query = "INSERT INTO client (fname, lname, phone_no, email) values('" + d1 + "','" + d2 + "','" + d3 + "','" +
                            d4 + "')'";
	         sta = c.createStatement();
	         sta.executeUpdate(query);
	         }
	     catch(SQLException sql){
	    	 sql.printStackTrace();
	     }*/
		
		a.add(c);
        a.add(b);
        a.add(d);
        a.setSize(600,500);
        a.getContentPane().setBackground(new Color(0,89,100));
        a.setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    }
    public class editclient implements ActionListener{
    	 public void actionPerformed(ActionEvent e){
    		 String str = e.getActionCommand();
    		 if (str.equals("Edit Profile")) {
    			 d1.setEditable(true);
    		     d2.setEditable(true);
    		     d3.setEditable(true);
    		     d4.setEditable(true);
    		     
    			 d1.getText();
    		     d2.getText();
    		     d3.getText();
    		     d4.getText();
    		     
    		 }
    		 
    		 else if(str.equals("save")) {
    			 d1.setText(d1.getText());
    		     d2.setText(d2.getText());
    		     d3.setText(d3.getText());
    		     d4.setText(d3.getText());
    		     
    		     d1.setEditable(false);
    		     d2.setEditable(false);
    		     d3.setEditable(false);
    		     d4.setEditable(false);
    		 }
    		 else if (str.equals("Client id")) {
    			 //assigned by admin
    		 }
    		 else if (str.equals("Home")) {
    			 clienthome obj1 = new clienthome();
    			 obj1.setVisible(true);
    			 a.dispose();
    		 }
    		 else if (str.equals("Clear")) {
    			 d1.setText("");
    		     d2.setText("");
    		     d3.setText("");
    		     d4.setText("");
    		     
    		     d1.setEditable(false);
    		     d2.setEditable(false);
    		     d3.setEditable(false);
    		     d4.setEditable(false);
    		 }
    	 }
    }
   
    	 


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	     
		new clientprofile();
	}

}