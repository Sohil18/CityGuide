package com.example.travelmate;

public class Bookingmodel {

   String Date;
   String Time;
   String accptedBy;
   String delete;
   String docId;
   String email;
   String guidename;
   String mobilenumber;
   String place;
   String username;

    public Bookingmodel() {
    }

    public Bookingmodel(String date, String time, String accptedBy, String delete, String docId, String email, String guidename, String mobilenumber, String place, String username) {
        Date = date;
        Time = time;
        this.accptedBy = accptedBy;
        this.delete = delete;
        this.docId = docId;
        this.email = email;
        this.guidename = guidename;
        this.mobilenumber = mobilenumber;
        this.place = place;
        this.username = username;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getAccptedBy() {
        return accptedBy;
    }

    public void setAccptedBy(String accptedBy) {
        this.accptedBy = accptedBy;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGuidename() {
        return guidename;
    }

    public void setGuidename(String guidename) {
        this.guidename = guidename;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
