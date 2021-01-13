import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String email,String pass) 
     {
boolean st =false;
try{
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","java");
PreparedStatement ps =con.prepareStatement
("select * from r1 where email=? and pass=?");
ps.setString(1, email);
ps.setString(2, pass);
ResultSet rs =ps.executeQuery();
st = rs.next();

}catch(Exception e)
      {
e.printStackTrace();
      }
         return st;                 
  }   
}
