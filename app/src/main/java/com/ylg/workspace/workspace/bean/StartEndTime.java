package com.ylg.workspace.workspace.bean;

/**
 * Created by Administrator on 2017/9/22.
 */

public class StartEndTime {
    @Override
    public String toString() {
        return "StartEndTime{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    private int startTime ;
    private int endTime;

    public StartEndTime(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
