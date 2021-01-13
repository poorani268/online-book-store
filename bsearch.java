import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class bsearch extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

        String s1=request.getParameter("msg");

        if(!s1.equals(""))
        {
            try
            {
                s1=s1+"%";

                Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","java");
                String query="select ename from book where ename like ?";
                PreparedStatement st=con.prepareStatement(query);

                st.setString(1,s1);
                ResultSet rs=st.executeQuery();
                String val="";
                while(rs.next())
                {
                    val=val+"  "+rs.getString("ename");
                }
                out.println("<h1>"+val+"</h1>");
                
                if(val==""){

                    out.println("<h3>BOOK OUT OF STOCK</h3>");
                }
                con.close();
             }
            catch(Exception e)
            {
                out.println("     "+e);
            }
        }
      out.close();
    }
}