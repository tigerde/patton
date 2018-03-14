package com.huntor.demo.entity.vo;

import java.util.List;

/**
 * Created by liuyang on 2017/8/20.
 */
public class LifeCycleSaveVO {
	private Integer lifeCycleId;
	private String lifeCycleName;
	private String showPriority;
	private String calculationPriority;
	private String enable;
	private String attributeValueId;
	private String description;
	private Integer runCycle;
	private List<LifeCycleRuleVO> ruleList;

	public Integer getLifeCycleId() {
		return lifeCycleId;
	}

	public void setLifeCycleId(Integer lifeCycleId) {
		this.lifeCycleId = lifeCycleId;
	}

	public String getLifeCycleName() {
		return lifeCycleName;
	}

	public void setLifeCycleName(String lifeCycleName) {
		this.lifeCycleName = lifeCycleName;
	}

	public String getShowPriority() {
		return showPriority;
	}

	public void setShowPriority(String showPriority) {
		this.showPriority = showPriority;
	}

	public String getCalculationPriority() {
		return calculationPriority;
	}

	public void setCalculationPriority(String calculationPriority) {
		this.calculationPriority = calculationPriority;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public List<LifeCycleRuleVO> getRuleList() {
		return ruleList;
	}

	public void setRuleList(List<LifeCycleRuleVO> ruleList) {
		this.ruleList = ruleList;
	}

	public String getAttributeValueId() {
		return attributeValueId;
	}

	public void setAttributeValueId(String attributeValueId) {
		this.attributeValueId = attributeValueId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRunCycle() {
		return runCycle;
	}

	public void setRunCycle(Integer runCycle) {
		this.runCycle = runCycle;
	}


	@Override
	public String toString() {
		return "LifeCycleSaveVO{" + "lifeCycleName='" + lifeCycleName + '\'' + ", showPriority='" + showPriority + '\''
				+ ", calculationPriority='" + calculationPriority + '\'' + ", enable='" + enable + '\''
				+ ", attributeValueId='" + attributeValueId + '\'' + ", ruleList=" + ruleList + '}';
	}
}
