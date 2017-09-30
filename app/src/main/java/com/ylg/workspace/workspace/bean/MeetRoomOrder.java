package com.ylg.workspace.workspace.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class MeetRoomOrder {
    @Override
    public String toString() {
        return "MeetRoomOrder{" +
                "result='" + result + '\'' +
                ", code='" + code + '\'' +
                ", msg=" + msg +
                '}';
    }

    /**
     * result : 鎴愬姛
     * code : 200
     * msg : [{"company":"澶у彾瀛愪細璁","conferenceDescribe":"","conferenceDetailsId":130,"conferenceId":17,"conferenceName":"","conferencePrice":0,"conferenceState":1,"conferenceTime":"2017/09/28 17:09:41","endTime":"2017/09/28 08:30:00","location":"","openTime":"","payState":1,"people":"","spaceId":69,"spaceName":"鏂瑰渾澶у帵浼樺宸ュ満","startTime":"2017/09/28 08:00:00"},{"company":"澶у彾瀛愪細璁","conferenceDescribe":"","conferenceDetailsId":131,"conferenceId":17,"conferenceName":"","conferencePrice":0,"conferenceState":1,"conferenceTime":"2017/09/28 17:09:41","endTime":"2017/09/28 08:30:00","location":"","openTime":"","payState":1,"people":"","spaceId":69,"spaceName":"鏂瑰渾澶у帵浼樺宸ュ満","startTime":"2017/09/28 08:00:00"},{"company":"澶у彾瀛愪細璁","conferenceDescribe":"","conferenceDetailsId":134,"conferenceId":17,"conferenceName":"","conferencePrice":0,"conferenceState":1,"conferenceTime":"2017/09/28 17:23:57","endTime":"2017/09/28 12:30:00","location":"","openTime":"","payState":1,"people":"","spaceId":69,"spaceName":"鏂瑰渾澶у帵浼樺宸ュ満","startTime":"2017/09/28 12:00:00"},{"company":"","conferenceDescribe":"","conferenceDetailsId":142,"conferenceId":17,"conferenceName":"","conferencePrice":0,"conferenceState":1,"conferenceTime":"2017/09/28 18:37:06","endTime":"2017/09/28 11:30:00","location":"","openTime":"","payState":1,"people":"","spaceId":69,"spaceName":"","startTime":"2017/09/28 09:30:00"},{"company":"","conferenceDescribe":"","conferenceDetailsId":143,"conferenceId":17,"conferenceName":"","conferencePrice":0,"conferenceState":1,"conferenceTime":"2017/09/28 18:54:11","endTime":"2017/09/28 09:30:00","location":"","openTime":"","payState":1,"people":"","spaceId":69,"spaceName":"","startTime":"2017/09/28 08:30:00"},{"company":"","conferenceDescribe":"","conferenceDetailsId":144,"conferenceId":17,"conferenceName":"","conferencePrice":0,"conferenceState":1,"conferenceTime":"2017/09/28 18:55:27","endTime":"2017/09/28 14:30:00","location":"","openTime":"","payState":1,"people":"","spaceId":69,"spaceName":"","startTime":"2017/09/28 12:30:00"}]
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
        @Override
        public String toString() {
            return "MsgBean{" +
                    "company='" + company + '\'' +
                    ", conferenceDescribe='" + conferenceDescribe + '\'' +
                    ", conferenceDetailsId=" + conferenceDetailsId +
                    ", conferenceId=" + conferenceId +
                    ", conferenceName='" + conferenceName + '\'' +
                    ", conferencePrice=" + conferencePrice +
                    ", conferenceState=" + conferenceState +
                    ", conferenceTime='" + conferenceTime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", location='" + location + '\'' +
                    ", openTime='" + openTime + '\'' +
                    ", payState=" + payState +
                    ", people='" + people + '\'' +
                    ", spaceId=" + spaceId +
                    ", spaceName='" + spaceName + '\'' +
                    ", startTime='" + startTime + '\'' +
                    '}';
        }

        /**
         * company : 澶у彾瀛愪細璁
         * conferenceDescribe :
         * conferenceDetailsId : 130
         * conferenceId : 17
         * conferenceName :
         * conferencePrice : 0.0
         * conferenceState : 1
         * conferenceTime : 2017/09/28 17:09:41
         * endTime : 2017/09/28 08:30:00
         * location :
         * openTime :
         * payState : 1
         * people :
         * spaceId : 69
         * spaceName : 鏂瑰渾澶у帵浼樺宸ュ満
         * startTime : 2017/09/28 08:00:00
         */

        private String company;
        private String conferenceDescribe;
        private int conferenceDetailsId;
        private int conferenceId;
        private String conferenceName;
        private double conferencePrice;
        private int conferenceState;
        private String conferenceTime;
        private String endTime;
        private String location;
        private String openTime;
        private int payState;
        private String people;
        private int spaceId;
        private String spaceName;
        private String startTime;

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getConferenceDescribe() {
            return conferenceDescribe;
        }

        public void setConferenceDescribe(String conferenceDescribe) {
            this.conferenceDescribe = conferenceDescribe;
        }

        public int getConferenceDetailsId() {
            return conferenceDetailsId;
        }

        public void setConferenceDetailsId(int conferenceDetailsId) {
            this.conferenceDetailsId = conferenceDetailsId;
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

        public String getConferenceTime() {
            return conferenceTime;
        }

        public void setConferenceTime(String conferenceTime) {
            this.conferenceTime = conferenceTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
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

        public int getPayState() {
            return payState;
        }

        public void setPayState(int payState) {
            this.payState = payState;
        }

        public String getPeople() {
            return people;
        }

        public void setPeople(String people) {
            this.people = people;
        }

        public int getSpaceId() {
            return spaceId;
        }

        public void setSpaceId(int spaceId) {
            this.spaceId = spaceId;
        }

        public String getSpaceName() {
            return spaceName;
        }

        public void setSpaceName(String spaceName) {
            this.spaceName = spaceName;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }
    }
}
