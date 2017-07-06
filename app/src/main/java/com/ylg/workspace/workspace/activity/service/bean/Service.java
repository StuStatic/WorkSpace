package com.ylg.workspace.workspace.activity.service.bean;

/**
 * Created by Administrator on 2017/7/6.
 */

public class Service {
    @Override
    public String toString() {
        return "Service{" +
                "result='" + result + '\'' +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    /**
     * result : 鎴愬姛
     * code : 200
     * msg :
     */

    private String result;
    private String code;
    private String msg;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
