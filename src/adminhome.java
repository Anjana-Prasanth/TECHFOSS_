import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;



@SuppressWarnings("serial")
public class adminhome extends JFrame {
	JFrame f;	
	JLabel name, logo, help, contact,note;
	JPanel panel;
	JButton a, b, c;
	Border brd;
	adminhome(){
		f =new JFrame("Admin home");
        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
        
        //icon
        Image icon = Toolkit.getDefaultToolkit().getImage("/Users/anjan/eclipse-workspace/PROJECT/src/LOGO.png");  
    	f.setIconImage(icon);
    	
  		name= new JLabel("TECHFOSS");
		name.setBounds(650,15,350,40);
	    name.setFont(new Font("Eras Bold ITC",Font.BOLD,50));
		f.add(name);
		
		logo= new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("/Users/anjan/eclipse-workspace/PROJECT/src/LOGO.png").getImage().getScaledInstance(50, 50, 3));
        logo.setBorder(brd);
        logo.setIcon(imageIcon);
    	logo.setBounds(590,2,75,75);
		f.add(logo);
		

		help= new JLabel("help");
		help.setBounds(1300,15,350,40);
	    help.setFont(new Font("Eras ITC",Font.ITALIC,20));
		f.add(help);
		
		contact= new JLabel("Contact us");
		contact.setBounds(1400,15,350,40);
	    contact.setFont(new Font("Eras ITC",Font.ITALIC,20));
		f.add(contact);
		
		  note= new JLabel("Welcome Admin, select your option to continue");
		  note.setBounds(100,20,500,500); 
		  note.setFont(new Font("Eras ITC",Font.ITALIC,20));
		  f.add(note);
		  
		  panel = new JPanel();
	  panel.setLayout(null);
	  panel.setBounds(0,340,1600,1600);
	  panel.setBackground(new Color(0, 89, 100));
	  f.add(panel);
	  
		
		a=new JButton("Employee Details");
		 ImageIcon ia = new ImageIcon(new ImageIcon("/Users/anjan/eclipse-workspace/PROJECT/src/empddeticonnn.jpg").getImage().getScaledInstance(212, 200, 70));
			a.setIcon(ia);
		b=new JButton("Order Status");
		 ImageIcon ib = new ImageIcon(new ImageIcon("/Users/anjan/eclipse-workspace/PROJECT/src/orderstatusicon.jpg").getImage().getScaledInstance(215, 215, 50));
			b.setIcon(ib);
		c=new JButton("Projects");
		 ImageIcon ic = new ImageIcon(new ImageIcon("/Users/anjan/eclipse-workspace/PROJECT/src/projdeticon.jpg").getImage().getScaledInstance(212, 200, 50));
			c.setIcon(ic);
        a.setBounds(250,100,198,200);
      	a.addActionListener(new button());
      	b.setBounds(650,100,200,200);
      	b.addActionListener(new button());
        c.setBounds(1050,100,200,200);
        c.addActionListener(new button());
        panel.add(a);
        panel.add(b);
        panel.add(c);
        
        JButton empdettextbut=new JButton("EMPLOYEE DETAILS");
    	empdettextbut.setBackground(new Color(0, 89, 100));
      	empdettextbut.setForeground(Color.white);
      	empdettextbut.setFont(new Font("comic sans",Font.BOLD,13));
    	empdettextbut.setBounds(250,300,180,50);
    	empdettextbut.setBorder(null);
    	panel.add(empdettextbut);
    	
    	JButton orderdetbut=new JButton("ORDER STATUS");
    	orderdetbut.setBackground(new Color(0, 89, 100));
        orderdetbut.setForeground(Color.white);
      	orderdetbut.setFont(new Font("comic sans",Font.BOLD,13));
        orderdetbut.setBounds(650,300,180,50);
    	orderdetbut.setBorder(null);
    	panel.add(orderdetbut);
    	
    	JButton projdetbut=new JButton("PROJECT DETAILS");
    	projdetbut.setBackground(new Color(0, 89, 100));
        projdetbut.setForeground(Color.white);
    	projdetbut.setFont(new Font("comic sans",Font.BOLD,13));
    	projdetbut.setBounds(1050,300,180,50);
    	projdetbut.setBorder(null);
    	panel.add(projdetbut);
	}
	/*;*/
	public class button implements ActionListener{
	   	 public void actionPerformed(ActionEvent e){
	   		 String str = e.getActionCommand();
	   		 if (str.equals("Employee Details")) {
	   			 empdetails obj = new empdetails();
	   			 obj.setVisible(true);
	   			 f.dispose();
	   		 }
	   		 else if (str.equals("Order Status")) {
	   			 status_admin obj1 = new status_admin();
	   			 obj1.setVisible(true);
	   			 f.dispose();
	   		 }
	   		 
	   		 else if (str.equals("ORDER STATUS")) {
	   			 status_admin obj1 = new status_admin();
	   			 obj1.setVisible(true);
	   			 f.dispose();
	   		 }
	   		
	   		 else if (str.equals("PROJECT DETAILS")) {
	   			 status_admin obj1 = new status_admin();
	   			 obj1.setVisible(true);
	   			 f.dispose();
	   		 }
	   		 
	   		if (str.equals("Projects")) {
	   			 Project_lists obj2 = new Project_lists();
	   			 obj2.setVisible(true);
	   			 f.dispose();
	   		 }
	   	 }
	}
	
	
		public static void main(String[] args) {
			new adminhome();
		}
}
		