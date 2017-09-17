package com.example.castrob.joutevents;

import java.io.Serializable;

/**
 * Created by castro on 9/14/17.
 */

public class Invitee implements Serializable{

    private String name;
    private String contact;
    private String email;

    public Invitee(){
        this.name = "";
        this.contact = "";
        this.email = "";
    }

    public Invitee(String name, String contact, String email){
        this.name = name;
        this.contact = contact;
        this.email = email;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getContact() {return contact;}
    public void setContact(String contact) { this.contact = contact; }
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}


}
