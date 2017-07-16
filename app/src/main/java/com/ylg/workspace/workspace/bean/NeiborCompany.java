package com.ylg.workspace.workspace.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by stu on 2017/7/12.
 */

public class NeiborCompany implements Serializable{

    /**
     * result : 鎴愬姛
     * code : 200
     * msg : [{"companyId":1,"companyName":"鏄撹仈娓�","companyPicture":"/default/6715660.jpg","companyProfile":"鐗╄仈缃�","companyType":"1","contacts":"寮犻洦","mailbox":"123456789@qq.com","peopleNum":40,"spaceId":55,"spared1":"","spared2":"","spared3":"","tel":"12345678912"}]
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

    public static class MsgEntity implements Serializable{
        /**
         * companyId : 1
         * companyName : 鏄撹仈娓�
         * companyPicture : /default/6715660.jpg
         * companyProfile : 鐗╄仈缃�
         * companyType : 1
         * contacts : 寮犻洦
         * mailbox : 123456789@qq.com
         * peopleNum : 40
         * spaceId : 55
         * spared1 :
         * spared2 :
         * spared3 :
         * tel : 12345678912
         */

        private int companyId;
        private String companyName;
        private String companyPicture;
        private String companyProfile;
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
