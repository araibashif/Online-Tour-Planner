
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;
import servlets.flightcompsignin;


public class flightcomplogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        String fem = request.getParameter("femail");
        String fpass = request.getParameter("fpassword");
        flightcompsignin fl = new flightcompsignin();
        fl.setFemail(fem);
        fl.setFpass(fpass);
        boolean result = fl.CheckMethod();
        if(result==true)
        {
            HttpSession ses = request.getSession();
            ses.setAttribute("femail", fem);
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","SYSTEM","system");
                Statement stmt=con.createStatement();
                String q1="select * from flight_data where cemail='"+fem+"'";
                ResultSet x=stmt.executeQuery(q1);
                if(x.next())
                {
                    String nm = x.getString(1);
                    ses.setAttribute("fname", nm);
                    response.sendRedirect("flighthome.html");
                }
                
            }
            catch(Exception e)
            {}
            
        }
        else
            pw.println("LOGIN UNSUCESSFUL...PLEASE TRY AGAIN!!");
    }     
}