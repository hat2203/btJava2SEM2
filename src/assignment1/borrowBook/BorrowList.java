package assignment1.borrowBook;


public class BorrowList{
    public String mName;
    public String bName;
    public String date;
    public String status;

    public BorrowList() {
    }

    public BorrowList(String mName, String bName, String date, String status) {
        this.mName = mName;
        this.bName = bName;
        this.date = date;
        this.status = status;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Name: "+getmName()+" -- Book: "+getbName()+" -- Date: "+getDate()+" -- "+getStatus();
    }
}
