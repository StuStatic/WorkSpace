package com.ylg.workspace.workspace.bean;

import java.util.List;

/**
 * Created by stu on 2017/7/19.
 */

public class SpaceList {

    /**
     * result : 成功
     * code : 200
     * msg : [{"city":"北京","creationTime":"2017/07/07 13:43:09","fixPhone":"010-333333","lat":0,"lng":0,"relationTel":"133333333","spaceDescribe":"测试3","spaceId":56,"spaceName":"阳光100优客工场","spacePicture":"/default/6715660.jpg","spaceSite":"北京丰台","spaceStar":"","spaceState":0,"spaceUrl":"","spared1":"","spared2":"","spared3":""},{"city":"北京","creationTime":"2017/07/02 13:44:34","fixPhone":"010-44444444","lat":0,"lng":0,"relationTel":"14444444444","spaceDescribe":"测试4","spaceId":57,"spaceName":"海龙大厦优客工场","spacePicture":"/default/6715660.jpg","spaceSite":"北京朝阳","spaceStar":"","spaceState":0,"spaceUrl":"","spared1":"","spared2":"","spared3":""},{"city":"北京","creationTime":"2016/07/06 14:02:39","fixPhone":"010-11111111111","lat":0,"lng":0,"relationTel":"11111111111111","spaceDescribe":"测试1","spaceId":58,"spaceName":"方圆大厦优客工场","spacePicture":"/default/6715660.jpg","spaceSite":"北京海淀","spaceStar":"","spaceState":1,"spaceUrl":"","spared1":"","spared2":"","spared3":""}]
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
         * city : 北京
         * creationTime : 2017/07/07 13:43:09
         * fixPhone : 010-333333
         * lat : 0.0
         * lng : 0.0
         * relationTel : 133333333
         * spaceDescribe : 测试3
         * spaceId : 56
         * spaceName : 阳光100优客工场
         * spacePicture : /default/6715660.jpg
         * spaceSite : 北京丰台
         * spaceStar :
         * spaceState : 0
         * spaceUrl :
         * spared1 :
         * spared2 :
         * spared3 :
         */

        private String city;
        private String creationTime;
        private String fixPhone;
        private double lat;
        private double lng;
        private String relationTel;
        private String spaceDescribe;
        private int spaceId;
        private String spaceName;
        private String spacePicture;
        private String spaceSite;
        private String spaceStar;
        private int spaceState;
        private String spaceUrl;
        private String spared1;
        private String spared2;
        private String spared3;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(String creationTime) {
            this.creationTime = creationTime;
        }

        public String getFixPhone() {
            return fixPhone;
        }

        public void setFixPhone(String fixPhone) {
            this.fixPhone = fixPhone;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public String getRelationTel() {
            return relationTel;
        }

        public void setRelationTel(String relationTel) {
            this.relationTel = relationTel;
        }

        public String getSpaceDescribe() {
            return spaceDescribe;
        }

        public void setSpaceDescribe(String spaceDescribe) {
            this.spaceDescribe = spaceDescribe;
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

        public String getSpacePicture() {
            return spacePicture;
        }

        public void setSpacePicture(String spacePicture) {
            this.spacePicture = spacePicture;
        }

        public String getSpaceSite() {
            return spaceSite;
        }

        public void setSpaceSite(String spaceSite) {
            this.spaceSite = spaceSite;
        }

        public String getSpaceStar() {
            return spaceStar;
        }

        public void setSpaceStar(String spaceStar) {
            this.spaceStar = spaceStar;
        }

        public int getSpaceState() {
            return spaceState;
        }

        public void setSpaceState(int spaceState) {
            this.spaceState = spaceState;
        }

        public String getSpaceUrl() {
            return spaceUrl;
        }

        public void setSpaceUrl(String spaceUrl) {
            this.spaceUrl = spaceUrl;
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
