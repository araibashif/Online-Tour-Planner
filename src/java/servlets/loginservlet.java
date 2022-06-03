
package servlets;

import java.sql.*;

public class loginservlet  {
    
    private String unm;
    private String pass;

    public String getUnm() {
        return unm;
    }

    public void setUnm(String unm) {
        this.unm = unm;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    
    
    

    public boolean CheckMethod()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rohit");
            Statement stmt=con.createStatement();
            String q1="select * from U_registration where u_nm='"+unm+"' and pass='"+pass+"' and status1='true'";
            ResultSet rs=stmt.executeQuery(q1);
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
            {}
        return false;
    
    }
    
}
