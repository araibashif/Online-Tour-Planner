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


public class generatecommtrain extends HttpServlet 
{

    
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,
            ServletException
    {
       res.setContentType("text/html");
       PrintWriter pw1=res.getWriter();
       HttpSession ses = req.getSession();
       String tid =req.getParameter("t_id");
       String unm =req.getParameter("u_nm");
       ses.setAttribute("u_nm", unm);
       ses.setAttribute("t_id", tid);
       String tnm="",rseats="";
       try
       {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","SYSTEM","system");
           Statement stmt=con.createStatement();
           String q1="select * from trainbooking_det where cem='"+unm+"' and tid='"+tid+"'";
           ResultSet x=stmt.executeQuery(q1);
           if(x.next())
           {
               rseats = x.getString(3);
               tnm = x.getString(4);
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
"  background-image: url('img/admin.jpg');\n" +
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
"        <a href=\"adminhome.html\">Home</a>\n" +
"        <a href=viewbookedflightsadmin>Booked Flights</a>\n" +
"        <a href=viewbookedtrainsadmin>Booked Trains</a>\n" +
"        <a href=viewbookedhotelsadmin> Booked Hotels</a>\n" +
"        <a href=\"viewuserfeedbackadmin\"?id=\"\">User feedback</a>\n" +
"        <a href=\"show\"?id=\"\">Grant User</a>\n" +
"        <a href=logout>Logout</a>\n" +
"    </nav>\n" +
"</header>\n" +
                   "<link rel=\"stylesheet\" href=\"style.css\" />"+
"<div class=\"box\">\n" +
"    <div class=\"inner-box\">"
                   + "<form method =\"get\" action =\"generatecommissiontrain\">\n" +
"            <h1 style=text-align:left>Train Name: </h1><h1 style=color:orange>\n" +tnm+"</h1>"+
"            <p></p><h1 style=text-align:left>Train No: </h1><h1 style=color:orange>\n" +tid+"</h1>"+
                   "<p></p><h1 style=text-align:left>Customer username: </h1><h1 style=color:orange>"+unm+"</h1>"+
"            <p></p><h1 style=text-align:left>Seats Booked: </h1><h1 style=color:orange>\n" +rseats+"</h1>"+
"            <p></p><h1 style=text-align:left>Commission Required: <input type=text name=tcomm></h1>"
                   + "<p></p><input type=submit value=Submit Commission></form></div>\n" +
"</div>\n" +
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