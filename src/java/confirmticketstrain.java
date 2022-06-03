

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import servlets.signupservlet;


public class confirmticketstrain extends HttpServlet {

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        PrintWriter pw1 = response.getWriter();
        HttpSession ses = request.getSession();
        String s1 = (String)ses.getAttribute("t_id");
        String unm = request.getParameter("u_nm");
        ses.setAttribute("usnm", unm);
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt = con.createStatement();
            String q1 = "update trainbooking_det set status2='Confirmed' where cem='"+unm+"'";
            int x = stmt.executeUpdate(q1);
            if(x>0)
            {
                response.sendRedirect("viewbookingstrain");
            }
            else
            {
                pw1.println("Train Booking Not Confirmed!!");
            }
        }
            catch(Exception e)
                    {
                        pw1.println(e);
                    }
    }

}
