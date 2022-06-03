package servlets;
import java.sql.*;

public class hotelcompsignup
{
    private String hnm;
    private String hem;
    private String hpass;
    private String hregno;
    private String hsq;
    private String han;

    public String getHnm() {
        return hnm;
    }

    public void setHnm(String hnm) {
        this.hnm = hnm;
    }

    public String getHem() {
        return hem;
    }

    public void setHem(String hem) {
        this.hem = hem;
    }

    public String getHpass() {
        return hpass;
    }

    public void setHpass(String hpass) {
        this.hpass = hpass;
    }

    public String getHregno() {
        return hregno;
    }

    public void setHregno(String hregno) {
        this.hregno = hregno;
    }

    public String getHsq() {
        return hsq;
    }

    public void setHsq(String hsq) {
        this.hsq = hsq;
    }

    public String getHan() {
        return han;
    }

    public void setHan(String han) {
        this.han = han;
    }
    
    public boolean Insert()
    {
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt = con.createStatement();
            String q1 = "insert into hotel_data values('"+hnm+"','"+hem+"','"+hpass+"','"+hregno+"','"+hsq+"','"+han+"')";
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