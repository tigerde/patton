package com.huntor.demo.dao;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.huntor.demo.entity.CustomerTag;

public interface CustomerTagDao extends MongoRepository<CustomerTag, Serializable> {
	
	CustomerTag findByCustomerid(String customerid);
}
