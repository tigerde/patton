package com.huntor.demo.entity.vo;

import java.util.List;

public class LifeCycleStatusVO {
	private List<LifeCycleLogVO> lifecylestatus;
	private List<LifeCycleStatisticsVO> lifecylerelationship;

	public List<LifeCycleLogVO> getLifecylestatus() {
		return lifecylestatus;
	}

	public void setLifecylestatus(List<LifeCycleLogVO> lifecylestatus) {
		this.lifecylestatus = lifecylestatus;
	}

	public List<LifeCycleStatisticsVO> getLifecylerelationship() {
		return lifecylerelationship;
	}

	public void setLifecylerelationship(List<LifeCycleStatisticsVO> lifecylerelationship) {
		this.lifecylerelationship = lifecylerelationship;
	}

}
