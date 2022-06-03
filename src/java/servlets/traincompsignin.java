package servlets;
import java.sql.*;

public class traincompsignin
{
    private String temail;
    private String tpass;

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }

    public String getTpass() {
        return tpass;
    }

    public void setTpass(String tpass) {
        this.tpass = tpass;
    }
    
    public boolean CheckMethod()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt=con.createStatement();
            String q1="select * from train_data where temail='"+temail+"' and tpass='"+tpass+"'";
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