
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;
import servlets.hotelcompsignin;



public class hotelcomplogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        String hem = request.getParameter("hemail");
        String hpass = request.getParameter("hpassword");
        hotelcompsignin ob = new hotelcompsignin();
        ob.setHemail(hem);
        ob.setHpass(hpass);
        boolean result = ob.CheckMethod();
        if(result==true)
        {
            HttpSession ses = request.getSession();
            ses.setAttribute("hemail", hem);
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","SYSTEM","system");
                Statement stmt=con.createStatement();
                String q1="select * from hotel_data where hemail='"+hem+"'";
                ResultSet x=stmt.executeQuery(q1);
                if(x.next())
                {
                    String nm = x.getString(1);
                    ses.setAttribute("hname", nm);
                    response.sendRedirect("hotelhome.html");
                }
                
            }
            catch(Exception e)
            {}
        }
        else
            pw.println("LOGIN UNSUCESSFUL...PLEASE TRY AGAIN!!");
    }     
}