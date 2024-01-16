package com.example.travelmate;

public class Paymentmodel {
   String acceptedby;
   String cardname;
   String cardnumber;
   String cvv;
   String date;
   String days;
   String docId;
   String drouppoint;
   String enddate;
   String pickuppoint;
   String price;
   String startdate;
   String username;
   String place;

    public Paymentmodel() {
    }

    public Paymentmodel(String acceptedby, String cardname, String cardnumber, String cvv, String date, String days, String docId, String drouppoint, String enddate, String pickuppoint, String price, String startdate, String username, String place) {
        this.acceptedby = acceptedby;
        this.cardname = cardname;
        this.cardnumber = cardnumber;
        this.cvv = cvv;
        this.date = date;
        this.days = days;
        this.docId = docId;
        this.drouppoint = drouppoint;
        this.enddate = enddate;
        this.pickuppoint = pickuppoint;
        this.price = price;
        this.startdate = startdate;
        this.username = username;
        this.place = place;
    }

    public String getAcceptedby() {
        return acceptedby;
    }

    public void setAcceptedby(String acceptedby) {
        this.acceptedby = acceptedby;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDrouppoint() {
        return drouppoint;
    }

    public void setDrouppoint(String drouppoint) {
        this.drouppoint = drouppoint;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getPickuppoint() {
        return pickuppoint;
    }

    public void setPickuppoint(String pickuppoint) {
        this.pickuppoint = pickuppoint;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
