
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class show extends HttpServlet {

    
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = res.getWriter();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt=con.createStatement();
            String q1="select * from U_registration where status1='false'";
            ResultSet x=stmt.executeQuery(q1);
            pw.println("<html><head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Touring.com</title>\n" +
"\n" +
"    <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\" />\n" +
"\n" +
"    <!-- font awesome cdn link  -->\n" +
"    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\n" +
"\n" +
"    <!-- custom css file link  -->\n" +
"    <link rel=\"stylesheet\" href=\"style (1).css\">\n" +
"\n" +
"</head><body><header>\n" +
"\n" +
"    <div id=\"menu-bar\" class=\"fas fa-bars\"></div>\n" +
"\n" +
"    <a href=\"index.html\" class=\"logo\"><span>T</span>ouring.com</a>\n" +
"\n" +
"    <nav class=\"navbar\">\n" +
"        <a href=\"adminhome.html\">Home</a>\n" +
"        <a href=viewbookedflightsadmin>Booked Flights</a>\n" +
"        <a href=viewbookedtrainsadmin>Booked Trains</a>\n" +
"        <a href=viewbookedhotelsadmin> Booked Hotels</a>\n" +
"        <a href=\"viewuserfeedbackadmin\"?id=\"\">User feedback</a>\n" +
"        <a href=\"show\"?id=\"\"\">Grant User</a>\n" +
"        <a href=logout>Logout</a>\n" +
"    </nav>\n" +
"</header>"
                    + "<div class=\"home\">\n" +
"    <div class=\"content\"><table height=100% width=100% border=2><tr><td>F_NM&ensp;&ensp;&ensp;</td><td>&nbsp;&nbsp;"
                    + "M_NM&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;L_NM&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;U_NM&nbsp;"
                    + "&nbsp;&nbsp;</td><td>&nbsp;&nbsp;EMAIL&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;DOB&nbsp;&nbsp;&nbsp;"
                    + "</td><td>&nbsp;&nbsp;Grant Permission&nbsp;&nbsp;&nbsp;</td></tr>");
            while(x.next())
            {
                pw.println("<tr><td>&nbsp;&nbsp;"+x.getString(1)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+x.getString(2)+""
                        + "&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+x.getString(3)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"
                                + ""+x.getString(4)+
                                "&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+x.getString(5)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+x.getString(6)+"&nbsp;&nbsp;&nbsp;"
                                        + "</td><td>&nbsp;&nbsp;<a href=grant?id="+x.getString(4)+">Grant Permission</a>&nbsp;&nbsp;&nbsp;</td></tr>");
            }
            pw.println("</table></div>\n" +
"</div><section class=\"footer\">\n" +
"\n" +
"    <div class=\"box-container\">\n" +
"        <h1 class=\"credit\"> created by <span> TEAM FLYING WINGS </span> | all rights reserved! </h1>\n" +
"\n" +
"</section><body></html>");
            con.close();
        }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}
