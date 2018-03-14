package com.huntor.demo.entity.vo;

/**
 * Created by liuyang on 2017/8/10.
 */
public class LifeCycleListVO {
    private Integer id;
    private String lifeCycleName;
    private Integer showPriority;
    private Integer calculationPriority;
    private String enable;
    private String state;
    private Integer inNumber;
    private Integer outNumber;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLifeCycleName() {
        return lifeCycleName;
    }

    public void setLifeCycleName(String lifeCycleName) {
        this.lifeCycleName = lifeCycleName;
    }

    public Integer getShowPriority() {
        return showPriority;
    }

    public void setShowPriority(Integer showPriority) {
        this.showPriority = showPriority;
    }

    public Integer getCalculationPriority() {
        return calculationPriority;
    }

    public void setCalculationPriority(Integer calculationPriority) {
        this.calculationPriority = calculationPriority;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public Integer getInNumber() {
        return inNumber;
    }

    public void setInNumber(Integer inNumber) {
        this.inNumber = inNumber;
    }

    public Integer getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(Integer outNumber) {
        this.outNumber = outNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "LifeCycleListVO{" +
                "id=" + id +
                ", lifeCycleName='" + lifeCycleName + '\'' +
                ", showPriority=" + showPriority +
                ", calculationPriority=" + calculationPriority +
                ", enable='" + enable + '\'' +
                ", state='" + state + '\'' +
                ", inNumber=" + inNumber +
                ", outNumber=" + outNumber +
                '}';
    }
}
