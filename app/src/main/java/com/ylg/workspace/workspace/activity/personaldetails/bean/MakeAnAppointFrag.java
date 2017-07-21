package com.ylg.workspace.workspace.activity.personaldetails.bean;


import java.util.List;

public class MakeAnAppointFrag {

    /**
     * result : 鎴愬姛
     * code : 200
     * msg : [{"accessState":0,"accessType":1,"feedback":"","papersNum":"","papersType":0,"peopleNum":33,"sex":"濂�","spaceId":0,"spared1":"","spared2":"","spared3":"","time":"","userId":1,"userName":"","visitInfo":"","visitTime":"2017/07/18 11:05:00","visitorId":60,"visitorName":"璧典寒浜�","visitorPicture":"/default/6715660.jpg","visitorTel":""},{"accessState":0,"accessType":0,"feedback":"","papersNum":"","papersType":0,"peopleNum":3,"sex":"莽聰路","spaceId":0,"spared1":"氓聦聴盲潞卢","spared2":"","spared3":"","time":"","userId":1,"userName":"猫碌碌盲潞庐盲潞庐","visitInfo":"氓聲聤氓聲聤氓聲聤","visitTime":"2017/07/21 11:27:00","visitorId":61,"visitorName":"氓录聽茅鹿聫","visitorPicture":"/static/images/1500607697339.png","visitorTel":"11111"},{"accessState":0,"accessType":1,"feedback":"","papersNum":"","papersType":0,"peopleNum":6,"sex":"濂�","spaceId":0,"spared1":"鍖椾含","spared2":"","spared3":"","time":"","userId":1,"userName":"璧典寒浜�","visitInfo":"鍟婂晩鍟�","visitTime":"2017/07/21 11:37:00","visitorId":62,"visitorName":"璧典寒浜�","visitorPicture":"/static/images/1500608303270.png","visitorTel":"123466789"}]
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
         * accessState : 0
         * accessType : 1
         * feedback :
         * papersNum :
         * papersType : 0
         * peopleNum : 33
         * sex : 濂�
         * spaceId : 0
         * spared1 :
         * spared2 :
         * spared3 :
         * time :
         * userId : 1
         * userName :
         * visitInfo :
         * visitTime : 2017/07/18 11:05:00
         * visitorId : 60
         * visitorName : 璧典寒浜�
         * visitorPicture : /default/6715660.jpg
         * visitorTel :
         */

        private int accessState;
        private int accessType;
        private String feedback;
        private String papersNum;
        private int papersType;
        private int peopleNum;
        private String sex;
        private int spaceId;
        private String spared1;
        private String spared2;
        private String spared3;
        private String time;
        private int userId;
        private String userName;
        private String visitInfo;
        private String visitTime;
        private int visitorId;
        private String visitorName;
        private String visitorPicture;
        private String visitorTel;

        public int getAccessState() {
            return accessState;
        }

        public void setAccessState(int accessState) {
            this.accessState = accessState;
        }

        public int getAccessType() {
            return accessType;
        }

        public void setAccessType(int accessType) {
            this.accessType = accessType;
        }

        public String getFeedback() {
            return feedback;
        }

        public void setFeedback(String feedback) {
            this.feedback = feedback;
        }

        public String getPapersNum() {
            return papersNum;
        }

        public void setPapersNum(String papersNum) {
            this.papersNum = papersNum;
        }

        public int getPapersType() {
            return papersType;
        }

        public void setPapersType(int papersType) {
            this.papersType = papersType;
        }

        public int getPeopleNum() {
            return peopleNum;
        }

        public void setPeopleNum(int peopleNum) {
            this.peopleNum = peopleNum;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
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

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getVisitInfo() {
            return visitInfo;
        }

        public void setVisitInfo(String visitInfo) {
            this.visitInfo = visitInfo;
        }

        public String getVisitTime() {
            return visitTime;
        }

        public void setVisitTime(String visitTime) {
            this.visitTime = visitTime;
        }

        public int getVisitorId() {
            return visitorId;
        }

        public void setVisitorId(int visitorId) {
            this.visitorId = visitorId;
        }

        public String getVisitorName() {
            return visitorName;
        }

        public void setVisitorName(String visitorName) {
            this.visitorName = visitorName;
        }

        public String getVisitorPicture() {
            return visitorPicture;
        }

        public void setVisitorPicture(String visitorPicture) {
            this.visitorPicture = visitorPicture;
        }

        public String getVisitorTel() {
            return visitorTel;
        }

        public void setVisitorTel(String visitorTel) {
            this.visitorTel = visitorTel;
        }
    }
}
