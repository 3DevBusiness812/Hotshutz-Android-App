package com.alpha.posapp.bean;


public class EventItem {

    private String eventname, vanues,location,id;



    public EventItem(String eventname, String id) {
        this.eventname = eventname;
        this.id = id;

    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getVanues() {
        return vanues;
    }

    public void setVanues(String vanues) {
        this.vanues = vanues;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
