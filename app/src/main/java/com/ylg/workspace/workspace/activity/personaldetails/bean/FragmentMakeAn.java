package com.ylg.workspace.workspace.activity.personaldetails.bean;



public class FragmentMakeAn {

    public FragmentMakeAn(String address, String name, String time, String reason, String type) {
        this.address = address;
        this.name = name;
        this.time = time;
        this.reason = reason;
        this.type = type;
    }

    /**
     * address :
     * name :
     * time :
     * reason :
     * type :
     */

    private String address;
    private String name;
    private String time;
    private String reason;
    private String type;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
