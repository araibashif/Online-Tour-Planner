

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import servlets.hotelcompsignup;



public class hotelcompregis extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        PrintWriter pw1 = response.getWriter();
        String cname = request.getParameter("hname"); 
        String cemail = request.getParameter("hemail");
        String cpass = request.getParameter("hpassword");
        String creg = request.getParameter("hregisno");
        String csq = request.getParameter("hsecques");
        String can = request.getParameter("hanswer"); 
        hotelcompsignup ob = new hotelcompsignup();
        ob.setHnm(cname);
        ob.setHem(cemail);
        ob.setHpass(cpass);
        ob.setHregno(creg);
        ob.setHsq(csq);
        ob.setHan(can);
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
