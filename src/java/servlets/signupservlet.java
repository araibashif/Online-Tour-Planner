package servlets;

import java.sql.*;
public class signupservlet{
    
    private String fnm;
    private String mnm;
    private String lnm;
    private String unm;
    private String em;
    private String ps;
    private String dob;
    private String sq;
    private String ans;

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }
    
    
    
    public String getFnm() {
        return fnm;
    }

    public void setFnm(String fnm) {
        this.fnm = fnm;
    }

    public String getMnm() {
        return mnm;
    }

    public void setMnm(String mnm) {
        this.mnm = mnm;
    }

    public String getLnm() {
        return lnm;
    }

    public void setLnm(String lnm) {
        this.lnm = lnm;
    }

    public String getUnm() {
        return unm;
    }

    public void setUnm(String unm) {
        this.unm = unm;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSq() {
        return sq;
    }

    public void setSq(String sq) {
        this.sq = sq;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
    public boolean InsertMethod(){

        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","system");
            Statement stmt = con.createStatement();
            String q1 = "insert into U_registration values('"+fnm+"','"+mnm+"','"+lnm+"','"+unm+"','"+em+"','"+dob+"','"+ps+"','"+sq+"','"+ans+"','false','false')";
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

