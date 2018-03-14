package com.huntor.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by liuyang on 2017/7/28.
 */
@EnableJpaRepositories(basePackages = "com.huntor.demo.dao")
@EntityScan(basePackages = "com.huntor.demo.entity")
public class JpaConfig {
}
