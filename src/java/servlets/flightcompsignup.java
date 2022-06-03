package servlets;
import java.sql.*;
public class flightcompsignup
{
    private String cnm;
    private String cem;
    private String cpass;
    private String cregno;
    private String csq;
    private String can;

    public String getCnm() {
        return cnm;
    }

    public void setCnm(String cnm) {
        this.cnm = cnm;
    }

    public String getCem() {
        return cem;
    }

    public void setCem(String cem) {
        this.cem = cem;
    }

    public String getCpass() {
        return cpass;
    }

    public void setCpass(String cpass) {
        this.cpass = cpass;
    }

    public String getCregno() {
        return cregno;
    }

    public void setCregno(String cregno) {
        this.cregno = cregno;
    }

    public String getCsq() {
        return csq;
    }

    public void setCsq(String csq) {
        this.csq = csq;
    }

    public String getCan() {
        return can;
    }

    public void setCan(String can) {
        this.can = can;
    }
    
    public boolean Insert()
    {
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt = con.createStatement();
            String q1 = "insert into flight_data values('"+cnm+"','"+cem+"','"+cpass+"','"+cregno+"','"+csq+"','"+can+"')";
            int x = stmt.executeUpdate(q1);
            if(x>0)
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