

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import servlets.flightcompsignup;


public class flightcompregis extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        PrintWriter pw1 = response.getWriter();
        String cname = request.getParameter("fname"); 
        String cemail = request.getParameter("femail");
        String cpass = request.getParameter("fpassword");
        String creg = request.getParameter("fregisno");
        String csq = request.getParameter("fsecques");
        String can = request.getParameter("fanswer"); 
        flightcompsignup ob = new flightcompsignup();
        ob.setCnm(cname);
        ob.setCem(cemail);
        ob.setCpass(cpass);
        ob.setCregno(creg);
        ob.setCsq(csq);
        ob.setCan(can);
        
        boolean result=ob.Insert();
        if(result==true)
        {
            response.sendRedirect("thanks.html");
        }
        else
        {
            pw1.println("SIGNUP UNSUCESSFUL..PLEASE TRY AGAIN!!");
        }
           
        
    }

}
