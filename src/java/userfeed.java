

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class userfeed extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        PrintWriter pw1 = response.getWriter();
        String fname = request.getParameter("fname"); 
        String em = request.getParameter("email");
        String country =request.getParameter("country"); 
        String feed = request.getParameter("feedback");
        try
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt = con.createStatement();
            String q1 = "insert into user_feed values('"+fname+"','"+em+"','"+country+"','"+feed+"')";
            int x = stmt.executeUpdate(q1);
            if(x>0)
            {
                response.sendRedirect("userhome.html");
            }
            else
            {
                pw1.println("Error Providing Feedback!!");
            }
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}
