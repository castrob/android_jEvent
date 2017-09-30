package com.example.castrob.joutevents;

import java.io.Serializable;
import java.util.List;

/**
 * Created by castro on 15/09/17.
 */

public class Event implements Serializable {

    private String eventName;
    private String dateBegin;
    private String dateEnd;
    private Invitee organizer;
    private List<Invitee> inviteeList;

    public Event(String eventName, String dateBegin, String dateEnd, Invitee organizer, List<Invitee> inviteeList) {
        this.eventName = eventName;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.organizer = organizer;
        this.inviteeList = inviteeList;
    }

    public String getEventName() {return eventName;}

    public void setEventName(String eventName) {this.eventName = eventName;}

    public String getDateBegin() {return dateBegin;}

    public void setDateBegin(String dateBegin) {this.dateBegin = dateBegin;}

    public String getDateEnd() {return dateEnd;}

    public void setDateEnd(String dateEnd) {this.dateEnd = dateEnd;}

    public Invitee getOrganizer() {return organizer;}

    public void setOrganizer(Invitee organizer) {this.organizer = organizer;}

    public List<Invitee> getInviteeList() {return inviteeList;}

    public void setInviteeList(List<Invitee> inviteeList) {this.inviteeList = inviteeList;}
}
