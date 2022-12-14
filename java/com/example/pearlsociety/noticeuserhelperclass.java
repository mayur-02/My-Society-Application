package com.example.pearlsociety;

public class noticeuserhelperclass {
    String filleddate,notice,c;

    public noticeuserhelperclass() {
    }

    public noticeuserhelperclass(String filleddate, String notice, String c) {
        this.filleddate = filleddate;
        this.notice = notice;
        this.c =c;
    }

    public String getFilleddate() {
        return filleddate;
    }

    public void setFilleddate(String filleddate) {
        this.filleddate = filleddate;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
