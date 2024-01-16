package com.example.travelmate;

import java.io.Serializable;

public class Statemodel implements Serializable {

   String accptedBy;
   String delete;
   String docId;
   String name;
   String sendedBy;
   String state;
   String uri;

    public Statemodel() {
    }

    public Statemodel(String accptedBy, String delete, String docId, String name, String sendedBy, String state, String uri) {
        this.accptedBy = accptedBy;
        this.delete = delete;
        this.docId = docId;
        this.name = name;
        this.sendedBy = sendedBy;
        this.state = state;
        this.uri = uri;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSendedBy() {
        return sendedBy;
    }

    public void setSendedBy(String sendedBy) {
        this.sendedBy = sendedBy;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
