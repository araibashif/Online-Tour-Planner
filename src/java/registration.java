

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlets.signupservlet;


public class registration extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        PrintWriter pw1 = response.getWriter();
        String fname = request.getParameter("fn"); 
        String mname = request.getParameter("mn"); 
        String lname = request.getParameter("ln"); 
        String uname = request.getParameter("usernm");
        String em = request.getParameter("email");
        String dob = request.getParameter("DOB");
        String password = request.getParameter("password"); 
        String sq = request.getParameter("secques");
        String ans =request.getParameter("answer"); 
        signupservlet ob = new signupservlet();
        ob.setFnm(fname);
        ob.setMnm(mname);
        ob.setLnm(lname);
        ob.setUnm(uname);
        ob.setEm(em);
        ob.setPs(password);
        ob.setDob(dob);
        ob.setSq(sq);
        ob.setAns(ans);
        
        boolean result=ob.InsertMethod();
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
