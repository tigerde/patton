package com.huntor.demo.entity.vo;

import java.util.List;

/**
 * Created by liuyang on 2017/8/14.
 */
public class CharDataVO {
    private String type;
    private String name;
    private List<Long> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getData() {
        return data;
    }

    public void setData(List<Long> data) {
        this.data = data;
    }
}
