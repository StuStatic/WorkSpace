package com.ylg.workspace.workspace.activity.personaldetails.bean;



public class Activity {

    public Activity(String name, String time, String address, String state) {
        this.name = name;
        this.time = time;
        this.address = address;
        this.state = state;
    }

    /**
     * name :
     * time :
     * address :
     * state :
     */

    private String name;
    private String time;
    private String address;
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
