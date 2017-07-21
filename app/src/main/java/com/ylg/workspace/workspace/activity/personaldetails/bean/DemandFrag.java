package com.ylg.workspace.workspace.activity.personaldetails.bean;


import java.util.List;

public class DemandFrag {

    /**
     * result : 鎴愬姛
     * code : 200
     * msg : [{"describe":"璐㈠姟缁熻","facilitatorLabel":["閲戣瀺-鐞嗚储鏈嶅姟","娉曞緥-娉曞緥鍜ㄨ"],"facilitatorType":"7,16","id":1,"spaceId":57,"time":"2017/07/21 10:08:34","userId":1},{"describe":"娉曞緥鍜ㄨ","facilitatorLabel":["娉曞緥-娉曞緥鍜ㄨ"],"facilitatorType":"16","id":2,"spaceId":57,"time":"2017/07/21 10:31:23","userId":1}]
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
         * describe : 璐㈠姟缁熻
         * facilitatorLabel : ["閲戣瀺-鐞嗚储鏈嶅姟","娉曞緥-娉曞緥鍜ㄨ"]
         * facilitatorType : 7,16
         * id : 1
         * spaceId : 57
         * time : 2017/07/21 10:08:34
         * userId : 1
         */

        private String describe;
        private String facilitatorType;
        private int id;
        private int spaceId;
        private String time;
        private int userId;
        private List<String> facilitatorLabel;

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getFacilitatorType() {
            return facilitatorType;
        }

        public void setFacilitatorType(String facilitatorType) {
            this.facilitatorType = facilitatorType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSpaceId() {
            return spaceId;
        }

        public void setSpaceId(int spaceId) {
            this.spaceId = spaceId;
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

        public List<String> getFacilitatorLabel() {
            return facilitatorLabel;
        }

        public void setFacilitatorLabel(List<String> facilitatorLabel) {
            this.facilitatorLabel = facilitatorLabel;
        }
    }
}
