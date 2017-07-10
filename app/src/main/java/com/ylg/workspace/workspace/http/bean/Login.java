package com.ylg.workspace.workspace.http.bean;

import java.io.Serializable;

public class Login{


    /**
     * result : 鎴愬姛
     * code : 200
     * msg : {"birthDate":"2016-04-06 13:59:35","companyId":1,"companyName":"鐗╄仈娓鎶\u20ac鍙戝睍鏈夐檺鍏徃","email":"123456789@qq.com","headPortrait":"[{\"site\":\"/static/images/1499326581890.jpeg\",\"fileName\":\"u=2978403572,2363941822&fm=26&gp=0.jpg\"}]","industry":"1","interest":"1","password":"E10ADC3949BA59ABBE56E057F20F883E","realName":"鏄撹仈娓�","registerTime":"2017-07-05 14:00:53","sex":"man","site":"1","skill":"1","spared1":"1","spared2":"1","spared3":"1","state":1,"tel":"12345678912","userId":1,"userName":"yiliangang","userType":1}
     */

    private String result;
    private String code;
    private MsgBean msg;

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

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * birthDate : 2016-04-06 13:59:35
         * companyId : 1
         * companyName : 鐗╄仈娓鎶€鍙戝睍鏈夐檺鍏徃
         * email : 123456789@qq.com
         * headPortrait : [{"site":"/static/images/1499326581890.jpeg","fileName":"u=2978403572,2363941822&fm=26&gp=0.jpg"}]
         * industry : 1
         * interest : 1
         * password : E10ADC3949BA59ABBE56E057F20F883E
         * realName : 鏄撹仈娓�
         * registerTime : 2017-07-05 14:00:53
         * sex : man
         * site : 1
         * skill : 1
         * spared1 : 1
         * spared2 : 1
         * spared3 : 1
         * state : 1
         * tel : 12345678912
         * userId : 1
         * userName : yiliangang
         * userType : 1
         */

        private String birthDate;
        private int companyId;
        private String companyName;
        private String email;
        private String headPortrait;
        private String industry;
        private String interest;
        private String password;
        private String realName;
        private String registerTime;
        private String sex;
        private String site;
        private String skill;
        private String spared1;
        private String spared2;
        private String spared3;
        private int state;
        private String tel;
        private int userId;
        private String userName;
        private int userType;

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getHeadPortrait() {
            return headPortrait;
        }

        public void setHeadPortrait(String headPortrait) {
            this.headPortrait = headPortrait;
        }

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public String getInterest() {
            return interest;
        }

        public void setInterest(String interest) {
            this.interest = interest;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(String registerTime) {
            this.registerTime = registerTime;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getSkill() {
            return skill;
        }

        public void setSkill(String skill) {
            this.skill = skill;
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

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
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

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        @Override
        public String toString() {
            return "MsgBean{" +
                    "birthDate='" + birthDate + '\'' +
                    ", companyId=" + companyId +
                    ", companyName='" + companyName + '\'' +
                    ", email='" + email + '\'' +
                    ", headPortrait='" + headPortrait + '\'' +
                    ", industry='" + industry + '\'' +
                    ", interest='" + interest + '\'' +
                    ", password='" + password + '\'' +
                    ", realName='" + realName + '\'' +
                    ", registerTime='" + registerTime + '\'' +
                    ", sex='" + sex + '\'' +
                    ", site='" + site + '\'' +
                    ", skill='" + skill + '\'' +
                    ", spared1='" + spared1 + '\'' +
                    ", spared2='" + spared2 + '\'' +
                    ", spared3='" + spared3 + '\'' +
                    ", state=" + state +
                    ", tel='" + tel + '\'' +
                    ", userId=" + userId +
                    ", userName='" + userName + '\'' +
                    ", userType=" + userType +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "Login{" +
                "result='" + result + '\'' +
                ", code='" + code + '\'' +
                ", msg=" + msg +
                '}';
    }
}
