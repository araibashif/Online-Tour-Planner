package servlets;
import java.sql.*;

public class flightcompsignin
{
    private String femail;
    private String fpass;

    public String getFemail() {
        return femail;
    }

    public void setFemail(String femail) {
        this.femail = femail;
    }

    public String getFpass() {
        return fpass;
    }

    public void setFpass(String fpass) {
        this.fpass = fpass;
    }
    
    public boolean CheckMethod()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt=con.createStatement();
            String q1="select * from flight_data where cemail='"+femail+"' and cpass='"+fpass+"'";
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