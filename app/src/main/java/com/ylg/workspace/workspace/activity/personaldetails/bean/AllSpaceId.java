package com.ylg.workspace.workspace.activity.personaldetails.bean;

import java.util.List;

public class AllSpaceId {

    /**
     * code : 200
     * msg : [{"spaceId":33,"spaceName":"333333333","spaceDescribe":"666666","city":"888888888888","spaceSite":"99999999999","fixPhone":"6666666","relationTel":"55555","spaceState":0,"creationTime":"2017-07-03 11:05","spacePicture":"[{\"site\":\"/static/images/1499310411164.jpeg\",\"fileName\":\"t01b27627722183b9a9.jpg\"},{\"site\":\"/static/images/1499310411337.jpeg\",\"fileName\":\"t015d638f5f951d11ff.jpg\"},{\"site\":\"/static/images/1499310411337.jpeg\",\"fileName\":\"t017e90d4dbfd98b66d.jpg\"}]","lng":116.336249,"lat":39.944999},{"spaceId":44,"spaceName":"7876","spaceDescribe":"343453","city":"21212","spaceSite":"7878782","fixPhone":"83983893","relationTel":"5453543","spaceState":0,"creationTime":"2017-07-03 16:37","spacePicture":"[{\"site\":\"/static/images/1499330301128.jpeg\",\"fileName\":\"37643-106.jpg\"}]"},{"spaceId":45,"spaceName":"353453","spaceDescribe":"783783","city":"893893","spaceSite":"53453","fixPhone":"87877883","relationTel":"434323","spaceState":0,"creationTime":"2017-07-04 16:38","spacePicture":"[{\"site\":\"/static/images/1499330331159.jpeg\",\"fileName\":\"BC35291AC7D23C8107D429230DAF4E0C.jpg\"}]"},{"spaceId":46,"spaceName":"12","spaceDescribe":"32","city":"456","spaceSite":"789","fixPhone":"5445","relationTel":"5654","spaceState":0,"creationTime":"2017-07-04 16:50","spacePicture":"[{\"site\":\"/default/6715660.jpg\",\"fileName\":\"9b0770.jpg\"}]"},{"spaceId":47,"spaceName":"54453","spaceDescribe":"453453453","city":"78378373","spaceSite":"453453","fixPhone":"13123","relationTel":"78783783","spaceState":0,"creationTime":"2017-06-25 17:11","spacePicture":"[{\"site\":\"/static/images/1499332297826.jpeg\",\"fileName\":\"20741-106.jpg\"}]"},{"spaceId":48,"spaceName":"3","spaceDescribe":"45","city":"73","spaceSite":"123","fixPhone":"783","relationTel":"453","spaceState":0,"creationTime":"2017-07-04 17:23","spacePicture":"[{\"site\":\"/static/images/1499333054735.jpeg\",\"fileName\":\"37644-106.jpg\"}]"},{"spaceId":49,"spaceName":"涨","spaceDescribe":"云","city":"已","spaceSite":"请问","fixPhone":"喂","relationTel":"喂","spaceState":1,"creationTime":"2017-06-27 18:22","spacePicture":"[{\"site\":\"/static/images/1499336559724.jpeg\",\"fileName\":\"6bd3a63df8dcd1009b22d444738b4710b9122f28.jpg\"}]"},{"spaceId":50,"spaceName":"涨","spaceDescribe":"云","city":"已","spaceSite":"请问","fixPhone":"喂","relationTel":"喂","spaceState":1,"creationTime":"2017-06-27 18:22","spacePicture":"[{\"site\":\"/static/images/1499336559724.jpeg\",\"fileName\":\"6bd3a63df8dcd1009b22d444738b4710b9122f28.jpg\"}]"},{"spaceId":51,"spaceName":"213","spaceDescribe":"53","city":"78","spaceSite":"345","fixPhone":"78","relationTel":"213","spaceState":0,"creationTime":"2017-07-06 18:23","spacePicture":"[{\"site\":\"/static/images/1499336609828.jpeg\",\"fileName\":\"9b0770540923dd54a804890dd009b3de9c824870.jpg\"}]"},{"spaceId":52,"spaceName":"666","spaceDescribe":"666","city":"666","spaceSite":"666","fixPhone":"666","relationTel":"666","spaceState":0,"creationTime":"2017-07-05 13:49","spacePicture":"[{\"site\":\"/static/images/1499665836681.jpg\",\"fileName\":\"30.jpg\"}]"},{"spaceId":53,"spaceName":" 温柔温柔","spaceDescribe":"温热我","city":"温柔温柔","spaceSite":"温柔温柔","fixPhone":"010101","relationTel":"101010","spaceState":0,"creationTime":"2017-07-11 18:16","spacePicture":"[{\"site\":\"/static/images/1499854676620.jpg\",\"fileName\":\"6bd3a63df8dcd1009b22d444738b4710b9122f28.jpg\"}]"}]
     */

    private String code;
    private List<MsgBean> msg;

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
         * spaceId : 33
         * spaceName : 333333333
         * spaceDescribe : 666666
         * city : 888888888888
         * spaceSite : 99999999999
         * fixPhone : 6666666
         * relationTel : 55555
         * spaceState : 0
         * creationTime : 2017-07-03 11:05
         * spacePicture : [{"site":"/static/images/1499310411164.jpeg","fileName":"t01b27627722183b9a9.jpg"},{"site":"/static/images/1499310411337.jpeg","fileName":"t015d638f5f951d11ff.jpg"},{"site":"/static/images/1499310411337.jpeg","fileName":"t017e90d4dbfd98b66d.jpg"}]
         * lng : 116.336249
         * lat : 39.944999
         */

        private int spaceId;
        private String spaceName;
        private String spaceDescribe;
        private String city;
        private String spaceSite;
        private String fixPhone;
        private String relationTel;
        private int spaceState;
        private String creationTime;
        private String spacePicture;
        private double lng;
        private double lat;

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

        public String getSpaceDescribe() {
            return spaceDescribe;
        }

        public void setSpaceDescribe(String spaceDescribe) {
            this.spaceDescribe = spaceDescribe;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getSpaceSite() {
            return spaceSite;
        }

        public void setSpaceSite(String spaceSite) {
            this.spaceSite = spaceSite;
        }

        public String getFixPhone() {
            return fixPhone;
        }

        public void setFixPhone(String fixPhone) {
            this.fixPhone = fixPhone;
        }

        public String getRelationTel() {
            return relationTel;
        }

        public void setRelationTel(String relationTel) {
            this.relationTel = relationTel;
        }

        public int getSpaceState() {
            return spaceState;
        }

        public void setSpaceState(int spaceState) {
            this.spaceState = spaceState;
        }

        public String getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(String creationTime) {
            this.creationTime = creationTime;
        }

        public String getSpacePicture() {
            return spacePicture;
        }

        public void setSpacePicture(String spacePicture) {
            this.spacePicture = spacePicture;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }
    }
}
