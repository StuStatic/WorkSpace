package com.ylg.workspace.workspace.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/8.
 */

public class Circle {

    /**
     * code : 200
     * msg : [{"creationTime":"2017/09/07 14:11:54","picture":"/static/images/user/1811168522.jpg","shareId":9,"sharePicture":"/static/images/share/15047647146370.png,/static/images/share/15047647146371.png","spaceId":69,"textWord":"Fdfdfdfdf","userId":1,"userName":"鏄撹仈娓�"},{"creationTime":"2017/09/07 14:08:43","picture":"/static/images/user/1811168522.jpg","shareId":8,"sharePicture":"/static/images/share/15047645232710.png","spaceId":69,"textWord":"鎯充綘鎵\u20ac鎯筹紝鍐欎綘鎯宠...","userId":1,"userName":"鏄撹仈娓�"},{"creationTime":"2017/09/06 16:42:06","picture":"/static/images/user/1811168522.jpg","shareId":7,"sharePicture":"/static/images/share/15046873261500.png,/static/images/share/15046873261511.png,/static/images/share/15046873261522.png","spaceId":69,"textWord":"鎯充綘鎵\u20ac鎯筹紝鍐欎綘鎯宠...","userId":1,"userName":"鏄撹仈娓�"},{"creationTime":"2017/09/06 16:27:31","picture":"/static/images/user/1811168522.jpg","shareId":6,"sharePicture":"/static/images/share/15046864516570.png,/static/images/share/15046864516591.png","spaceId":69,"textWord":"Huh","userId":1,"userName":"鏄撹仈娓�"},{"creationTime":"2017/09/06 16:27:30","picture":"/static/images/user/1811168522.jpg","shareId":5,"sharePicture":"/static/images/share/15046864508960.png,/static/images/share/15046864508971.png","spaceId":69,"textWord":"Huh","userId":1,"userName":"鏄撹仈娓�"}]
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
         * creationTime : 2017/09/07 14:11:54
         * picture : /static/images/user/1811168522.jpg
         * shareId : 9
         * sharePicture : /static/images/share/15047647146370.png,/static/images/share/15047647146371.png
         * spaceId : 69
         * textWord : Fdfdfdfdf
         * userId : 1
         * userName : 鏄撹仈娓�
         */

        private String creationTime;
        private String picture;
        private int shareId;
        private String sharePicture;
        private int spaceId;
        private String textWord;
        private int userId;
        private String userName;

        public String getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(String creationTime) {
            this.creationTime = creationTime;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public int getShareId() {
            return shareId;
        }

        public void setShareId(int shareId) {
            this.shareId = shareId;
        }

        public String getSharePicture() {
            return sharePicture;
        }

        public void setSharePicture(String sharePicture) {
            this.sharePicture = sharePicture;
        }

        public int getSpaceId() {
            return spaceId;
        }

        public void setSpaceId(int spaceId) {
            this.spaceId = spaceId;
        }

        public String getTextWord() {
            return textWord;
        }

        public void setTextWord(String textWord) {
            this.textWord = textWord;
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
    }
}
