package com.example.pearlsociety;

public class Complaintuserhelperclass {

    String name, phone, room, complaint,filleddate;

    public Complaintuserhelperclass() {

    }

    public Complaintuserhelperclass(String name, String phone, String room, String complaint, String filleddate) {
        this.name = name;
        this.phone = phone;
        this.room = room;
        this.complaint = complaint;
        this.filleddate = filleddate;
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getFilleddate() {
        return filleddate;
    }

    public void setFilleddate(String filleddate) {
        this.filleddate = filleddate;
    }
}
