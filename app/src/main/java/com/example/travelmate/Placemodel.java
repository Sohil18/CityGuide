package com.example.travelmate;

import java.io.Serializable;

public class Placemodel implements Serializable {

   String avability;
   String delete;
   String description;
   String dirstic;
   String docId;
  String guidname;
   String language;
   String name;
   String place;
   String price;
   String sendedBy;
   String service;
   String state;
   String topic;
   String uri;

    public Placemodel() {
    }

    public Placemodel(String avability, String delete, String description, String dirstic, String docId, String guidname, String language, String name, String place, String price, String sendedBy, String service, String state, String topic, String uri) {
        this.avability = avability;
        this.delete = delete;
        this.description = description;
        this.dirstic = dirstic;
        this.docId = docId;
        this.guidname = guidname;
        this.language = language;
        this.name = name;
        this.place = place;
        this.price = price;
        this.sendedBy = sendedBy;
        this.service = service;
        this.state = state;
        this.topic = topic;
        this.uri = uri;
    }

    public String getAvability() {
        return avability;
    }

    public void setAvability(String avability) {
        this.avability = avability;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirstic() {
        return dirstic;
    }

    public void setDirstic(String dirstic) {
        this.dirstic = dirstic;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getGuidname() {
        return guidname;
    }

    public void setGuidname(String guidname) {
        this.guidname = guidname;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSendedBy() {
        return sendedBy;
    }

    public void setSendedBy(String sendedBy) {
        this.sendedBy = sendedBy;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
