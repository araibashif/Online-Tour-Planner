package servlets;
import java.sql.*;

public class traincompsignup
{
    private String tnm;
    private String tem;
    private String tpass;
    private String tregno;
    private String tsq;
    private String tan;

    public String getTnm() {
        return tnm;
    }

    public void setTnm(String tnm) {
        this.tnm = tnm;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getTpass() {
        return tpass;
    }

    public void setTpass(String tpass) {
        this.tpass = tpass;
    }

    public String getTregno() {
        return tregno;
    }

    public void setTregno(String tregno) {
        this.tregno = tregno;
    }

    public String getTsq() {
        return tsq;
    }

    public void setTsq(String tsq) {
        this.tsq = tsq;
    }

    public String getTan() {
        return tan;
    }

    public void setTan(String tan) {
        this.tan = tan;
    }
    
    public boolean Insert()
    {
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt = con.createStatement();
            String q1 = "insert into train_data values('"+tnm+"','"+tem+"','"+tpass+"','"+tregno+"','"+tsq+"','"+tan+"')";
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