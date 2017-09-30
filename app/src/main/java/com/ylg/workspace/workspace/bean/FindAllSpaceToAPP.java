package com.ylg.workspace.workspace.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/28.
 */

public class FindAllSpaceToAPP {

    /**
     * result : 成功
     * code : 200
     * msg : [{"cityList":[{"appId":"c81e728d9d4c2f636f067f89cc14862c","city":"北京市","creationTime":"2017/06/26 17:50:28","fixPhone":"010-666666","lat":110.348728,"leaseConditions":60,"lng":20.024157,"longRent":0,"relationTel":"18888888888","shortRent":0,"spaceDescribe":"方圆大厦优客工场社区","spaceId":69,"spaceName":"方圆大厦优客工场","spacePicture":"/static/images/space/15065801002420.jpg","spaceSite":"中关村南大街甲56号","spaceStar":0,"spaceState":0,"spaceUrl":"","spared1":"","spared2":"","spared3":"2","stationNum":82,"alreadyTakenNum":31,"stationPrice":100},{"appId":"c81e728d9d4c2f636f067f89cc14862c","city":"北京市","creationTime":"2017/08/28 15:55:02","fixPhone":"0102978558","lat":116.463328,"leaseConditions":20,"lng":39.917029,"longRent":0,"relationTel":"18855559999","shortRent":0,"spaceDescribe":"简约生态现代风","spaceId":126,"spaceName":"中海广场国贸店","spacePicture":"/static/images/space/15065659444400.jpg","spaceSite":" 北京市朝阳区光华东里8号院中海广场北楼F1-03单元","spaceStar":0,"spaceState":0,"spaceUrl":"","spared1":"","spared2":"","spared3":"2","stationNum":30,"alreadyTakenNum":0,"stationPrice":120}],"cityName":"北京市"},{"cityList":[{"appId":"c81e728d9d4c2f636f067f89cc14862c","city":"海南市","creationTime":"2017/08/07 10:29:36","fixPhone":"1888888888","lat":116.280506,"leaseConditions":60,"lng":39.959418,"longRent":0,"relationTel":"1555555555","shortRent":0,"spaceDescribe":"海南数据中心研究院","spaceId":83,"spaceName":"海南数据谷","spacePicture":"/static/images/space/15065055229700.jpg","spaceSite":"海口市美兰区国兴大道5号海南大厦裙楼","spaceStar":0,"spaceState":0,"spaceUrl":"","spared1":"","spared2":"","spared3":"1","stationNum":768,"alreadyTakenNum":19,"stationPrice":200}],"cityName":"海南市"},{"cityList":[{"appId":"c81e728d9d4c2f636f067f89cc14862c","city":"上海市","creationTime":"2017/05/28 13:45:36","fixPhone":"0102546985","lat":116.338888,"leaseConditions":30,"lng":39.945388,"longRent":0,"relationTel":"18320411032","shortRent":0,"spaceDescribe":"意大利建筑风","spaceId":128,"spaceName":"上海静安店","spacePicture":"/static/images/space/15065802932370.jpg","spaceSite":"上海市静安区虬江路1538号","spaceStar":0,"spaceState":0,"spaceUrl":"","spared1":"","spared2":"","spared3":"2","stationNum":10,"alreadyTakenNum":0,"stationPrice":200}],"cityName":"上海市"},{"cityList":[{"appId":"c81e728d9d4c2f636f067f89cc14862c","city":"天津市","creationTime":"2017/08/28 14:42:44","fixPhone":"18855559999","lat":116.338888,"leaseConditions":30,"lng":39.945388,"longRent":0,"relationTel":"15588889999","shortRent":0,"spaceDescribe":"现代简约风","spaceId":117,"spaceName":"天津智慧山店","spacePicture":"/static/images/space/15065803972690.jpg","spaceSite":"天津市西青区开华道智慧山南塔3层","spaceStar":0,"spaceState":0,"spaceUrl":"","spared1":"","spared2":"","spared3":"2","stationNum":20,"alreadyTakenNum":1,"stationPrice":150}],"cityName":"天津市"}]
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
         * cityList : [{"appId":"c81e728d9d4c2f636f067f89cc14862c","city":"北京市","creationTime":"2017/06/26 17:50:28","fixPhone":"010-666666","lat":110.348728,"leaseConditions":60,"lng":20.024157,"longRent":0,"relationTel":"18888888888","shortRent":0,"spaceDescribe":"方圆大厦优客工场社区","spaceId":69,"spaceName":"方圆大厦优客工场","spacePicture":"/static/images/space/15065801002420.jpg","spaceSite":"中关村南大街甲56号","spaceStar":0,"spaceState":0,"spaceUrl":"","spared1":"","spared2":"","spared3":"2","stationNum":82,"alreadyTakenNum":31,"stationPrice":100},{"appId":"c81e728d9d4c2f636f067f89cc14862c","city":"北京市","creationTime":"2017/08/28 15:55:02","fixPhone":"0102978558","lat":116.463328,"leaseConditions":20,"lng":39.917029,"longRent":0,"relationTel":"18855559999","shortRent":0,"spaceDescribe":"简约生态现代风","spaceId":126,"spaceName":"中海广场国贸店","spacePicture":"/static/images/space/15065659444400.jpg","spaceSite":" 北京市朝阳区光华东里8号院中海广场北楼F1-03单元","spaceStar":0,"spaceState":0,"spaceUrl":"","spared1":"","spared2":"","spared3":"2","stationNum":30,"alreadyTakenNum":0,"stationPrice":120}]
         * cityName : 北京市
         */

