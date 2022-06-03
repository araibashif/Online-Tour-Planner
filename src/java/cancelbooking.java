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


public class cancelbooking extends HttpServlet 
{

    
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,
            ServletException
    {
       res.setContentType("text/html");
       PrintWriter pw1=res.getWriter();
       HttpSession ses= req.getSession();
       String unm = (String)ses.getAttribute("usnm");
       String cfid= req.getParameter("f_id");
       String fid="",seats="",fseats="";
       int st=0,rseats=0,tseats=0;
       try
       {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","SYSTEM","system");
           Statement stmt=con.createStatement();
           String q1="select * from flightbooking_det where cem='"+unm+"' and fid='"+cfid+"'";
           ResultSet rs =stmt.executeQuery(q1);
           if(rs.next())
           {
               
               seats=rs.getString(3);
               fid=rs.getString(5);
               rseats = Integer.parseInt(seats);
                String q2="update flightbooking_det set status1='true' where cem='"+unm+"'and fid='"+fid+"'";
               int x = stmt.executeUpdate(q2); 
               String q3 ="select * from flight_det where fid='"+fid+"'";
               ResultSet rs2 = stmt.executeQuery(q3);
               if(rs2.next())
               {
                   fseats = rs2.getString(3);
                   st=Integer.parseInt(fseats);
               }
               tseats=st+rseats;
               String q4="update flight_det set fseats="+tseats+" where fid='"+fid+"'";
               int y = stmt.executeUpdate(q4);
           pw1.println("\"<html lang=\"en\">\n" +
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
"        <a href=\"viewbookings\"?id=\"s1\"> View Bookings</a>\n" +
"        <a href=\"userfeedback.html\">Provide feedback</a>\n" +
"        <a href=logout>Logout</a>\n" +
"    </nav>\n" +
"</header>"
                + "<div class=\"home\"><div class=\"content\"><h3>Selected Booking Canceled!!</h3></div>\n" +
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
           }
            con.close();
       }
       catch(Exception e)
       {
           pw1.println(e);
       }
    }
}