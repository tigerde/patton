package com.huntor.demo.entity.vo;

public class LifeCycleStatisticsVO {
	private String last_life_cycle_id;
	private String last_life_cycle_name;
	private String life_cycle_id;
	private String life_cycle_name;
	private int trans_count;

	public String getLast_life_cycle_id() {
		return last_life_cycle_id;
	}

	public void setLast_life_cycle_id(String last_life_cycle_id) {
		this.last_life_cycle_id = last_life_cycle_id;
	}

	public String getLast_life_cycle_name() {
		return last_life_cycle_name;
	}

	public void setLast_life_cycle_name(String last_life_cycle_name) {
		this.last_life_cycle_name = last_life_cycle_name;
	}

	public String getLife_cycle_id() {
		return life_cycle_id;
	}

	public void setLife_cycle_id(String life_cycle_id) {
		this.life_cycle_id = life_cycle_id;
	}

	public String getLife_cycle_name() {
		return life_cycle_name;
	}

	public void setLife_cycle_name(String life_cycle_name) {
		this.life_cycle_name = life_cycle_name;
	}

	public int getTrans_count() {
		return trans_count;
	}

	public void setTrans_count(int trans_count) {
		this.trans_count = trans_count;
	}

}
