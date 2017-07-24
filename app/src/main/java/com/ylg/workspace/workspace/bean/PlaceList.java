package com.ylg.workspace.workspace.bean;

import java.util.List;

/**
 * Created by stu on 2017/7/24.
 */

public class PlaceList {

    /**
     * msg : [{"siteId":47,"siteName":"涓巺","siteDescribe":"200骞冲ぇ闈㈢Н","sitePicture":"/static/images/1500630937199.jpg","peopleNum":100,"openTime":"鍏ㄥぉ","spaceId":69,"location":"浜屾ゼA鍖�","siteState":0,"sitePrice":200,"siteType":0}]
     * result : 鎴愬姛
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
         * siteId : 47
         * siteName : 涓巺
         * siteDescribe : 200骞冲ぇ闈㈢Н
         * sitePicture : /static/images/1500630937199.jpg
         * peopleNum : 100
         * openTime : 鍏ㄥぉ
         * spaceId : 69
         * location : 浜屾ゼA鍖�
         * siteState : 0
         * sitePrice : 200.0
         * siteType : 0
         */

        private int siteId;
        private String siteName;
        private String siteDescribe;
        private String sitePicture;
        private int peopleNum;
        private String openTime;
        private int spaceId;
        private String location;
        private int siteState;
        private double sitePrice;
        private int siteType;

        public int getSiteId() {
            return siteId;
        }

        public void setSiteId(int siteId) {
            this.siteId = siteId;
        }

        public String getSiteName() {
            return siteName;
        }

        public void setSiteName(String siteName) {
            this.siteName = siteName;
        }

        public String getSiteDescribe() {
            return siteDescribe;
        }

        public void setSiteDescribe(String siteDescribe) {
            this.siteDescribe = siteDescribe;
        }

        public String getSitePicture() {
            return sitePicture;
        }

        public void setSitePicture(String sitePicture) {
            this.sitePicture = sitePicture;
        }

        public int getPeopleNum() {
            return peopleNum;
        }

        public void setPeopleNum(int peopleNum) {
            this.peopleNum = peopleNum;
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

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getSiteState() {
            return siteState;
        }

        public void setSiteState(int siteState) {
            this.siteState = siteState;
        }

        public double getSitePrice() {
            return sitePrice;
        }

        public void setSitePrice(double sitePrice) {
            this.sitePrice = sitePrice;
        }

        public int getSiteType() {
            return siteType;
        }

        public void setSiteType(int siteType) {
            this.siteType = siteType;
        }
    }
}
