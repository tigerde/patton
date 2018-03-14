package com.huntor.demo.entity.vo;

import java.util.List;

/**
 * Created by liuyang on 2017/8/1.
 */
public class ViewDataVO {
    private List<ViewListVO> viewListVOs;
    private Long totalSize;
    private Integer currentPage;

    public List<ViewListVO> getViewListVOs() {
        return viewListVOs;
    }

    public void setViewListVOs(List<ViewListVO> viewListVOs) {
        this.viewListVOs = viewListVOs;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
