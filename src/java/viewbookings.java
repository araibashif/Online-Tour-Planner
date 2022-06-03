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


public class viewbookings extends HttpServlet 
{

    
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,
            ServletException
    {
       res.setContentType("text/html");
       PrintWriter pw1=res.getWriter();
       HttpSession ses = req.getSession();
       String em = req.getParameter("email");
       String s1 = (String)ses.getAttribute("usnm");
       try
       {
           Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","SYSTEM","system");
           Statement stmt=con.createStatement();
           String q1="select * from flightbooking_det where cem='"+s1+"' and status1='false'";
           ResultSet x=stmt.executeQuery(q1);
           pw1.println
        ("<html lang=\"en\">\n" +
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
"  background-image: url('img/userhome.jpg');\n" +
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
"        <a href=\"userhome.html\">Home</a>\n" +
"        <a href=\"viewflights.html\">Book Flights</a>\n" +
"        <a href=\"viewtrains.html\">Book Trains</a>\n" +
"        <a href=\"viewhotels.html\"> Book Hotels</a>\n" +
"        <a href=\"viewbookings\"?id=\"\"> View Bookings</a>\n" +
"        <a href=\"userfeedback.html\">Provide feedback</a>\n" +
"        <a href=logout>Logout</a>\n" +
"    </nav>\n" +
"</header>"
                + "<div class=\"home\">\n \n" +
"    <div class=\"content\"><table width=100% border=2 bgcolor=\"white\"><tr bgcolor=\"pink\"><td>Flight Name&nbsp;&nbsp;&nbsp;</td><h1 style=color:white>FLIGHT BOOKINGS</h1><td>&nbsp;&nbsp;" +
"                    Flight No&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;Seat Booked&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;" +
"                    Source&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;destination&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;Status&nbsp;&nbsp;&nbsp;</td> </tr>");
        
        while(x.next())
        {
            pw1.print("<tr bgcolor=\"lightblue\"><td>&nbsp;&nbsp;"+x.getString(4)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+x.getString(5)+""
                        + "&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+x.getString(3)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"
                                + ""+x.getString(6)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+x.getString(7)+"&nbsp;&nbsp;<td>&nbsp;&nbsp;"+x.getString(9)+"&nbsp;&nbsp;"
                                        + "&nbsp;</td><td bgcolor=\"yellow\"><a href=cancelbooking?f_id="+x.getString(5)+">Cancel Booking</a></td></tr>");
        }
        pw1.println("</table><table width=100% border=2 bgcolor=\"white\"><tr bgcolor=\"pink\"><td>Train Name&nbsp;&nbsp;&nbsp;</td><h1 style=color:white>TRAIN BOOKINGS</h1><td>&nbsp;&nbsp;" +
"                    Train No&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;Seat Booked&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;" +
"                    Source&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;destination&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;Status&nbsp;&nbsp;&nbsp;</td> </tr>");
        String q2 = "select * from trainbooking_det where cem='"+s1+"' and status1='false'";

        ResultSet y = stmt.executeQuery(q2);
        while(y.next())
        {
            pw1.print("<tr bgcolor=\"lightblue\"><td>&nbsp;&nbsp;"+y.getString(4)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+y.getString(5)+""
                        + "&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+y.getString(3)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"
                                + ""+y.getString(6)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+y.getString(7)+"&nbsp;&nbsp;<td>&nbsp;&nbsp;"+y.getString(9)+"&nbsp;&nbsp;"
                                        + "&nbsp;</td><td bgcolor=\"yellow\"><a href=cancelbookingtrain?t_id="+y.getString(5)+">Cancel Booking</a></td></tr>");
        }
        pw1.println("</table><table width=100% border=2 bgcolor=\"white\"><tr bgcolor=\"pink\"><td>Hotel Name&nbsp;&nbsp;&nbsp;</td><h1 style=color:white>HOTEL BOOKINGS</h1><td>&nbsp;&nbsp;" +
"                    Hotel No&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;Rooms Booked&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;" +
"                    City&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;Status&nbsp;&nbsp;&nbsp;</td></tr>");
        String q3 = "select * from hotelbooking_det where cem='"+s1+"' and status1='false'";

        ResultSet z = stmt.executeQuery(q3);
        while(z.next())
        {
            pw1.print("<tr bgcolor=\"lightblue\"><td>&nbsp;&nbsp;"+z.getString(4)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+z.getString(5)+""
                        + "&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+z.getString(3)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"
                                + ""+z.getString(6)+"&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;"+z.getString(8)+"&nbsp;&nbsp;"
                                        + "&nbsp;</td><td bgcolor=\"yellow\"><a href=cancelbookinghotel?h_id="+z.getString(5)+">Cancel Booking</a></td></tr>");
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