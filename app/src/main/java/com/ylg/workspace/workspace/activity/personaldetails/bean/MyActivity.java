package com.ylg.workspace.workspace.activity.personaldetails.bean;


import java.util.List;

public class MyActivity {


    /**
     * result : 鎴愬姛
     * code : 200
     * msg : [{"content":{"activityDescribe":"娲诲姩1","activityId":1,"activityState":1,"activityType":2,"endTime":"2017/08/27 14:20:42","issueCompanyId":1,"issueTime":"2017/07/04 14:20:35","issueUserId":1,"peopleNum":50,"pictureSite":"/default/6715660.jpg","principalName":"寮犱笁","principalTel":"18888888888","spaceId":57,"spaceName":"鏂瑰渾澶у帵","spared1":"鍖椾含娴锋穩","spared2":"","spared3":"","starTime":"2017/07/30 14:20:11","title":"娲诲姩1"},"state":"鏈紑濮�"},{"content":{"activityDescribe":"娲诲姩2","activityId":2,"activityState":1,"activityType":1,"endTime":"2017/08/31 16:56:01","issueCompanyId":1,"issueTime":"2017/07/06 16:55:54","issueUserId":1,"peopleNum":100,"pictureSite":"/default/6715660.jpg","principalName":"寮犱笁","principalTel":"18888888888","spaceId":57,"spaceName":"鏂瑰渾澶у帵","spared1":"鍖椾含娴锋穩","spared2":"","spared3":"","starTime":"2017/07/17 16:55:57","title":"娲诲姩2"},"state":"杩涜涓�"},{"content":{"activityDescribe":"娲诲姩3","activityId":3,"activityState":1,"activityType":1,"endTime":"2017/07/17 18:27:21","issueCompanyId":1,"issueTime":"2017/07/10 18:27:15","issueUserId":1,"peopleNum":20,"pictureSite":"/default/6715660.jpg","principalName":"寮犱笁","principalTel":"18888888888","spaceId":57,"spaceName":"鏂瑰渾澶у帵","spared1":"鍖椾含娴锋穩","spared2":"","spared3":"","starTime":"2017/06/26 18:27:18","title":"娲诲姩3"},"state":"宸茬粨鏉�"},{"content":{"activityDescribe":"娲诲姩4","activityId":4,"activityState":1,"activityType":1,"endTime":"2017/08/26 18:27:21","issueCompanyId":1,"issueTime":"2017/07/10 18:27:15","issueUserId":1,"peopleNum":10,"pictureSite":"/default/6715660.jpg","principalName":"寮犱笁","principalTel":"18888888888","spaceId":57,"spaceName":"鏂瑰渾澶у帵","spared1":"鍖椾含娴锋穩","spared2":"","spared3":"","starTime":"2017/07/17 18:27:18","title":"娲诲姩4"},"state":"杩涜涓�"},{"content":{"activityDescribe":"娲诲姩5","activityId":5,"activityState":1,"activityType":1,"endTime":"2017/08/25 18:27:21","issueCompanyId":1,"issueTime":"2017/07/10 18:27:15","issueUserId":1,"peopleNum":60,"pictureSite":"/default/6715660.jpg","principalName":"寮犱笁","principalTel":"18888888888","spaceId":57,"spaceName":"鏂瑰渾澶у帵","spared1":"鍖椾含娴锋穩","spared2":"","spared3":"","starTime":"2017/07/21 18:27:18","title":"娲诲姩5"},"state":"鏈紑濮�"}]
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
         * content : {"activityDescribe":"娲诲姩1","activityId":1,"activityState":1,"activityType":2,"endTime":"2017/08/27 14:20:42","issueCompanyId":1,"issueTime":"2017/07/04 14:20:35","issueUserId":1,"peopleNum":50,"pictureSite":"/default/6715660.jpg","principalName":"寮犱笁","principalTel":"18888888888","spaceId":57,"spaceName":"鏂瑰渾澶у帵","spared1":"鍖椾含娴锋穩","spared2":"","spared3":"","starTime":"2017/07/30 14:20:11","title":"娲诲姩1"}
         * state : 鏈紑濮�
         */

        private ContentBean content;
        private String state;

        public ContentBean getContent() {
            return content;
        }

        public void setContent(ContentBean content) {
            this.content = content;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public static class ContentBean {
            /**
             * activityDescribe : 娲诲姩1
             * activityId : 1
             * activityState : 1
             * activityType : 2
             * endTime : 2017/08/27 14:20:42
             * issueCompanyId : 1
             * issueTime : 2017/07/04 14:20:35
             * issueUserId : 1
             * peopleNum : 50
             * pictureSite : /default/6715660.jpg
             * principalName : 寮犱笁
             * principalTel : 18888888888
             * spaceId : 57
             * spaceName : 鏂瑰渾澶у帵
             * spared1 : 鍖椾含娴锋穩
             * spared2 :
             * spared3 :
             * starTime : 2017/07/30 14:20:11
             * title : 娲诲姩1
             */

            private String activityDescribe;
            private int activityId;
            private int activityState;
            private int activityType;
            private String endTime;
            private int issueCompanyId;
            private String issueTime;
            private int issueUserId;
            private int peopleNum;
            private String pictureSite;
            private String principalName;
            private String principalTel;
            private int spaceId;
            private String spaceName;
            private String spared1;
            private String spared2;
            private String spared3;
            private String starTime;
            private String title;

            public String getActivityDescribe() {
                return activityDescribe;
            }

            public void setActivityDescribe(String activityDescribe) {
                this.activityDescribe = activityDescribe;
            }

            public int getActivityId() {
                return activityId;
            }

            public void setActivityId(int activityId) {
                this.activityId = activityId;
            }

            public int getActivityState() {
                return activityState;
            }

            public void setActivityState(int activityState) {
                this.activityState = activityState;
            }

            public int getActivityType() {
                return activityType;
            }

            public void setActivityType(int activityType) {
                this.activityType = activityType;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public int getIssueCompanyId() {
                return issueCompanyId;
            }

            public void setIssueCompanyId(int issueCompanyId) {
                this.issueCompanyId = issueCompanyId;
            }

            public String getIssueTime() {
                return issueTime;
            }

            public void setIssueTime(String issueTime) {
                this.issueTime = issueTime;
            }

            public int getIssueUserId() {
                return issueUserId;
            }

            public void setIssueUserId(int issueUserId) {
                this.issueUserId = issueUserId;
            }

            public int getPeopleNum() {
                return peopleNum;
            }

            public void setPeopleNum(int peopleNum) {
                this.peopleNum = peopleNum;
            }

            public String getPictureSite() {
                return pictureSite;
            }

            public void setPictureSite(String pictureSite) {
                this.pictureSite = pictureSite;
            }

            public String getPrincipalName() {
                return principalName;
            }

            public void setPrincipalName(String principalName) {
                this.principalName = principalName;
            }

            public String getPrincipalTel() {
                return principalTel;
            }

            public void setPrincipalTel(String principalTel) {
                this.principalTel = principalTel;
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

            public String getStarTime() {
                return starTime;
            }

            public void setStarTime(String starTime) {
                this.starTime = starTime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
