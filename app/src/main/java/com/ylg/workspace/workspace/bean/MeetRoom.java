package com.ylg.workspace.workspace.bean;

import java.util.List;

/**
 * Created by stu on 2017/7/24.
 */

public class MeetRoom {


    /**
     * result : 鎴愬姛
     * code : 200
     * msg : [{"area":0,"conferenceDescribe":"澶э紝寰堝ぇ","conferenceId":17,"conferenceName":"澶у彾瀛愪細璁","conferencePicture":"/static/images/conference/15065799114270.jpg","conferencePrice":60,"conferenceState":1,"conferenceType":0,"facility":"","location":"2妤糲鍖�","openTime":"08:00-21:00","peopleNum":0,"spaceId":69,"spared1":"","spared2":"","spared3":""},{"area":0,"conferenceDescribe":"30浜�","conferenceId":59,"conferenceName":"绗竴浼氳瀹�","conferencePicture":"/static/images/conference/15065799207120.jpg","conferencePrice":30,"conferenceState":0,"conferenceType":0,"facility":"","location":"A鍖�","openTime":"08:00-22:00","peopleNum":0,"spaceId":69,"spared1":"","spared2":"","spared3":""},{"area":0,"conferenceDescribe":"15浜�","conferenceId":60,"conferenceName":"绗簩浼氳瀹�","conferencePicture":"/static/images/conference/15065799328620.jpg","conferencePrice":30,"conferenceState":0,"conferenceType":0,"facility":"","location":"浜屾ゼD鍖�","openTime":"08:00-23:00","peopleNum":0,"spaceId":69,"spared1":"","spared2":"","spared3":""}]
     */

    private String result;
    private String code;
    private List<MsgBean> msg;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<MsgBean> getMsg() {
        return msg;
    }

    public void setMsg(List<MsgBean> msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * area : 0.0
         * conferenceDescribe : 澶э紝寰堝ぇ
         * conferenceId : 17
         * conferenceName : 澶у彾瀛愪細璁
         * conferencePicture : /static/images/conference/15065799114270.jpg
         * conferencePrice : 60.0
         * conferenceState : 1
         * conferenceType : 0
         * facility :
         * location : 2妤糲鍖�
         * openTime : 08:00-21:00
         * peopleNum : 0
         * spaceId : 69
         * spared1 :
         * spared2 :
         * spared3 :
         */

        private double area;
        private String conferenceDescribe;
        private int conferenceId;
        private String conferenceName;
        private String conferencePicture;
        private double conferencePrice;
        private int conferenceState;
        private int conferenceType;
        private String facility;
        private String location;
        private String openTime;
        private int peopleNum;
        private int spaceId;
        private String spared1;
        private String spared2;
        private String spared3;

        public double getArea() {
            return area;
        }

        public void setArea(double area) {
            this.area = area;
        }

        public String getConferenceDescribe() {
            return conferenceDescribe;
        }

        public void setConferenceDescribe(String conferenceDescribe) {
            this.conferenceDescribe = conferenceDescribe;
        }

        public int getConferenceId() {
            return conferenceId;
        }

        public void setConferenceId(int conferenceId) {
            this.conferenceId = conferenceId;
        }

        public String getConferenceName() {
            return conferenceName;
        }

        public void setConferenceName(String conferenceName) {
            this.conferenceName = conferenceName;
        }

        public String getConferencePicture() {
            return conferencePicture;
        }

        public void setConferencePicture(String conferencePicture) {
            this.conferencePicture = conferencePicture;
        }

        public double getConferencePrice() {
            return conferencePrice;
        }

        public void setConferencePrice(double conferencePrice) {
            this.conferencePrice = conferencePrice;
        }

        public int getConferenceState() {
            return conferenceState;
        }

        public void setConferenceState(int conferenceState) {
            this.conferenceState = conferenceState;
        }

        public int getConferenceType() {
            return conferenceType;
        }

        public void setConferenceType(int conferenceType) {
            this.conferenceType = conferenceType;
        }

        public String getFacility() {
            return facility;
        }

        public void setFacility(String facility) {
            this.facility = facility;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getOpenTime() {
            return openTime;
        }

        public void setOpenTime(String openTime) {
            this.openTime = openTime;
        }

        public int getPeopleNum() {
            return peopleNum;
        }

        public void setPeopleNum(int peopleNum) {
            this.peopleNum = peopleNum;
        }

        public int getSpaceId() {
            return spaceId;
        }

        public void setSpaceId(int spaceId) {
            this.spaceId = spaceId;
        }

        public String getSpared1() {
            return spared1;
        }

        public void setSpared1(String spared1) {
            this.spared1 = spared1;
        }

        public String getSpared2() {
            return spared2;
        }

        public void setSpared2(String spared2) {
            this.spared2 = spared2;
        }

        public String getSpared3() {
            return spared3;
        }

        public void setSpared3(String spared3) {
            this.spared3 = spared3;
        }
    }
}
