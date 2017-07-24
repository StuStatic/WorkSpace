package com.ylg.workspace.workspace.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by stu on 2017/7/12.
 */

public class NeiborCompany {


    /**
     * result : 鎴愬姛
     * msg : [{"companyId":1,"companyName":"鐗╄仈娓鎶\u20ac鍙戝睍鏈夐檺鍏徃","companyPicture":"/static/images/space/20170724104233.png","companyProfile":"鐗╄仈缃�","companyState":1,"companyType":"2","contacts":"寮犻洦","mailbox":"123456789@qq.com","peopleNum":40,"spaceId":69,"spared1":"2017-7-24","spared2":"","spared3":"","tel":"18888888888"}]
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
         * companyId : 1
         * companyName : 鐗╄仈娓鎶€鍙戝睍鏈夐檺鍏徃
         * companyPicture : /static/images/space/20170724104233.png
         * companyProfile : 鐗╄仈缃�
         * companyState : 1
         * companyType : 2
         * contacts : 寮犻洦
         * mailbox : 123456789@qq.com
         * peopleNum : 40
         * spaceId : 69
         * spared1 : 2017-7-24
         * spared2 :
         * spared3 :
         * tel : 18888888888
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
    }
}
