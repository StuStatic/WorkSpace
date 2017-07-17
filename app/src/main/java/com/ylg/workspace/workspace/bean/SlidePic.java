package com.ylg.workspace.workspace.bean;

import java.util.List;

/**
 * Created by stu on 2017/7/17.
 */

public class SlidePic {

    /**
     * result : 鎴愬姛
     * code : 200
     * msg : [{"date":"2017/07/17 10:28:15","headline":"鏍囬1","id":1,"image":"/static/images/slider/1499914078846.jpg","url":"http://www.baidu.com"},{"date":"2017/07/17 10:28:18","headline":"鏍囬2","id":2,"image":"/static/images/slider/1499914078846.jpg","url":"http://www.baidu.com"},{"date":"2017/07/17 10:28:23","headline":"鏍囬3","id":3,"image":"/static/images/slider/1499914078846.jpg","url":"http://www.baidu.com"},{"date":"2017/07/17 10:28:26","headline":"鏍囬4","id":4,"image":"/static/images/slider/1499914078846.jpg","url":"http://www.baidu.com"},{"date":"2017/07/17 10:28:29","headline":"鏍囬5","id":5,"image":"/static/images/slider/1499914078846.jpg","url":"http://www.baidu.com"}]
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
         * date : 2017/07/17 10:28:15
         * headline : 鏍囬1
         * id : 1
         * image : /static/images/slider/1499914078846.jpg
         * url : http://www.baidu.com
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
