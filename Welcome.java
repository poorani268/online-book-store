import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Welcome extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
//String n=request.getParameter("email");  
   // out.print("Welcome "+n+" You are logged in"); 
   //RequestDispatcher rs = request.getRequestDispatcher ("sliderbook");
    response.sendRedirect("loginpage.html"); 
//rd.forward(request, response)  
    
    }  
}
