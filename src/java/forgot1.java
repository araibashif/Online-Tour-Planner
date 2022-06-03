
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class forgot1 extends HttpServlet {

    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        String eid = request.getParameter("email");
        try{
            HttpSession ses = request.getSession();
            ses.setAttribute("email",eid);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt=con.createStatement();
            String q1="select * from U_registration where email='"+eid+"'";
            ResultSet x = stmt.executeQuery(q1);
            if(x.next())
            {
                pw.println("<html lang=\"en-US\">\n" +
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
"		<form action=\"forgot2\" method=post>\n" +
"		\n" +
"                    Security Question:'"+x.getString(8)+"'\n" +
"                    <br>\n" +
"                    Answer: <input type=\"text\" name=\"for_ans\">\n" +
"                    <br>\n" +
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
                pw.println("<html><body bgcolor=skyblue>INVALID ANSWER</body></html>");
            }
            con.close();
        }
        catch(Exception e){}
    }
        
}