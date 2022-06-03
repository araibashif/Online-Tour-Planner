import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class forgot3 extends HttpServlet
{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
    {
        response.setContentType("text/html");
        PrintWriter pw1=response.getWriter();
        String pss= request.getParameter("n_pass");
        try
        {
            HttpSession ses = request.getSession();
            String s1 = (String)ses.getAttribute("email");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt=con.createStatement();
            String q1 = "update U_registration set pass='"+pss+"' where email='"+s1+"'";
            int x=stmt.executeUpdate(q1);
            if(x>0)
            {
                pw1.println("<!DOCTYPE HTML>\n" +
"<html lang=\"en-US\">\n" +
"<head>\n" +
"	<meta charset=\"UTF-8\">\n" +
"	<title>Forgot Password</title>\n" +
"	<link rel=\"stylesheet\" href=\"style.css\" />\n" +
"</head><style>\n" +
"body {\n" +
"  background-image: url('img/forgotpass.jpg');\n" +
"  background-repeat: no-repeat;\n" +
"  background-attachment: fixed;\n" +
"  background-size: 100% 100%;\n" +
"}\n" +
"</style>\n" +
"<body>\n" +
"	\n" +
"	<div class=\"box\">\n" +
"	\n" +
"		<div class=\"inner-box\">\n" +
"		\n" +
"		<form action= method=post>\n" +
"		\n" +
"                    PassWord Changed Successfully....!!!!\n" +
"                    <br>\n" +
"                    <a href=\"login.html\">Go To Login</a>\n" +
"		\n" +
"		</form>\n" +
"		\n" +
"		</div>\n" +
"	\n" +
"	</div>\n" +
"	\n" +
"</body>\n" +
"</html>");
            }
            else
            {
                pw1.println("<html><body bgcolor=skyblue>Please Try Again</body></html>");
            }
            con.close();
        }
        catch(Exception e)
        { 
            pw1.println(e);
        }
    }
}