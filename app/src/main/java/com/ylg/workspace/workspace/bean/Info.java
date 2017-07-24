package com.ylg.workspace.workspace.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */

public class Info {


    /**
     * msg : {"space":[{"issueCompanyId":0,"issueSpaceId":69,"issueTime":"2017/07/24 11:30:44","messageId":25,"messageInfo":"鑷粠鍥藉鎺ㄨ繘鍙屽垱娲诲姩鍚庯紝鍒濆垱浼佷笟銆佸叡浜姙鍏┖闂村強鍒涗笟瀛靛寲鍣ㄥ闆ㄥ悗鏄ョ瑡鑸繀閫熸秾鐜般\u20ac備紭瀹㈠伐鍦轰綔涓哄浗鍐呭叡浜姙鍏鍩熺殑鐙鍏斤紝涓哄垱涓氬叕鍙告彁渚涗簡鍒涗笟璧勯噾銆佸叆椹诲満鍦板強瀹屽杽鐨勫唴閮ㄩ厤濂楀姛鑳斤紝鍩硅偛浜嗕紬澶氫紭绉\u20ac鐨勫垱涓氬搧鐗屻\u20ac備匠鑳借瀵熷埌浼樺宸ュ満鍐呬骇鐢熺殑璇稿鍏变韩鎵撳嵃銆佽嚜鍔╂敮浠樻墦鍗扮瓑鏂板瀷鍔炲叕鎵撳嵃妯\u2033紡锛屼互鍙婂叆椹讳紒涓氳繀閫熸垚闀夸骇鐢熺殑澶氭牱鍔炲叕鎵撳嵃闇\u20ac姹傦紝閫夋嫨涓庝紭瀹㈠伐鍦哄紑灞曟垬鐣ュ悎浣滐紝骞朵粠浠ヤ笅鏂归潰灞曞紑锛氬弻鏂瑰叡鍚屽紑鍚\u20ac滃姪鍒涒\u20ac濊鍔紝浣宠兘涓轰紭瀹㈠伐鍦烘彁渚�60鍙板晢鍔℃墦鍗版満锛屽叆椹讳紭瀹㈠伐鍦虹殑鍒濆垱浼佷笟灏嗘湁鏈轰細浜彈浣宠兘妗岄潰鍔炲叕瑙ｅ喅鏂规甯︽潵鐨勯珮鏁堝姙鍏綋楠屻\u20ac傚苟涓旓紝浣宠兘灏嗘敮鎸佷紭瀹㈠伐鍦哄竷灞\u20ac浜戞墦鍗版湇鍔★紝涓哄叾瀹炵幇鏇存櫤鑳戒笌渚挎嵎鐨勫姙鍏幆澧冿紝婊¤冻鍏变韩鍔炲叕绌洪棿鍐呭叡浜墦鍗般\u20ac佽嚜鍔╂敮浠樻墦鍗扮瓑鍔炲叕鎵撳嵃闇\u20ac姹傘\u20ac�","messageState":0,"messageType":0,"pictureSite":"/static/images/1500867044862.jpeg","spared1":"","spared2":"","spared3":"","title":"鎼烘墜浣宠兘鍏卞姪鍙屽垱","writer":"璧典寒浜�"}],"firm":[]}
     * result : 鎴愬姛
     * code : 200
     */

    private MsgBean msg;
    private String result;
    private String code;

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

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

    public static class MsgBean {
        private List<SpaceBean> space;
        private List<?> firm;

        public List<SpaceBean> getSpace() {
            return space;
        }

        public void setSpace(List<SpaceBean> space) {
            this.space = space;
        }

        public List<?> getFirm() {
            return firm;
        }

        public void setFirm(List<?> firm) {
            this.firm = firm;
        }

        public static class SpaceBean {
            /**
             * issueCompanyId : 0
             * issueSpaceId : 69
             * issueTime : 2017/07/24 11:30:44
             * messageId : 25
             * messageInfo : 鑷粠鍥藉鎺ㄨ繘鍙屽垱娲诲姩鍚庯紝鍒濆垱浼佷笟銆佸叡浜姙鍏┖闂村強鍒涗笟瀛靛寲鍣ㄥ闆ㄥ悗鏄ョ瑡鑸繀閫熸秾鐜般€備紭瀹㈠伐鍦轰綔涓哄浗鍐呭叡浜姙鍏鍩熺殑鐙鍏斤紝涓哄垱涓氬叕鍙告彁渚涗簡鍒涗笟璧勯噾銆佸叆椹诲満鍦板強瀹屽杽鐨勫唴閮ㄩ厤濂楀姛鑳斤紝鍩硅偛浜嗕紬澶氫紭绉€鐨勫垱涓氬搧鐗屻€備匠鑳借瀵熷埌浼樺宸ュ満鍐呬骇鐢熺殑璇稿鍏变韩鎵撳嵃銆佽嚜鍔╂敮浠樻墦鍗扮瓑鏂板瀷鍔炲叕鎵撳嵃妯″紡锛屼互鍙婂叆椹讳紒涓氳繀閫熸垚闀夸骇鐢熺殑澶氭牱鍔炲叕鎵撳嵃闇€姹傦紝閫夋嫨涓庝紭瀹㈠伐鍦哄紑灞曟垬鐣ュ悎浣滐紝骞朵粠浠ヤ笅鏂归潰灞曞紑锛氬弻鏂瑰叡鍚屽紑鍚€滃姪鍒涒€濊鍔紝浣宠兘涓轰紭瀹㈠伐鍦烘彁渚�60鍙板晢鍔℃墦鍗版満锛屽叆椹讳紭瀹㈠伐鍦虹殑鍒濆垱浼佷笟灏嗘湁鏈轰細浜彈浣宠兘妗岄潰鍔炲叕瑙ｅ喅鏂规甯︽潵鐨勯珮鏁堝姙鍏綋楠屻€傚苟涓旓紝浣宠兘灏嗘敮鎸佷紭瀹㈠伐鍦哄竷灞€浜戞墦鍗版湇鍔★紝涓哄叾瀹炵幇鏇存櫤鑳戒笌渚挎嵎鐨勫姙鍏幆澧冿紝婊¤冻鍏变韩鍔炲叕绌洪棿鍐呭叡浜墦鍗般€佽嚜鍔╂敮浠樻墦鍗扮瓑鍔炲叕鎵撳嵃闇€姹傘€�
             * messageState : 0
             * messageType : 0
             * pictureSite : /static/images/1500867044862.jpeg
             * spared1 :
             * spared2 :
             * spared3 :
             * title : 鎼烘墜浣宠兘鍏卞姪鍙屽垱
             * writer : 璧典寒浜�
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
}
