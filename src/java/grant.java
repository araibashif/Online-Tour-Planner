
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class grant extends HttpServlet {

    
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        String rid = req.getParameter("id");
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt=con.createStatement();
            String q1="update U_registration set status1='true' where u_nm='"+rid+"'";
            int x=stmt.executeUpdate(q1);
            if(x>0)
            {
                res.sendRedirect("show");
            }
            else
            {
                pw.println("Verification Failed");
            }
            con.close();
        }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}
