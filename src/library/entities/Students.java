package library.entities;

public class Students {
    public Integer sId;
    public String sName;
    public String sEmail;
    public String sTel;

    public Students() {
    }

    public Students(Integer sId, String sName, String sEmail, String sTel) {
        this.sId = sId;
        this.sName = sName;
        this.sEmail = sEmail;
        this.sTel = sTel;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsTel() {
        return sTel;
    }

    public void setsTel(String sTel) {
        this.sTel = sTel;
    }
}
