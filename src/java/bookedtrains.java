import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.*;

public class bookedtrains extends HttpServlet
{
        public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        int st=0,st1=0;
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter(); 
        String seat_req=req.getParameter("rseats"); 
        st1=Integer.parseInt(seat_req);
        HttpSession ses = req.getSession();
        String s1 = (String) ses.getAttribute("usnm");
        String s2 = (String) ses.getAttribute("source");
        String s3 = (String) ses.getAttribute("destin");
        String t_id = (String)ses.getAttribute("t_id");
        String name="",tname="",tseats="";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt=con.createStatement();
            String q1 ="select * from U_registration where u_nm='"+s1+"'";
           ResultSet rs = stmt.executeQuery(q1);
           if(rs.next())
           {
               name = rs.getString(1)+rs.getString(2)+rs.getString(3);
           }
           String q2 ="select * from train_det where tid='"+t_id+"'";
           ResultSet rs2 = stmt.executeQuery(q2);
           if(rs2.next())
           {
               tname = rs2.getString(1);
               tseats = rs2.getString(3);
               st=Integer.parseInt(tseats);
           }
           
           if(st<st1)
           {
               pw1.println(("<html lang=\"en\">\n" +
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
                       "<a href=\"viewbookings\"?id=\"\"> View Bookings</a>"+
"        <a href=\"userfeedback.html\">Provide feedback</a>\n" +
"        <a href=logout>Logout</a>\n" +
"    </nav>\n" +
"</header>\n" +
"<div class=\"home\">\n" +
"    <div class=\"content\"><h3>SORRY REQUIRED SEATS NOT AVAILABLE</h3></div>\n" +
"</div>\n" +
"\n" +
"<section class=\"footer\">\n" +
"\n" +
"    <div class=\"box-container\">\n" +
"        <h1 class=\"credit\"> created by <span> TEAM FLYING WINGS </span> | all rights reserved! </h1>\n" +
"\n" +
"</section>\n" +
"</body>\n" +
"</html>"));
           }
           else
           {
               int seats=st-st1;
               String q3="insert into trainbooking_det values('"+name+"','"+s1+"','"+seat_req+"','"+tname+"','"+t_id+"','"+s2+"','"+s3+"','false','false')";
               int y=stmt.executeUpdate(q3);
                
               String q4="update train_det set tseats="+seats+" where tid='"+t_id+"'";
               int z=stmt.executeUpdate(q4);
               if(z>0)
               {
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
"        <a href=\"#book\"> Book Hotels</a>\n" +
"        <a href=\"viewbookings\"?id=\"s1\">View Bookings</a>"+
"        <a href=\"userfeedback.html\">Provide feedback</a>\n" +
"        <a href=\"index.html\">Logout</a>\n" +
"    </nav>\n" +
"</header>\n" +
"<div class=\"home\">\n" +
"    <div class=\"content\"><h3>TRAIN BOOKED...HAVE A SAFE JOURNEY</h3></div>\n" +
"</div>\n" +
"\n" +
"<section class=\"footer\">\n" +
"\n" +
"    <div class=\"box-container\">\n" +
"        <h1 class=\"credit\"> created by <span> TEAM FLYING WINGS </span> | all rights reserved! </h1>\n" +
"\n" +
"</section>\n" +
"</body>\n" +
"</html>");
               }
           }
           
       
            con.close();
        }
        catch(Exception e)
        { 
            pw1.println(e);
        }
    }
}