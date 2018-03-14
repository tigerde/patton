package com.huntor.demo.entity.vo;

import com.huntor.demo.entity.TagLifeCycle;

/**
 * Created by liuyang on 2017/8/31.
 */
public class TagLifeCycleVO extends TagLifeCycle {
    private String status;
    private String time;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
