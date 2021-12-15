import java.sql.*;
import javax.swing.*;
  
public class postconnection { 
static Connection conn = null; 
Statement stmt =null; 
public static Connection dbconnector() { 
try {
  Class.forName("org.postgresql.Driver");
  conn =DriverManager.getConnection("jdbc:postgresql://localhost:5432/PROJECT","postgres", "Anjana@2002"); 
  JOptionPane.showMessageDialog(null,"success!");
  return conn;
  
  }
  catch (Exception e)
{       JOptionPane.showMessageDialog(null,e);
       return null;
  
 }
  
  } }
 