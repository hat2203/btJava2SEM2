package assignment1.member;

public class MemberList {
    public String mId;
    public String mName;
    public String mEmail;
    public String mPhone;

    public MemberList() {
    }

    public MemberList(String mId, String mName, String mEmail, String mPhone) {
        this.mId = mId;
        this.mName = mName;
        this.mEmail = mEmail;
        this.mPhone = mPhone;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    @Override
    public String toString() {
        return getmId()+ " -- "+getmName()+" -- "+getmEmail()+" -- "+getmPhone();
    }
}
