package com.ylg.workspace.workspace.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by m1324 on 2017/8/11.
 */

public class WeiXinPay {


    /**
     * result : æå
     * code : 200
     * msg : {"result_code":"SUCCESS","sign":"580A03DF720C7AF5DCA3FD0F669448D8","mch_id":"1486735342","timeStamp":"1502355222","prepay_id":"wx201708101653417fd4f337390877382753","return_msg":"OK","package":"Sign=WXPay","appid":"wxa41b37164b2030d6","nonce_str":"FeNPZHDniqlHnGNJ","return_code":"SUCCESS","device_info":"WEB","trade_type":"APP"}
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
         * result_code : SUCCESS
         * sign : 580A03DF720C7AF5DCA3FD0F669448D8
         * mch_id : 1486735342
         * timeStamp : 1502355222
         * prepay_id : wx201708101653417fd4f337390877382753
         * return_msg : OK
         * package : Sign=WXPay
         * appid : wxa41b37164b2030d6
         * nonce_str : FeNPZHDniqlHnGNJ
         * return_code : SUCCESS
         * device_info : WEB
         * trade_type : APP
         */

        private String result_code;
        private String sign;
        private String mch_id;
        private String timeStamp;
        private String prepay_id;
        private String return_msg;
        @SerializedName("package")
        private String packageX;
        private String appid;
        private String nonce_str;
        private String return_code;
        private String device_info;
        private String trade_type;

        public String getResult_code() {
            return result_code;
        }

        public void setResult_code(String result_code) {
            this.result_code = result_code;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getMch_id() {
            return mch_id;
        }

        public void setMch_id(String mch_id) {
            this.mch_id = mch_id;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getPrepay_id() {
            return prepay_id;
        }

        public void setPrepay_id(String prepay_id) {
            this.prepay_id = prepay_id;
        }

        public String getReturn_msg() {
            return return_msg;
        }

        public void setReturn_msg(String return_msg) {
            this.return_msg = return_msg;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getNonce_str() {
            return nonce_str;
        }

        public void setNonce_str(String nonce_str) {
            this.nonce_str = nonce_str;
        }

        public String getReturn_code() {
            return return_code;
        }

        public void setReturn_code(String return_code) {
            this.return_code = return_code;
        }

        public String getDevice_info() {
            return device_info;
        }

        public void setDevice_info(String device_info) {
            this.device_info = device_info;
        }

        public String getTrade_type() {
            return trade_type;
        }

        public void setTrade_type(String trade_type) {
            this.trade_type = trade_type;
        }
    }

}
