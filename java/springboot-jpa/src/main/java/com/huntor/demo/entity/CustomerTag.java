package com.huntor.demo.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customer_tag")
public class CustomerTag {

	@Id
	private String id;
	@Field(value = "customer_id")
	private String customerid;
	private String life_cycle_id;
	private String life_cycle_name;
	private Date life_cycle_update_at;
	private Date update_at;
	private Date create_at;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
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

	public Date getLife_cycle_update_at() {
		return life_cycle_update_at;
	}

	public void setLife_cycle_update_at(Date life_cycle_update_at) {
		this.life_cycle_update_at = life_cycle_update_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

}
