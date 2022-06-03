

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import servlets.traincompsignup;



public class traincompregis extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        PrintWriter pw1 = response.getWriter();
        String cname = request.getParameter("tname"); 
        String cemail = request.getParameter("temail");
        String cpass = request.getParameter("tpassword");
        String creg = request.getParameter("tregisno");
        String csq = request.getParameter("tsecques");
        String can = request.getParameter("tanswer"); 
        traincompsignup ob = new traincompsignup();
        ob.setTnm(cname);
        ob.setTem(cemail);
        ob.setTpass(cpass);
        ob.setTregno(creg);
        ob.setTsq(csq);
        ob.setTan(can);
        
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
