
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class forgot2 extends HttpServlet {

    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw1 = response.getWriter();
        String ans = request.getParameter("for_ans");
        try
        {
            HttpSession ses = request.getSession();
            String s1 = (String)ses.getAttribute("email");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt=con.createStatement();
            String q1="select * from U_registration where an='"+ans+"' and email='"+s1+"'";
            ResultSet rs=stmt.executeQuery(q1);
            if(rs.next())
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
"		<form action=\"forgot3\" method=post>\n" +
"		\n" +
"                    New Password:<input type=\"text\" name=\"n_pass\">\n" +
"                    <br>\n" +
"                    \n" +
"                    <input type=\"submit\" value=\"Submit\">\n" +
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
                pw1.println("<html><body bgcolor=skyblue>Something Went Wrong Try Again</body></html>");
            }
            con.close();
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}
