package com.ylg.workspace.workspace.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */

public class Info {

    /**
     * code : 200
     * msg : [{"issueCompanyId":0,"issueSpaceId":55,"issueTime":"2017/07/13 18:11:43","messageId":14,"messageInfo":"璧典寒浜�","messageState":0,"messageType":0,"pictureSite":"/static/images/1499940703490.jpg,/static/images/1499940703491.jpg,/static/images/1499940703491.jpg,/static/images/1499940703492.jpg","spared1":"","spared2":"","spared3":"","title":"璧典寒浜�","writer":"鑷杞�"},{"issueCompanyId":0,"issueSpaceId":55,"issueTime":"2017/07/13 17:07:43","messageId":15,"messageInfo":"鐪熺儹銆傜湡浠栧鐑�","messageState":0,"messageType":0,"pictureSite":"/static/images/1499936863048.jpg,/static/images/1499936863067.jpg,/static/images/1499936863067.jpg","spared1":"","spared2":"","spared3":"","title":"澶╃儹锛岄闃蹭腑鏆�","writer":"璧典寒浜�"},{"issueCompanyId":0,"issueSpaceId":56,"issueTime":"2017/07/13 18:15:32","messageId":16,"messageInfo":"璧典寒浜ぇ灞辩偖","messageState":0,"messageType":0,"pictureSite":"/static/images/1499940932001.jpg,/static/images/1499940932001.jpg,/static/images/1499940932003.jpg","spared1":"","spared2":"","spared3":"","title":"鏍囬2","writer":"璧典寒浜北鐐�"},{"issueCompanyId":0,"issueSpaceId":57,"issueTime":"2017/07/13 18:09:20","messageId":17,"messageInfo":"闃胯惃寰�","messageState":0,"messageType":0,"pictureSite":"/static/images/1499940560701.jpg,/static/images/1499940560702.jpg,/static/images/1499940560703.jpg,/static/images/1499940560703.jpg","spared1":"","spared2":"","spared3":"","title":"闃胯惃寰�","writer":"闃胯惃寰�"},{"issueCompanyId":0,"issueSpaceId":58,"issueTime":"2017/07/13 18:15:52","messageId":18,"messageInfo":"闃胯惃寰�","messageState":0,"messageType":0,"pictureSite":"/static/images/1499940952794.jpg,/static/images/1499940952794.jpg,/static/images/1499940952796.jpg,/static/images/1499940952796.jpg","spared1":"","spared2":"","spared3":"","title":"闃胯惃寰�","writer":"闃胯惃寰�"},{"issueCompanyId":0,"issueSpaceId":57,"issueTime":"2017/07/11 18:47:58","messageId":19,"messageInfo":"asdas","messageState":0,"messageType":1,"pictureSite":"dasa","spared1":"","spared2":"","spared3":"","title":"sada ","writer":""}]
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
         * issueCompanyId : 0
         * issueSpaceId : 55
         * issueTime : 2017/07/13 18:11:43
         * messageId : 14
         * messageInfo : 璧典寒浜�
         * messageState : 0
         * messageType : 0
         * pictureSite : /static/images/1499940703490.jpg,/static/images/1499940703491.jpg,/static/images/1499940703491.jpg,/static/images/1499940703492.jpg
         * spared1 :
         * spared2 :
         * spared3 :
         * title : 璧典寒浜�
         * writer : 鑷杞�
         */

        private int issueCompanyId;
        private int issueSpaceId;
        private String issueTime;
        private int messageId;
        private String messageInfo;
        private int messageState;
        private int messageType;
        private String pictureSite;
        private String spared1;
        private String spared2;
        private String spared3;
        private String title;
        private String writer;

        public int getIssueCompanyId() {
            return issueCompanyId;
        }

        public void setIssueCompanyId(int issueCompanyId) {
            this.issueCompanyId = issueCompanyId;
        }

        public int getIssueSpaceId() {
            return issueSpaceId;
        }

        public void setIssueSpaceId(int issueSpaceId) {
            this.issueSpaceId = issueSpaceId;
        }

        public String getIssueTime() {
            return issueTime;
        }

        public void setIssueTime(String issueTime) {
            this.issueTime = issueTime;
        }

        public int getMessageId() {
            return messageId;
        }

        public void setMessageId(int messageId) {
            this.messageId = messageId;
        }

        public String getMessageInfo() {
            return messageInfo;
        }

        public void setMessageInfo(String messageInfo) {
            this.messageInfo = messageInfo;
        }

        public int getMessageState() {
            return messageState;
        }

        public void setMessageState(int messageState) {
            this.messageState = messageState;
        }

        public int getMessageType() {
            return messageType;
        }

        public void setMessageType(int messageType) {
            this.messageType = messageType;
        }

        public String getPictureSite() {
            return pictureSite;
        }

        public void setPictureSite(String pictureSite) {
            this.pictureSite = pictureSite;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getWriter() {
            return writer;
        }

        public void setWriter(String writer) {
            this.writer = writer;
        }
    }
}
