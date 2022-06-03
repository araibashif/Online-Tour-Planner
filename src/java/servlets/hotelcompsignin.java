package servlets;
import java.sql.*;

public class hotelcompsignin
{
    private String hemail;
    private String hpass;

    public String getHemail() {
        return hemail;
    }

    public void setHemail(String hemail) {
        this.hemail = hemail;
    }

    public String getHpass() {
        return hpass;
    }

    public void setHpass(String hpass) {
        this.hpass = hpass;
    }
    
    public boolean CheckMethod()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt=con.createStatement();
            String q1="select * from hotel_data where hemail='"+hemail+"' and hpass='"+hpass+"'";
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