        private String cityName;
        private List<CityListBean> cityList;

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public List<CityListBean> getCityList() {
            return cityList;
        }

        public void setCityList(List<CityListBean> cityList) {
            this.cityList = cityList;
        }

        public static class CityListBean {
            /**
             * appId : c81e728d9d4c2f636f067f89cc14862c
             * city : 北京市
             * creationTime : 2017/06/26 17:50:28
             * fixPhone : 010-666666
             * lat : 110.348728
             * leaseConditions : 60
             * lng : 20.024157
             * longRent : 0
             * relationTel : 18888888888
             * shortRent : 0
             * spaceDescribe : 方圆大厦优客工场社区
             * spaceId : 69
             * spaceName : 方圆大厦优客工场
             * spacePicture : /static/images/space/15065801002420.jpg
             * spaceSite : 中关村南大街甲56号
             * spaceStar : 0
             * spaceState : 0
             * spaceUrl :
             * spared1 :
             * spared2 :
             * spared3 : 2
             * stationNum : 82
             * alreadyTakenNum : 31
             * stationPrice : 100.0
             */

            private String appId;
            private String city;
            private String creationTime;
            private String fixPhone;
            private double lat;
            private int leaseConditions;
            private double lng;
            private int longRent;
            private String relationTel;
            private int shortRent;
            private String spaceDescribe;
            private int spaceId;
            private String spaceName;
            private String spacePicture;
            private String spaceSite;
            private int spaceStar;
            private int spaceState;
            private String spaceUrl;
            private String spared1;
            private String spared2;
            private String spared3;
            private int stationNum;
            private int alreadyTakenNum;
            private double stationPrice;

            public String getAppId() {
                return appId;
            }

            public void setAppId(String appId) {
                this.appId = appId;
            }

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

            public int getLeaseConditions() {
                return leaseConditions;
            }

            public void setLeaseConditions(int leaseConditions) {
                this.leaseConditions = leaseConditions;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public int getLongRent() {
                return longRent;
            }

            public void setLongRent(int longRent) {
                this.longRent = longRent;
            }

            public String getRelationTel() {
                return relationTel;
            }

            public void setRelationTel(String relationTel) {
                this.relationTel = relationTel;
            }

            public int getShortRent() {
                return shortRent;
            }

            public void setShortRent(int shortRent) {
                this.shortRent = shortRent;
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

            public int getSpaceStar() {
                return spaceStar;
            }

            public void setSpaceStar(int spaceStar) {
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

            public int getStationNum() {
                return stationNum;
            }

            public void setStationNum(int stationNum) {
                this.stationNum = stationNum;
            }

            public int getAlreadyTakenNum() {
                return alreadyTakenNum;
            }

            public void setAlreadyTakenNum(int alreadyTakenNum) {
                this.alreadyTakenNum = alreadyTakenNum;
            }

            public double getStationPrice() {
                return stationPrice;
            }

            public void setStationPrice(double stationPrice) {
                this.stationPrice = stationPrice;
            }
        }
    }
}
