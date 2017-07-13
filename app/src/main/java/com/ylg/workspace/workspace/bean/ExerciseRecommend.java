package com.ylg.workspace.workspace.bean;

import java.util.List;

/**
 * Created by stu on 2017/7/13.
 */

public class ExerciseRecommend {

    /**
     * result : 鎴愬姛
     * code : 200
     * msg : [{"activityDescribe":"娲诲姩4","activityId":4,"activityState":1,"activityType":1,"endTime":"2017/07/28 18:27:21","issueCompanyId":1,"issueTime":"2017/07/10 18:27:15","issueUserId":1,"peopleNum":1,"pictureSite":"","principalName":"1","principalTel":"1","spaceId":33,"spared1":"1","spared2":"1","spared3":"1","starTime":"2017/07/20 18:27:18","title":"娲诲姩4"},{"activityDescribe":"娲诲姩5","activityId":5,"activityState":1,"activityType":1,"endTime":"2017/07/28 18:27:21","issueCompanyId":1,"issueTime":"2017/07/10 18:27:15","issueUserId":1,"peopleNum":1,"pictureSite":"","principalName":"1","principalTel":"1","spaceId":33,"spared1":"1","spared2":"1","spared3":"1","starTime":"2017/07/20 18:27:18","title":"娲诲姩5"},{"activityDescribe":"娲诲姩6","activityId":6,"activityState":1,"activityType":1,"endTime":"2017/07/28 18:27:21","issueCompanyId":1,"issueTime":"2017/07/10 18:27:15","issueUserId":1,"peopleNum":1,"pictureSite":"","principalName":"1","principalTel":"1","spaceId":33,"spared1":"1","spared2":"1","spared3":"1","starTime":"2017/07/20 18:27:18","title":"娲诲姩6"},{"activityDescribe":"娲诲姩2","activityId":2,"activityState":1,"activityType":1,"endTime":"2017/07/06 16:56:01","issueCompanyId":1,"issueTime":"2017/07/06 16:55:54","issueUserId":2,"peopleNum":1,"pictureSite":"/static/images/1499927450525.jpg,/static/images/1499927450530.jpg","principalName":"1","principalTel":"1","spaceId":33,"spared1":"1","spared2":"1","spared3":"","starTime":"2017/07/06 16:55:57","title":"娲诲姩2"},{"activityDescribe":"娲诲姩1","activityId":1,"activityState":1,"activityType":2,"endTime":"2017/07/04 14:20:42","issueCompanyId":1,"issueTime":"2017/07/04 14:20:35","issueUserId":1,"peopleNum":1,"pictureSite":"","principalName":"1","principalTel":"1","spaceId":33,"spared1":"1","spared2":"1","spared3":"","starTime":"2017/07/04 14:20:11","title":"娲诲姩1"}]
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
         * activityDescribe : 娲诲姩4
         * activityId : 4
         * activityState : 1
         * activityType : 1
         * endTime : 2017/07/28 18:27:21
         * issueCompanyId : 1
         * issueTime : 2017/07/10 18:27:15
         * issueUserId : 1
         * peopleNum : 1
         * pictureSite :
         * principalName : 1
         * principalTel : 1
         * spaceId : 33
         * spared1 : 1
         * spared2 : 1
         * spared3 : 1
         * starTime : 2017/07/20 18:27:18
         * title : 娲诲姩4
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
