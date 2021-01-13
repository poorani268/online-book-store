/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 import javax.servlet.annotation.WebServlet;
import java.sql.*; 
/**
 *
 * @author admin
 */
public class Register extends HttpServlet {

   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {  
          response.setContentType("text/html");  
          PrintWriter out = response.getWriter();  
          
          String name = request.getParameter("userName");
          String email = request.getParameter("userEmail");
          String pass = request.getParameter("userPass");  
          int mobile = Integer.parseInt(request.getParameter("userMobile"));
          String dob = request.getParameter("userDOB");  
          String gender = request.getParameter("gender");  
          String country =request.getParameter("userCountry");  
          
          try
          {  
               //load the driver
               Class.forName("oracle.jdbc.driver.OracleDriver");  
               //create connection object
               Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1522:xe","system","java");  
               // create the prepared statement object
               PreparedStatement ps=con.prepareStatement("insert into r1 values(?,?,?,?,?,?,?)");  
  
               ps.setString(1,name);  
               ps.setString(2,email);  
               ps.setString(3,pass);  
               ps.setInt(4, mobile);
               ps.setString(5,dob);  
               ps.setString(6,gender);  
               ps.setString(7,country);  
  
               int i = ps.executeUpdate();  
               if(i>0)  
               out.print("You are successfully registered...");  
  
          }
          catch (Exception ex)
          {
               ex.printStackTrace();
          }  
          out.close();  
     }
}
