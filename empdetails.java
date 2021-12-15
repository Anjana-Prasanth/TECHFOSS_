import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class empdetails {
	private static Border brd;
	private JTable table;
	//java.sql.Connection conn = null;
	

	public static void main(String[] args) {
		//conn=postconnection.dbconnector();
		JFrame f =new JFrame("Employee details");
		f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
        
        JTextField empid;
    	JTextField fname;
        JTextField lname;
        JTextField qual;
    	JTextField spcl;
        JTextField dateofj;
    	
      //icon
      		Image icon = Toolkit.getDefaultToolkit().getImage("/Users/anjan/eclipse-workspace/PROJECT/src/LOGO.png");
      		f.setIconImage(icon);
      		
      		JLabel name= new JLabel("TECHFOSS");
    		name.setBounds(650,15,350,40);
    	    name.setFont(new Font("Eras Bold ITC",Font.BOLD,50));
    		f.add(name);
    		
    		JLabel logo= new JLabel();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("/Users/anjan/eclipse-workspace/PROJECT/src/LOGO.png").getImage().getScaledInstance(50, 50, 3));
            logo.setBorder(brd);
            logo.setIcon(imageIcon);
        	logo.setBounds(590,2,75,75);
    		f.add(logo);
    		
    		JLabel help= new JLabel("help");
    		help.setBounds(1300,15,350,40);
    	    help.setFont(new Font("Eras ITC",Font.ITALIC,20));
    		f.add(help);
    		
    		JLabel contact= new JLabel("Contact us");
    		contact.setBounds(1400,15,350,40);
    	    contact.setFont(new Font("Eras ITC",Font.ITALIC,20));
    		f.add(contact);
    		
    		JPanel panela = new JPanel();
			panela.setLayout(null);
			panela.setBounds(0,200,1600,1600);
			panela.setBackground(new Color(0, 89, 100));
			f.add(panela);
			

			/*JButton home = new JButton("HOME");
			f.add(home);
			home.setBounds(10,10,130,50);
			ImageIcon i3 = new ImageIcon(new ImageIcon("file:///C:/Users/Advait.edu/eclipse-workspace/TechFoss/src/Home%20logo.jpeg").getImage().getScaledInstance(10, 10, 5));
			home.setIcon(i3);*/
			
			JButton home=new JButton("Home");
	        ImageIcon i = new ImageIcon(new ImageIcon("/Users/anjan/eclipse-workspace/PROJECT/src/home.jpeg").getImage().getScaledInstance(25, 25, 5));
			home.setIcon(i);
			home.setBackground(new Color(239,238,239));
	      	home.setForeground(Color.black);
			home.setBounds(10, 10, 100, 25);
			home.setBorder(null);
	      	//home.addActionListener(new editclient());
	        f.add(home);
			

			JLabel note= new JLabel("<HTML><U>EMPLOYEE DETAILS TABLE</U></HTML>");
			  note.setBounds(150,0,500,70); 
			  note.setFont(new Font("Eras ITC",Font.ITALIC,30));
			  note.setForeground(Color.white);
			 
			  panela.add(note);
			  
			  

			
			JButton addbtn = new JButton("ADD");
			panela.add(addbtn);
			addbtn.setBounds(1300,100,130,50);
            


			JButton updatebtn = new JButton("UPDATE");
			panela.add(updatebtn);
			updatebtn.setBounds(1300,180,130,50);
			

			JButton deletebtn = new JButton("DELETE");
			panela.add(deletebtn);
			deletebtn.setBounds(1300,260,130,50);
			

			JLabel textempid= new JLabel("EMP_ID :");
			  textempid.setBounds(320, 400, 100, 30); 
			  textempid.setForeground(Color.white);
			  panela.add(textempid);

			
			empid= new JTextField();
			empid.setBounds(400, 400, 100, 25);
			panela.add(empid);
			empid.setColumns(10);
			

			JLabel textfname= new JLabel("First Name:");
			  textfname.setBounds(620, 400, 100, 30); 
			  textfname.setForeground(Color.white);
			  panela.add(textfname);

			
			fname = new JTextField();
			fname.setBounds(700, 400, 100, 25);
			panela.add(fname);
			fname.setColumns(10);
			

			JLabel textlname= new JLabel("Last Name :");
			  textlname.setBounds(920, 400, 100, 30); 
			  textlname.setForeground(Color.white);
			  panela.add(textlname);

			
			lname = new JTextField();
		    lname.setBounds(1000, 400, 100, 25);
			panela.add(lname);
		    lname.setColumns(5);
		    

			JLabel textqual= new JLabel("Qualification :");
			  textqual.setBounds(320, 480, 100, 30); 
			  textqual.setForeground(Color.white);
			  panela.add(textqual);

			
			
			qual = new JTextField();
			qual.setBounds(400, 480, 100, 25);
			panela.add(qual);
			qual.setColumns(10);
			

			JLabel textspcl= new JLabel("Specialization :");
			  textspcl.setBounds(610, 480, 100, 30); 
			  textspcl.setForeground(Color.white);
			  panela.add(textspcl);

			

		    spcl= new JTextField();
			spcl.setBounds(700, 480, 100, 25);
			panela.add(spcl);
			spcl.setColumns(10);
			

			JLabel textdoj= new JLabel("Date of join :");
			  textdoj.setBounds(920, 480, 100, 30); 
			  textdoj.setForeground(Color.white);
			  panela.add(textdoj);

			
			
			dateofj = new JTextField();
		    dateofj.setBounds(1000, 480, 100, 25);
			panela.add(dateofj);
		    dateofj.setColumns(5);
		    
		    

			JButton projbutt = new JButton("Projects");
			panela.add(projbutt);
			projbutt.setBounds(0,140,70,150);
            

			JButton teambutt = new JButton("Team alloc");
			panela.add(teambutt);
			teambutt.setBounds(0,300,70,150);
            




			
			DefaultTableModel model = new DefaultTableModel(); 
		      JTable table = new JTable(model); 
		      JScrollPane scroller = new JScrollPane(table);
		      scroller.setBounds(300, 90, 800, 250);
		       String[] col= {"Emp_ID","First_Name","Last_Name","Qualification","Specialization","Date_of_join"};
		       model.setColumnIdentifiers(col);
		       table.setModel(model);
		       panela.add(scroller);
		       /*try {
		    	   //JOptionPane.showMessageDialog(help, "d");
		    	   String s2 = "";
		    	   String s3 = "";
		    	   String s4 = "";
		    	   String s5 = "";
		    	   String s6 = "";
		    	   String s7 = "";
		       
		    	  
		    	   PreparedStatement st =((java.sql.Connection) c).prepareStatement("select * from employee_details");
		    	
		  		     	   if(conn!=null) {
		  		     		JOptionPane.showMessageDialog(help, "okk");
		    		   }else {
		    			   JOptionPane.showMessageDialog(help, "failed");
		    		   }
		    		   
		    		   
		    	   
		       }
		       catch(SQLException s1){
		    	   s1.printStackTrace();
		    	   
		       }*/

			


}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}}