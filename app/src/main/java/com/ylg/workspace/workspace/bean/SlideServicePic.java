package com.ylg.workspace.workspace.bean;

import java.util.List;

/**
 * Created by stu on 2017/7/20.
 */

public class SlideServicePic {

    /**
     * result : 鎴愬姛
     * code : 200
     * msg : [{"date":"2017/07/19 16:45:44","headline":"鏍囬6","id":6,"image":"/static/images/slider/1500263991962.png","url":"192.168.7.240:8012/makerSpace/news.html"},{"date":"2017/07/19 16:45:41","headline":"鏍囬7","id":7,"image":"/static/images/slider/1500263878152.png","url":"192.168.7.240:8012/makerSpace/news.html"},{"date":"2017/07/19 16:45:39","headline":"鏍囬8","id":8,"image":"/static/images/slider/1500263887229.png","url":"192.168.7.240:8012/makerSpace/news.html"},{"date":"2017/07/19 16:45:35","headline":"鏍囬9","id":9,"image":"/static/images/slider/1500263898455.jpg","url":"192.168.7.240:8012/makerSpace/news.html"},{"date":"2017/07/19 16:45:33","headline":"鏍囬10","id":10,"image":"/static/images/slider/1500263908846.png","url":"192.168.7.240:8012/makerSpace/news.html"}]
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
         * date : 2017/07/19 16:45:44
         * headline : 鏍囬6
         * id : 6
         * image : /static/images/slider/1500263991962.png
         * url : 192.168.7.240:8012/makerSpace/news.html
         */

        private String date;
        private String headline;
        private int id;
        private String image;
        private String url;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHeadline() {
            return headline;
        }

        public void setHeadline(String headline) {
            this.headline = headline;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
