package com.ylg.workspace.workspace.activity.personaldetails.bean;

import java.util.List;

public class Business {


    /**
     * result : 鎴愬姛
     * code : 200
     * msg : [{"companyId":2,"companyName":"鏄撹仈娓�2","companyPicture":"/static/images/conference/1499930878020.jpg","companyProfile":"鐗╄仈缃�","companyState":3,"companyType":"鐗╄仈缃�","contacts":"寮犻洦","mailbox":"123456789@qq.com","peopleNum":20,"spaceId":57,"spared1":"2017-7-20","spared2":"","spared3":"","tel":"123456789"},{"companyId":3,"companyName":"鏄撹仈娓�3","companyPicture":"/static/images/conference/1500019116704.jpg","companyProfile":"鐗╄仈缃�","companyState":0,"companyType":"鐗╄仈缃�","contacts":"寮犻洦","mailbox":"123456789@qq.com","peopleNum":30,"spaceId":58,"spared1":"2017-7-20","spared2":"","spared3":"","tel":"123456"}]
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
         * companyId : 2
         * companyName : 鏄撹仈娓�2
         * companyPicture : /static/images/conference/1499930878020.jpg
         * companyProfile : 鐗╄仈缃�
         * companyState : 3
         * companyType : 鐗╄仈缃�
         * contacts : 寮犻洦
         * mailbox : 123456789@qq.com
         * peopleNum : 20
         * spaceId : 57
         * spared1 : 2017-7-20
         * spared2 :
         * spared3 :
         * tel : 123456789
         */

        private int companyId;
        private String companyName;
        private String companyPicture;
        private String companyProfile;
        private int companyState;
        private String companyType;
        private String contacts;
        private String mailbox;
        private int peopleNum;
        private int spaceId;
        private String spared1;
        private String spared2;
        private String spared3;
        private String tel;

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCompanyPicture() {
            return companyPicture;
        }

        public void setCompanyPicture(String companyPicture) {
            this.companyPicture = companyPicture;
        }

        public String getCompanyProfile() {
            return companyProfile;
        }

        public void setCompanyProfile(String companyProfile) {
            this.companyProfile = companyProfile;
        }

        public int getCompanyState() {
            return companyState;
        }

        public void setCompanyState(int companyState) {
            this.companyState = companyState;
        }

        public String getCompanyType() {
            return companyType;
        }

        public void setCompanyType(String companyType) {
            this.companyType = companyType;
        }

        public String getContacts() {
            return contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts;
        }

        public String getMailbox() {
            return mailbox;
        }

        public void setMailbox(String mailbox) {
            this.mailbox = mailbox;
        }

        public int getPeopleNum() {
            return peopleNum;
        }

        public void setPeopleNum(int peopleNum) {
            this.peopleNum = peopleNum;
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

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        @Override
        public String toString() {
            return "MsgBean{" +
                    "companyId=" + companyId +
                    ", companyName='" + companyName + '\'' +
                    ", companyPicture='" + companyPicture + '\'' +
                    ", companyProfile='" + companyProfile + '\'' +
                    ", companyState=" + companyState +
                    ", companyType='" + companyType + '\'' +
                    ", contacts='" + contacts + '\'' +
                    ", mailbox='" + mailbox + '\'' +
                    ", peopleNum=" + peopleNum +
                    ", spaceId=" + spaceId +
                    ", spared1='" + spared1 + '\'' +
                    ", spared2='" + spared2 + '\'' +
                    ", spared3='" + spared3 + '\'' +
                    ", tel='" + tel + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Business{" +
                "result='" + result + '\'' +
                ", code='" + code + '\'' +
                ", msg=" + msg +
                '}';
    }
}
