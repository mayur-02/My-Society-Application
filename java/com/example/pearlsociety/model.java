package com.example.pearlsociety;

public class model {
String name,phone,nameofguest,noguest,room,reason,filleddate,lastdate,status;
    public model(String name, String phone, String nameofguest, String noguest, String room, String reason, String filleddate, String lastdate, String status) {
        this.name=name;
        this.phone=phone;
        this.nameofguest=nameofguest;
        this.noguest=noguest;
        this.room=room;
        this.reason=reason;
        this.filleddate=filleddate;
        this.lastdate=lastdate;
        this.status=status;
    }

    public model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNameofguest() {
        return nameofguest;
    }

    public void setNameofguest(String nameofguest) {
        this.nameofguest = nameofguest;
    }

    public String getNoguest() {
        return noguest;
    }

    public void setNoguest(String noguest) {
        this.noguest = noguest;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFilleddate() {
        return filleddate;
    }

    public void setFilleddate(String filleddate) {
        this.filleddate = filleddate;
    }

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}



