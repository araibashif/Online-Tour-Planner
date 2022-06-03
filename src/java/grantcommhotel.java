import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class grantcommhotel extends HttpServlet 
{

    
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,
            ServletException
    {
       res.setContentType("text/html");
       PrintWriter pw1=res.getWriter();
       try
       {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","SYSTEM","system");
           Statement stmt=con.createStatement();
           String q1="update commission set status3='paid' where status1='true' and status2='true'";
           int x=stmt.executeUpdate(q1);
           if(x>0)
           {
               res.sendRedirect("viewcommissionhotel");
           }
            con.close();
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}