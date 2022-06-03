
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;
import servlets.traincompsignin;


public class traincomplogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        String tem = request.getParameter("temail");
        String tpass = request.getParameter("tpassword");
        traincompsignin ob = new traincompsignin();
        ob.setTemail(tem);
        ob.setTpass(tpass);
        boolean result = ob.CheckMethod();
        if(result==true)
        {
            HttpSession ses = request.getSession();
            ses.setAttribute("temail", tem);
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","SYSTEM","system");
                Statement stmt=con.createStatement();
                String q1="select * from train_data where temail='"+tem+"'";
                ResultSet x=stmt.executeQuery(q1);
                if(x.next())
                {
                    String nm = x.getString(1);
                    ses.setAttribute("tname", nm);
                    response.sendRedirect("trainhome.html");
                }
                
            }
            catch(Exception e)
            {}
        }
        else
            pw.println("LOGIN UNSUCESSFUL...PLEASE TRY AGAIN!!");
    }     
}