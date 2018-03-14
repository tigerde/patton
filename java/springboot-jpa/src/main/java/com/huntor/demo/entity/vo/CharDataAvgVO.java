package com.huntor.demo.entity.vo;

import java.util.List;
import java.util.Map;

/**
 * Created by liuyang on 2017/8/28.
 */
public class CharDataAvgVO{
    private Map<String,Object> marker;
    private String type;
    private String name;
    private List<Double> data;

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

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }

    public Map<String, Object> getMarker() {
        return marker;
    }

    public void setMarker(Map<String, Object> marker) {
        this.marker = marker;
    }
}
