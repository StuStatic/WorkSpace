package com.ylg.workspace.workspace.activity.personaldetails.bean;

import java.util.List;

public class FeedBackFrag {


    /**
     * code : 200
     * msg : [{"opinionContent":"v鑰屼笢鍖楁按娉�","opinionId":15,"opinionState":1,"spaceId":56,"spared3":"","tel":"1234567890","time":"2017/07/20 13:38:48","userId":1,"userName":"v鏍煎鍚庡ぉ灏辫兘缈�"},{"opinionContent":"v鑰屼笢鍖楃殑姘存偿鍘傚唨涓滄按娉�","opinionId":18,"opinionState":1,"spaceId":58,"spared3":"","tel":"1234567890","time":"2017/07/20 13:38:48","userId":1,"userName":"鐨剉鏄痸"},{"opinionContent":"Fhhhjjvvc","opinionId":20,"opinionState":0,"spaceId":57,"spared3":"","tel":"ghj","time":"2017/07/19 11:53:53","userId":1,"userName":"忙聵聯猫聛聰忙赂炉"},{"opinionContent":"v缁欑ぞ浼氳浣�","opinionId":16,"opinionState":1,"spaceId":56,"spared3":"","tel":"1234567890","time":"2017/07/18 13:39:11","userId":1,"userName":"veve鎴憊"},{"opinionContent":" 鍦版柟鐢风殑濂崇殑鐧惧害","opinionId":19,"opinionState":1,"spaceId":58,"spared3":"","tel":"1234567890","time":"2017/07/18 13:39:11","userId":1,"userName":"vav"},{"opinionContent":"涓嶇啛鎮� ","opinionId":14,"opinionState":1,"spaceId":57,"spared3":"","tel":"123456789","time":"2017/07/18 13:38:10","userId":1,"userName":"浠婂ぉ浠嶇劧"},{"opinionContent":" 瀹ｄ紶鍐屼粖骞寸殑鎵嶏紝 ","opinionId":17,"opinionState":0,"spaceId":57,"spared3":"","tel":"123456789","time":"2017/07/18 13:38:10","userId":1,"userName":"閮芥槸vbf"}]
     * result : 鎴愬姛
     */

    private String code;
    private String result;
    private List<MsgBean> msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<MsgBean> getMsg() {
        return msg;
    }

    public void setMsg(List<MsgBean> msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * opinionContent : v鑰屼笢鍖楁按娉�
         * opinionId : 15
         * opinionState : 1
         * spaceId : 56
         * spared3 :
         * tel : 1234567890
         * time : 2017/07/20 13:38:48
         * userId : 1
         * userName : v鏍煎鍚庡ぉ灏辫兘缈�
         */

        private String opinionContent;
        private int opinionId;
        private int opinionState;
        private int spaceId;
        private String spared3;
        private String tel;
        private String time;
        private int userId;
        private String userName;

        public String getOpinionContent() {
            return opinionContent;
        }

        public void setOpinionContent(String opinionContent) {
            this.opinionContent = opinionContent;
        }

        public int getOpinionId() {
            return opinionId;
        }

        public void setOpinionId(int opinionId) {
            this.opinionId = opinionId;
        }

        public int getOpinionState() {
            return opinionState;
        }

        public void setOpinionState(int opinionState) {
            this.opinionState = opinionState;
        }

        public int getSpaceId() {
            return spaceId;
        }

        public void setSpaceId(int spaceId) {
            this.spaceId = spaceId;
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

        @Override
        public String toString() {
            return "MsgBean{" +
                    "opinionContent='" + opinionContent + '\'' +
                    ", opinionId=" + opinionId +
                    ", opinionState=" + opinionState +
                    ", spaceId=" + spaceId +
                    ", spared3='" + spared3 + '\'' +
                    ", tel='" + tel + '\'' +
                    ", time='" + time + '\'' +
                    ", userId=" + userId +
                    ", userName='" + userName + '\'' +
                    '}';
        }
    }
}
