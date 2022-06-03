import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class viewcommissiontrain extends HttpServlet 
{

    
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,
            ServletException
    {
       res.setContentType("text/html");
       PrintWriter pw1=res.getWriter();
       try
       {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","SYSTEM","system");
           Statement stmt=con.createStatement();
           String q1="select * from commission where status2='false'";
           ResultSet x=stmt.executeQuery(q1);
           pw1.println("<html lang=\"en\">\n" +
"<head>\n" +
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
"</head>\n" +
"<style>\n" +
"body {\n" +
"  background-image: url('img/train.jpg');\n" +
"  background-repeat: no-repeat;\n" +
"  background-attachment: fixed;\n" +
"  background-size: 100% 100%;\n" +
"}\n" +
"</style>\n" +
"<body>\n" +
"<header>\n" +
"\n" +
"    <div id=\"menu-bar\" class=\"fas fa-bars\"></div>\n" +
"\n" +
"    <a href=\"index.html\" class=\"logo\"><span>T</span>ouring.com</a>\n" +
"\n" +
"    <nav class=\"navbar\">\n" +
"        <a href=\"trainhome.html\">Home</a>\n" +
"        <a href=\"addtrain.html\">Add Train</a>\n" +
"        <a href=\"viewtrains\"?t_nm=tname>View Trains</a>\n" +
"        <a href=viewbookingstrain?tid=tid>View bookings</a>\n" +
"        <a href=viewuserfeedbacktrains?id=\"\">User feedback</a>\n" +
"        <a href=viewcommissiontrain>Grant Commission</a>\n" +
"        <a href=logout>Logout</a>\n" +
"    </nav>\n" +
"</header>\n" +
"<div class=\"home\">\n" +
"    <div class=\"content\"><table width=100% border=2 bgcolor=\"white\"><tr bgcolor=\"pink\"><td>Train Name&nbsp;&nbsp;&nbsp;</td>><td>&nbsp;&nbsp;"
                   + "Train Id&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;Client's Username&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"
                   + "Seats Booked&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;Admin Commission Generated&nbsp;&nbsp;&nbsp;</td></tr>");
           while(x.next())
            {
                pw1.print("<tr bgcolor=\"lightblue\"><td>&nbsp;&nbsp;"+x.getString(1)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+x.getString(2)+""
                        + "&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+x.getString(3)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"
                                + ""+x.getString(4)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+x.getString(5)+"&nbsp;&nbsp;&nbsp;</td>"
                                        + "<td bgcolor=\"yellow\"><a href=grantcommtrain?f_id="+x.getString(2)+"&u_nm="+x.getString(3)+">Grant Commission</td></tr>");
            }
            pw1.println("</table></div>\n" +
"</div>\n" +
"\n" +
"<section class=\"footer\">\n" +
"\n" +
"    <div class=\"box-container\">\n" +
"        <h1 class=\"credit\"> created by <span> TEAM FLYING WINGS </span> | all rights reserved! </h1>\n" +
"\n" +
"</section>\n" +
"</body>\n" +
"</html><body></html>");
            con.close();
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}