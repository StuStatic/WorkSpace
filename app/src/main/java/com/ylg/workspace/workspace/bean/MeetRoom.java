package com.ylg.workspace.workspace.bean;

import java.util.List;

/**
 * Created by stu on 2017/7/24.
 */

public class MeetRoom {

    /**
     * result : 鎴愬姛
     * msg : [{"conferenceDescribe":"澶э紝寰堝ぇ","conferenceId":17,"conferenceName":"澶у彾瀛愪細璁","conferencePicture":"/static/images/conference/1500630808114.jpg","conferencePrice":80,"conferenceState":0,"conferenceType":0,"location":"2妤糲鍖�","openTime":"8:00-23:00","spaceId":69,"spared1":"","spared2":"","spared3":""}]
     * code : 200
     */

    private String result;
    private String code;
    private List<MsgEntity> msg;

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

    public List<MsgEntity> getMsg() {
        return msg;
    }

    public void setMsg(List<MsgEntity> msg) {
        this.msg = msg;
    }

    public static class MsgEntity {
        /**
         * conferenceDescribe : 澶э紝寰堝ぇ
         * conferenceId : 17
         * conferenceName : 澶у彾瀛愪細璁
         * conferencePicture : /static/images/conference/1500630808114.jpg
         * conferencePrice : 80.0
         * conferenceState : 0
         * conferenceType : 0
         * location : 2妤糲鍖�
         * openTime : 8:00-23:00
         * spaceId : 69
         * spared1 :
         * spared2 :
         * spared3 :
         */

        private String conferenceDescribe;
        private int conferenceId;
        private String conferenceName;
        private String conferencePicture;
        private double conferencePrice;
        private int conferenceState;
        private int conferenceType;
        private String location;
        private String openTime;
        private int spaceId;
        private String spared1;
        private String spared2;
        private String spared3;

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
