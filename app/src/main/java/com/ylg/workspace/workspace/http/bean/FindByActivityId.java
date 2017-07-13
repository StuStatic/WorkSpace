package com.ylg.workspace.workspace.http.bean;

import java.util.List;

public class FindByActivityId {


    /**
     * result : 鎴愬姛
     * code : 200
     * msg : [{"activityId":1,"applyCompany":"a","applyId":1,"applyNume":"a","applyState":1,"applyTel":"123456","applyTime":"2017-07-04 14:19:38","spared1":"a","spared2":"a","spared3":"a"}]
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
         * activityId : 1
         * applyCompany : a
         * applyId : 1
         * applyNume : a
         * applyState : 1
         * applyTel : 123456
         * applyTime : 2017-07-04 14:19:38
         * spared1 : a
         * spared2 : a
         * spared3 : a
         */

        private int activityId;
        private String applyCompany;
        private int applyId;
        private String applyNume;
        private int applyState;
        private String applyTel;
        private String applyTime;
        private String spared1;
        private String spared2;
        private String spared3;

        public int getActivityId() {
            return activityId;
        }

        public void setActivityId(int activityId) {
            this.activityId = activityId;
        }

        public String getApplyCompany() {
            return applyCompany;
        }

        public void setApplyCompany(String applyCompany) {
            this.applyCompany = applyCompany;
        }

        public int getApplyId() {
            return applyId;
        }

        public void setApplyId(int applyId) {
            this.applyId = applyId;
        }

        public String getApplyNume() {
            return applyNume;
        }

        public void setApplyNume(String applyNume) {
            this.applyNume = applyNume;
        }

        public int getApplyState() {
            return applyState;
        }

        public void setApplyState(int applyState) {
            this.applyState = applyState;
        }

        public String getApplyTel() {
            return applyTel;
        }

        public void setApplyTel(String applyTel) {
            this.applyTel = applyTel;
        }

        public String getApplyTime() {
            return applyTime;
        }

        public void setApplyTime(String applyTime) {
            this.applyTime = applyTime;
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
