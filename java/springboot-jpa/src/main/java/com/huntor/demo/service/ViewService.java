package com.huntor.demo.service;

import com.huntor.demo.dao.AttrDefinitionDao;
import com.huntor.demo.dao.AttrStatisticsDao;
import com.huntor.demo.entity.AttrDefinition;
import com.huntor.demo.entity.AttrStatistics;
import com.huntor.demo.entity.vo.ViewDataVO;
import com.huntor.demo.entity.vo.ViewListVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyang on 2017/8/1.
 */
@Service
public class ViewService {

    @Resource
    private AttrDefinitionDao attrDefinitionDao;
    @Resource
    private AttrStatisticsDao attrStatisticsDao;

    public ViewDataVO viewList(final Integer id, Integer page, Integer size){
        Pageable pageable = new PageRequest(page-1, size);
        Page<AttrDefinition> attrPage = attrDefinitionDao.findAll(new Specification<AttrDefinition>(){
            @Override
            public Predicate toPredicate(Root<AttrDefinition> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p=criteriaBuilder.equal(root.get("attributeId").as(Integer.class), id);
                criteriaQuery.where(criteriaBuilder.and(p));
                return criteriaQuery.getRestriction();
            }
        },pageable);
        List<AttrDefinition> attrDefinitions=attrPage.getContent();
        List<ViewListVO> viewListVOs=new ArrayList<>();
        for (AttrDefinition attr: attrDefinitions){
            AttrStatistics attrStatistics=attrStatisticsDao.findByAttributeId(attr.getId());
            ViewListVO viewListVO=new ViewListVO();
            viewListVO.setAttributeName(attr.getAttributeNameChs());
            viewListVO.setAttributeNameDesc(attr.getAttributeNameDesc());
            viewListVO.setDataType(attr.getDataType());
            viewListVO.setValueRange(attr.getValueRange());
            if ("数字".equals(attr.getDataType())){
                viewListVO.setDataType("数值");
            }
            viewListVO.setValueRange(attr.getValueRange());
            if(">0".equals(attr.getValueRange())){
                viewListVO.setValueRange(">=0");
            }
            double   f   =   attrStatistics.getRate();
            f=f*100;
            BigDecimal b   =   new   BigDecimal(f);
            double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
            viewListVO.setRate(f1+"%");
            viewListVO.setUpdateRate(attrStatistics.getUpdateRate());
            if ("day".equals(attrStatistics.getUpdateRate())){
                viewListVO.setUpdateRate("每天");
            }
            viewListVO.setUpdateAt(attrStatistics.getUpdateAt());
            f=attrStatistics.getCustomerUpdateRate();
            f=f*100;
            b=new   BigDecimal(f);
            f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
            viewListVO.setCustomerUpdateRate(f1+"%");
            viewListVO.setAttributeId(attrStatistics.getAttributeId());
            viewListVOs.add(viewListVO);
        }
        ViewDataVO viewDataVO =new ViewDataVO();
        viewDataVO.setViewListVOs(viewListVOs);
        viewDataVO.setCurrentPage(page);
        viewDataVO.setTotalSize(attrPage.getTotalElements());
        return viewDataVO;
    }


}