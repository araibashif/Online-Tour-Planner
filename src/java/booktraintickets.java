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


public class booktraintickets extends HttpServlet 
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,
            ServletException
    {
       res.setContentType("text/html");
       PrintWriter pw1=res.getWriter();
       HttpSession ses = req.getSession();
       String s1 = (String) ses.getAttribute("usnm");
       String s2 = (String) ses.getAttribute("source");
       String s3 = (String) ses.getAttribute("destin");
       String t_id = req.getParameter("t_id");
       ses.setAttribute("t_id", t_id);
       String name="",email="",tname="",tseats="";
       try
       {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","SYSTEM","system");
           Statement stmt=con.createStatement();
           String q1 ="select * from U_registration where u_nm='"+s1+"'";
           ResultSet rs = stmt.executeQuery(q1);
           if(rs.next())
           {
               name = rs.getString(1)+rs.getString(2)+rs.getString(3);
               email = rs.getString(5);
           }
           String q2 ="select * from train_det where tid='"+t_id+"'";
           ResultSet rs2 = stmt.executeQuery(q2);
           if(rs2.next())
           {
               tname = rs2.getString(1);
               tseats = rs2.getString(3);
           }
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
"        <a href=\"viewhotels.html\"> Book Hotels</a>\n" +
"        <a href=\"viewbookings\"?id=\"\"> View Bookings</a>\n" +
"        <a href=\"userfeedback.html\">Provide feedback</a>\n" +
"        <a href=logout>Logout</a>\n" +
"    </nav>\n" +
"</header>"+
                   "<link rel=\"stylesheet\" href=\"style.css\" />"+
"<div class=\"box\">\n" +
"    <div class=\"inner-box\">"
                   + "<form method =\"get\" action =\"bookedtrains\">\n" +
"            <h1 style=text-align:left>Train Name: </h1><h1 style=color:orange>\n" +tname+"</h1>"+
"            <p></p><h1 style=text-align:left>Train No: </h1><h1 style=color:orange>\n" +t_id+"</h1>"+
                   "<p></p><h1 style=text-align:left>Customer Email: </h1><h1 style=color:orange>"+email+"</h1>"+
                   "<p></p><h1 style=text-align:left>Customer Name: </h1><h1 style=color:orange>"+name+"</h1>"+
"            <p></p><h1 style=text-align:left>Seats Available: </h1><h1 style=color:orange>\n" +tseats+"</h1>"+
"            <p></p><h1 style=text-align:left>Seats Required: <input type=text name=rseats></h1>"
                   + "<p></p><h1 style=text-align:left>Source: </h1><h1 style=color:orange>"+s2+"</h1>"
                   + "<p></p><h1 style=text-align:left>Destination: </h1><h1 style=color:orange>"+s3+"</h1>"
                   + "<p></p><input type=submit value=Confirm Booking></form></div>\n" +
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
            con.close();
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}