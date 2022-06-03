import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax .servlet.http.*;

public class addtrain extends HttpServlet
{
        public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String t_name=req.getParameter("tnm"); 
        String t_id=req.getParameter("tno"); 
        String seats=req.getParameter("ts"); 
        String source=req.getParameter("source");
        String destination=req.getParameter("destination");
       
        try
        {
            HttpSession ses = req.getSession();
            ses.setAttribute("tid", t_id);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt=con.createStatement();
            String q1="insert into train_det values('"+t_name+"','"+t_id+"','"+seats+"','"+source+"','"+destination+"','false','false')";
            int x=stmt.executeUpdate(q1);
            if(x>0)
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
"        <a href=viewtrains?t_nm=tname>View Trains</a>\n" +
"        <a href=viewbookingstrain?tid=tid>View bookings</a>\n" +
"        <a href=viewuserfeedbacktrains?id=\"\">User feedback</a>\n" +
"        <a href=viewcommissiontrain>Grant Commission</a>\n" +
"        <a href=logout>Logout</a>\n" +
"    </nav>\n" +
"</header>\n" +
"<div class=\"home\">\n" +
"    <div class=\"content\"><h3 style=color:orange>Train Added Successfully...</h3></div>\n" +
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
        else
        {
            pw1.println("Insert unsuccess");
        }
     con.close();
     }
      catch(Exception e)
     { 
        pw1.println(e);
     }
   }
}