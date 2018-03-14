package com.huntor.demo.entity.vo;

import java.util.Date;

/**
 * Created by liuyang on 2017/9/12.
 */
public class CountTimeVO {
    private Long count;
    private Date createdAt;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CountTimeVO{" +
                "count=" + count +
                ", createdAt=" + createdAt +
                '}';
    }
}
