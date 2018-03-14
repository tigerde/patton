package com.huntor.demo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.huntor.tools.Dates;
import com.huntor.tools.StringUtil;
import com.huntor.demo.dao.*;
import com.huntor.demo.entity.*;
import com.huntor.demo.entity.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huntor.tools.DateUtil;

/**
 * Created by liuyang on 2017/8/10.
 */
@Service
@Transactional
public class LifeCycleService {

    @Resource
    private TagLifeCycleDao tagLifeCycleDao;

    @Resource
    private TagLifeCycleLogDao tagLifeCycleLogDao;

    @Resource
    private TagLifeCycleTransDao tagLifeCycleTransDao;

    @Resource
    private TagLifeCycleRuleDao tagLifeCycleRuleDao;
    @Resource
    private TagAttributeDao tagAttributeDao;

    @Resource
    private TagAttributeValueDao tagAttributeValueDao;
    @Resource
    private TagLifeCycleStatisticsDao tagLifeCycleStatisticsDao;
    
    @Resource
    private CustomerTagDao customerTagDao;


    public Map<String,Object> findLifeCycleList(Integer page, Integer size){
        Pageable pageable = new PageRequest(page-1, size);
        Map<String,Object> resMap= new HashMap<>();
        Page<TagLifeCycle> attrPage = tagLifeCycleDao.findAll(new Specification<TagLifeCycle>(){
            @Override
            public Predicate toPredicate(Root<TagLifeCycle> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p=criteriaBuilder.equal(root.get("isDelete").as(String.class), "1");
                criteriaQuery.where(criteriaBuilder.and(p));
                return criteriaQuery.getRestriction();
            }
        },pageable);
        List<TagLifeCycle> tagLifeCycles =attrPage.getContent();
        List<LifeCycleListVO> lifeCycleListVOs=new ArrayList<>();
        for (TagLifeCycle l : tagLifeCycles){
            LifeCycleListVO lifeCycleListVO=new LifeCycleListVO();
            lifeCycleListVO.setId(l.getId());
            lifeCycleListVO.setCalculationPriority(l.getCalculationPriority());
            if ("1".equals(l.getEnable())){
                lifeCycleListVO.setEnable("有效");
            }else {
                lifeCycleListVO.setEnable("无效");
            }
            lifeCycleListVO.setLifeCycleName(l.getLifeCycleName());
            lifeCycleListVO.setShowPriority(l.getShowPriority());
            List<TagLifeCycleLog> logs=tagLifeCycleLogDao.findByLifeCycleId(l.getId());
            StringBuffer str=new StringBuffer();
            if(logs.size()>0){
                TagLifeCycleLog log=logs.get(0);
                lifeCycleListVO.setInNumber(log.getInNumber());
                lifeCycleListVO.setOutNumber(log.getOutNumber());
                str.append("自动计算").append(",");
                switch (log.getIsSuccees()){
                    case "0":
                        str.append("失败,");
                        break;
                    case "1":
                        str.append("成功,");
                        break;
                }
                str.append("执行时间").append(log.getCalculationTime()).append("分钟,结束于");
                str.append(Dates.format(log.getCreateTime()));
            }

            lifeCycleListVO.setState(str.toString());
            lifeCycleListVOs.add(lifeCycleListVO);
        }
        resMap.put("data",lifeCycleListVOs);
        resMap.put("currentPage",page);
        resMap.put("totalSize",attrPage.getTotalElements());
        return resMap;
    }

    public void deleteBYLCADefinition(Integer id){
        TagLifeCycle tagLifeCycle=tagLifeCycleDao.findOne(id);
        tagLifeCycle.setIsDelete("0");
        tagLifeCycleDao.saveAndFlush(tagLifeCycle);
    }

    public Map<String,Object> findReportData(){
        List<TagLifeCycle> strs= tagLifeCycleDao.findAll(new Specification<TagLifeCycle>(){
            @Override
            public Predicate toPredicate(Root<TagLifeCycle> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p=criteriaBuilder.equal(root.get("isDelete").as(String.class), "1");
                criteriaQuery.where(criteriaBuilder.and(p));
                return criteriaQuery.getRestriction();
            }
        });
        List<Object> charDataVOs=new ArrayList<>();
        List<CharDataVO> charDataVOList=new ArrayList<>();
        List<String> strings=new ArrayList<>();
        List<Integer> integers=new ArrayList<>();
        Map<String,Object> dataMap=new HashMap<>();
        List<PieDataVO> pieDataVOList=new ArrayList<>();
        int c=0;
        for (TagLifeCycle l: strs){
            c++;
            CharDataVO charDataVO=new CharDataVO();
            charDataVO.setName(l.getLifeCycleName());
            charDataVO.setType("column");
            //获取当前日期
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date today = new Date();
            String endDate = sdf.format(today);//当前日期

            //获取三十天前日期
            Calendar theCa = Calendar.getInstance();
            theCa.setTime(today);
            theCa.add(theCa.DATE, -30);//最后一个数字30可改，30天的意思
            Date start = theCa.getTime();
            String startDate = sdf.format(start);//三十天之前日期
            List<Long> conut=tagLifeCycleTransDao.findCount(start,today,l.getId());
            Integer totalCount=tagLifeCycleTransDao.findTotalCount(start,today,l.getId());
            List<Date> list=tagLifeCycleTransDao.findCountAndTime(start,today,l.getId());
            for (Date s:list){
                strings.add(Dates.format(s));
            }
            System.out.println("注意注意@@@@"+list.toString());
            PieDataVO pieDataVO=new PieDataVO();
            pieDataVO.setName(l.getLifeCycleName());
            if (conut.size()>0){
                pieDataVO.setY(conut.get(conut.size()-1).intValue());
            }else{
                pieDataVO.setY(0);
            }
            switch(c)
            {
                case 1:
                    pieDataVO.setColor("#7cb5ec");
                    break;
                case 2:
                    pieDataVO.setColor("#434348");
                    break;
                case 3:
                    pieDataVO.setColor("#90ed7d");
                    break;
                case 4:
                    pieDataVO.setColor("#f7a35c");
                    break;
                case 5:
                    pieDataVO.setColor("#8085e9");
                    break;
                case 6:
                    pieDataVO.setColor("#f15c80");
                    break;
                case 7:
                    pieDataVO.setColor("#e4d354");
                    break;
                case 9:
                    pieDataVO.setColor("#2b908f");
                    break;
                case 10:
                    pieDataVO.setColor("#f45b5b");
                    break;
                case 11:
                    pieDataVO.setColor("#91e8e1");
                    break;
            }
            pieDataVOList.add(pieDataVO);
            integers.add(conut.size());
            charDataVO.setData(conut);
            charDataVOList.add(charDataVO);
            charDataVOs.add(charDataVO);
        }
        List<Double> avgs=new ArrayList<>();
        for (int i=0;i<charDataVOList.get(0).getData().size();i++){
            Long avg=0l;
            for (CharDataVO v: charDataVOList){
                if (v.getData().size()>0){
                    Long num=v.getData().get(i);
                    avg=avg+num;
                }
            }
//            avg=avg%charDataVOList.get(0).getData().size();
            double progress = avg/(double)charDataVOList.size();

            System.out.printf("%.2f\n", progress);
            avgs.add(progress);
        }
        CharDataAvgVO charDataAvgVO=new CharDataAvgVO();
        charDataAvgVO.setName("平均值");
        charDataAvgVO.setType("spline");
        charDataAvgVO.setData(avgs);
        Map<String,Object> markerMap=new HashMap<>();
        markerMap.put("lineWidth",2);
        markerMap.put("lineColor","#90ed7d");
        markerMap.put("fillColor","white");
        charDataAvgVO.setMarker(markerMap);

        //冒泡求出最大的日子
        for (int i=0;i<integers.size()-1;i++){
            for (int j=1;j<integers.size()-i;j++){
                Integer a;
                if (integers.get(j-1).compareTo(integers.get(j))>0){
                    a = integers.get(j - 1);
                    integers.set((j - 1), integers.get(j));
                    integers.set(j, a);
                }
            }
        }

//        for (int i=1;i<integers.get(integers.size()-1)+1;i++){
//            strings.add("第"+i+"天");
//        }
        List<Integer> number = new ArrayList<>();
        number.add(100);
        number.add(80);
        dataMap.put("type","pie");
        dataMap.put("name","数量");
        dataMap.put("center",number);
        dataMap.put("size",100);
        dataMap.put("showInLegend",false);
        Map map=new HashMap<>();
        map.put("enabled",false);
        dataMap.put("dataLabels",map);
        dataMap.put("data",pieDataVOList);
        charDataVOs.add(dataMap);
        charDataVOs.add(charDataAvgVO);
        Map<String,Object> resMap=new HashMap<>();
        resMap.put("series",charDataVOs);
        resMap.put("categories",strings);
//        resMap.put("data",pieDataVOList);
        return resMap;
    }

    public Map<String,Object> findDetails(Integer id){
        List<TagLifeCycleLog> tagLifeCycleLogss=tagLifeCycleLogDao.findByLifeCycleId(id);
        List<TagLifeCycleLogVO> tagLifeCycleLogs=new ArrayList<>();
        int i=0;
        for (TagLifeCycleLog log : tagLifeCycleLogss){
            i++;
            if (i>5){
                break;
            }
            TagLifeCycleLogVO tagLifeCycleLogVO=new TagLifeCycleLogVO();
            BeanUtils.copyProperties(log,tagLifeCycleLogVO);
            if ("1".equals(log.getIsSuccees())){
                tagLifeCycleLogVO.setIsSucceesText("成功");
            }else {
                tagLifeCycleLogVO.setIsSucceesText("失败");
            }
            tagLifeCycleLogVO.setCalculationType("自动计算");
//            tagLifeCycleLogVO.setC
            tagLifeCycleLogs.add(tagLifeCycleLogVO);
        }
//        if(tagLifeCycleLogss.size()>0){
//            TagLifeCycleLog tagLifeCycleLog=tagLifeCycleLogss.get(0);
//            TagLifeCycleLogVO tagLifeCycleLogVO=new TagLifeCycleLogVO();
//            BeanUtils.copyProperties(tagLifeCycleLog,tagLifeCycleLogVO);
//            if ("1".equals(tagLifeCycleLog.getIsSuccees())){
//                tagLifeCycleLogVO.setIsSucceesText("成功");
//            }else {
//                tagLifeCycleLogVO.setIsSucceesText("失败");
//            }
//            tagLifeCycleLogs.add(tagLifeCycleLogVO);
//        }

        TagLifeCycle tagLifeCycle=tagLifeCycleDao.findOne(id);
        TagLifeCycleVO tagLifeCycleLogVO=new TagLifeCycleVO();
        BeanUtils.copyProperties(tagLifeCycle,tagLifeCycleLogVO);
        if ("1".equals(tagLifeCycleLogVO.getEnable())){
            tagLifeCycleLogVO.setStatus("有效");
        }else {
            tagLifeCycleLogVO.setStatus("无效");
        }
        List<TagLifeCycleRule> tagLifeCycleRules =tagLifeCycleRuleDao.findByLifeCycleId(id);
        List<TagLifeCycleRuleVO> tagLifeCycleRuleVOs=new ArrayList<>();
        for (TagLifeCycleRule rule:tagLifeCycleRules){
            TagAttributeValue tagAttributeValue=tagAttributeValueDao.findOne(rule.getAttributeValueId());
            TagAttribute tagAttribute=tagAttributeDao.findOne(tagAttributeValue.getAttributeId());
            TagLifeCycleRuleVO tagLifeCycleRuleVO=new TagLifeCycleRuleVO();
            BeanUtils.copyProperties(rule,tagLifeCycleRuleVO);
            tagLifeCycleRuleVO.setAttributeValueText(tagAttributeValue.getAttributeValueName());
            tagLifeCycleRuleVO.setAttributeNameText(tagAttribute.getAttributeColumnName());
            tagLifeCycleRuleVOs.add(tagLifeCycleRuleVO);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("tabledata",tagLifeCycleLogs);
        map.put("tabledata2",tagLifeCycleRuleVOs);
        map.put("tagLifeCycle",tagLifeCycleLogVO);
        return map;

    }
    public String SaveLifeCycle(LifeCycleSaveVO data){
        if (StringUtil.isNull(data.getLifeCycleName()) || StringUtil.isNull(data.getCalculationPriority()) || StringUtil.isNull(data.getShowPriority())){
            return "生命周期阶段、显示优先级、计算优先级不能为空";
        }
        if (Integer.valueOf(data.getCalculationPriority())<=0){
            return "计算优先级不能为负数";
        }
        if (Integer.valueOf(data.getShowPriority())<=0){
            return "显示优先级不能为负数";
        }
        if (data.getLifeCycleName().length()>10){
            return "生命周期阶段不能超过10个字";
        }
        if (!StringUtil.isNull(data.getDescription())&&data.getDescription().length()>100){
            return "描述不能超过100个字";
        }
        if (StringUtil.isNull(data.getEnable())){
            return "是否有效不能为空";
        }
        if (data.getRuleList()==null || data.getRuleList().size()==0){
            return "规则属性不能为空";
        }
        List<LifeCycleRuleVO> lifeCycleRuleVOs=data.getRuleList();
        List<String> listStr=new ArrayList<>();
        for (LifeCycleRuleVO v: lifeCycleRuleVOs){
            listStr.add(v.getAttributeValue());
        }
        if (findRepetition(listStr)){
            return "规则属性不能重复";
        }
        Integer exists=tagLifeCycleDao.findLifeCyleExists(data.getLifeCycleName(),Integer.valueOf(data.getShowPriority()),Integer.valueOf(data.getCalculationPriority()));
        if (exists==null){
            TagLifeCycle tagLifeCycle=new TagLifeCycle();
            tagLifeCycle.setCalculationPriority(Integer.valueOf(data.getCalculationPriority()));
            tagLifeCycle.setEnable(data.getEnable());
            tagLifeCycle.setShowPriority(Integer.valueOf(data.getShowPriority()));
            tagLifeCycle.setLifeCycleName(data.getLifeCycleName());
            tagLifeCycle.setIsDelete("1");
            tagLifeCycle.setCreatedAt(new Date());
            tagLifeCycle.setUpdatedAt(new Date());
            tagLifeCycle.setDescription(data.getDescription());
            tagLifeCycle.setRunCycle(data.getRunCycle());
            tagLifeCycleDao.save(tagLifeCycle);
            for (LifeCycleRuleVO v: lifeCycleRuleVOs){
                TagAttributeValue tagAttributeValue=tagAttributeValueDao.findOne(Integer.valueOf(v.getAttributeId()));
                TagAttribute tagAttribute=tagAttributeDao.findByAttributeColumnName(v.getAttributeName());
                TagLifeCycleRule tagLifeCycleRule=new TagLifeCycleRule();
                tagLifeCycleRule.setLifeCycleId(tagLifeCycle.getId());
                tagLifeCycleRule.setUpdatedAt(new Date());
                tagLifeCycleRule.setCreatedAt(new Date());
                tagLifeCycleRule.setLifeCycleName(data.getLifeCycleName());
                tagLifeCycleRule.setAttributeId(tagAttribute.getId());
                tagLifeCycleRule.setAttributeValue(v.getAttributeValue());
                tagLifeCycleRule.setAttributeName(tagAttribute.getAttributeName());
                tagLifeCycleRule.setRelationalSymbol(v.getRelationalSymbol());
                tagLifeCycleRule.setRuleOperator(v.getRuleOperator());
                tagLifeCycleRule.setAttributeValueId(tagAttributeValue.getId());
                tagLifeCycleRule.setAttributeValue(tagAttributeValue.getAttributeValue());
                tagLifeCycleRule.setRuleAttributeNumber(tagAttributeValue.getAttributeId());
                tagLifeCycleRuleDao.save(tagLifeCycleRule);
            }
        }else {
            return "规则属性不能为空";
        }
        return "success";
    }

    public String editLifeCycle(LifeCycleSaveVO data){
        TagLifeCycle tag=tagLifeCycleDao.findOne(data.getLifeCycleId());
        if (tag==null){
            return "生命周期标签不存在";
        }
        if (StringUtil.isNull(data.getLifeCycleName()) || StringUtil.isNull(data.getCalculationPriority()) || StringUtil.isNull(data.getShowPriority())){
            return "生命周期阶段、显示优先级、计算优先级不能为空";
        }
        if (Integer.valueOf(data.getCalculationPriority())<=0){
            return "计算优先级不能为负数";
        }
        if (Integer.valueOf(data.getShowPriority())<=0){
            return "显示优先级不能为负数";
        }
        if (data.getLifeCycleName().length()>10){
            return "生命周期阶段不能超过10个字";
        }
        if (!StringUtil.isNull(data.getDescription())&&data.getDescription().length()>100){
            return "描述不能超过100个字";
        }
        if (StringUtil.isNull(data.getEnable())){
            return "是否有效不能为空";
        }
        if (!data.getCalculationPriority().equals(tag.getCalculationPriority().toString())){
            TagLifeCycle t=tagLifeCycleDao.findbyCalculationPriorityAndisDelete(Integer.valueOf(data.getCalculationPriority()),"1");
            if (t!=null){
                return "计算优先级不能重复";
            }
        }
        if (!data.getShowPriority().equals(tag.getShowPriority().toString())){
            TagLifeCycle t=tagLifeCycleDao.findbyShowPriorityAndisDelete(Integer.valueOf(data.getShowPriority()),"1");
            if (t!=null){
                return "显示优先级不能重复";
            }
        }
        if (data.getRuleList()==null || data.getRuleList().size()==0){
            return "规则属性不能为空";
        }
        if (!data.getLifeCycleName().equals(tag.getLifeCycleName().toString())){
            TagLifeCycle t=tagLifeCycleDao.findbyLifeCycleNameAndisDelete(data.getLifeCycleName(),"1");
            if (t!=null){
                return "生命周期阶段不能重复";
            }
        }
        List<LifeCycleRuleVO> lifeCycleRuleVOs=data.getRuleList();
        List<String> listStr=new ArrayList<>();
        for (LifeCycleRuleVO v: lifeCycleRuleVOs){
            listStr.add(v.getAttributeValue());
        }
        if (findRepetition(listStr)){
            return "规则属性不能重复";
        }
            TagLifeCycle tagLifeCycle=new TagLifeCycle();
            tagLifeCycle.setId(data.getLifeCycleId());
            tagLifeCycle.setCalculationPriority(Integer.valueOf(data.getCalculationPriority()));
            tagLifeCycle.setEnable(data.getEnable());
            tagLifeCycle.setShowPriority(Integer.valueOf(data.getShowPriority()));
            tagLifeCycle.setLifeCycleName(data.getLifeCycleName());
            tagLifeCycle.setIsDelete("1");
            tagLifeCycle.setCreatedAt(new Date());
            tagLifeCycle.setUpdatedAt(new Date());
            tagLifeCycle.setDescription(data.getDescription());
            tagLifeCycle.setRunCycle(data.getRunCycle());
            tagLifeCycleDao.saveAndFlush(tagLifeCycle);
            List<TagLifeCycleRule> lifeCycleRuleList=tagLifeCycleRuleDao.findByLifeCycleId(tagLifeCycle.getId());
            for (TagLifeCycleRule r: lifeCycleRuleList){
                tagLifeCycleRuleDao.delete(r);
            }
            for (LifeCycleRuleVO v: lifeCycleRuleVOs){
                TagAttributeValue tagAttributeValue=tagAttributeValueDao.findOne(Integer.valueOf(v.getAttributeId()));
                TagLifeCycleRule tagLifeCycleRule=new TagLifeCycleRule();
                tagLifeCycleRule.setLifeCycleId(tagLifeCycle.getId());
                tagLifeCycleRule.setUpdatedAt(new Date());
                tagLifeCycleRule.setCreatedAt(new Date());
                tagLifeCycleRule.setLifeCycleName(data.getLifeCycleName());
                tagLifeCycleRule.setAttributeId(Integer.valueOf(v.getAttributeId()));
                tagLifeCycleRule.setAttributeValue(v.getAttributeValue());
                tagLifeCycleRule.setAttributeName(v.getAttributeName());
                tagLifeCycleRule.setRelationalSymbol(v.getRelationalSymbol());
                tagLifeCycleRule.setRuleOperator(v.getRuleOperator());
                tagLifeCycleRule.setAttributeValueId(tagAttributeValue.getId());
                tagLifeCycleRule.setAttributeValue(tagAttributeValue.getAttributeValue());
                tagLifeCycleRule.setRuleAttributeNumber(tagAttributeValue.getAttributeId());
//                if (v.getId()!=0){
//                    tagLifeCycleRule.setId(v.getId());
//                }
                tagLifeCycleRuleDao.saveAndFlush(tagLifeCycleRule);
            }
        return "success";
    }

    public List<Item> findItem(String attributeColumnName){
        TagAttribute tagAttribute=tagAttributeDao.findByAttributeColumnName(attributeColumnName);
        List<TagAttributeValue> tagAttributeValues=new ArrayList<>();
        if (tagAttribute!=null){
            tagAttributeValues=tagAttributeValueDao.findByAttributeId(tagAttribute.getId());
        }
        List<Item> items=new ArrayList<>();
        for (int i = 1;i<tagAttributeValues.size()+1;i++){
            Item item=new Item();
            item.setValue(tagAttributeValues.get(i-1).getId());
            item.setLabel(tagAttributeValues.get(i-1).getAttributeValueName());
            items.add(item);
        }
        return items;
    }

    public LifeCycleSaveVO findLifeCycleEdit(Integer id){
        TagLifeCycle tagLifeCycle=tagLifeCycleDao.findOne(id);
        List<TagLifeCycleRule> tagLifeCycleRules=tagLifeCycleRuleDao.findByLifeCycleId(id);
        LifeCycleSaveVO lifeCycleSaveVO=new LifeCycleSaveVO();
        lifeCycleSaveVO.setCalculationPriority(tagLifeCycle.getCalculationPriority().toString());
        lifeCycleSaveVO.setEnable(tagLifeCycle.getEnable());
        lifeCycleSaveVO.setLifeCycleName(tagLifeCycle.getLifeCycleName());
        lifeCycleSaveVO.setShowPriority(tagLifeCycle.getShowPriority().toString());
        lifeCycleSaveVO.setRunCycle(tagLifeCycle.getRunCycle());
        lifeCycleSaveVO.setDescription(tagLifeCycle.getDescription());
        List<LifeCycleRuleVO> cycleRuleVOs=new ArrayList<>();
        for (TagLifeCycleRule rule:tagLifeCycleRules){
            lifeCycleSaveVO.setAttributeValueId(rule.getAttributeValueId().toString());
            LifeCycleRuleVO lifeCycleRuleVO=new LifeCycleRuleVO();
            TagAttributeValue tagAttributeValue=tagAttributeValueDao.findOne(rule.getAttributeValueId());
            TagAttribute tagAttribute=tagAttributeDao.findOne(tagAttributeValue.getAttributeId());
            lifeCycleRuleVO.setAttributeValue(tagAttributeValue.getAttributeValueName());
            lifeCycleRuleVO.setAttributeId(rule.getAttributeId().toString());
            lifeCycleRuleVO.setAttributeName(tagAttribute.getAttributeColumnName());
            lifeCycleRuleVO.setRelationalSymbol(rule.getRelationalSymbol());
            lifeCycleRuleVO.setRuleOperator(rule.getRuleOperator());
            lifeCycleRuleVO.setId(rule.getId());
            cycleRuleVOs.add(lifeCycleRuleVO);
        }
        lifeCycleSaveVO.setRuleList(cycleRuleVOs);
        return lifeCycleSaveVO;
    }

    public TagLifeCycleVO findTagLifeCycle(Integer id){
        TagLifeCycle tagLifeCycle=tagLifeCycleDao.findOne(id);
        TagLifeCycleVO tagLifeCycleLogVO=new TagLifeCycleVO();
        BeanUtils.copyProperties(tagLifeCycle,tagLifeCycleLogVO);
        if ("1".equals(tagLifeCycleLogVO.getEnable())){
            tagLifeCycleLogVO.setStatus("有效");
        }else {
            tagLifeCycleLogVO.setStatus("无效");
        }
        tagLifeCycleLogVO.setTime(Dates.format(tagLifeCycle.getCreatedAt()));
        return tagLifeCycleLogVO;
    }

    public List<LifeCycleLogVO> getLifeCycleLog(){
        List<TagLifeCycle> strs= tagLifeCycleDao.findAll(new Specification<TagLifeCycle>(){
            @Override
            public Predicate toPredicate(Root<TagLifeCycle> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p=criteriaBuilder.equal(root.get("isDelete").as(String.class), "1");
                criteriaQuery.where(criteriaBuilder.and(p));
                return criteriaQuery.getRestriction();
            }
        });
        List<TagLifeCycleLog> AllList=new ArrayList<>();
        for (TagLifeCycle tag : strs){
            List<TagLifeCycleLog> list=tagLifeCycleLogDao.findByLifeCycleIdTwo(tag.getId());
            AllList.addAll(list);
        }
//    	Sort sort=new Sort(Direction.ASC,"inputDate");
    	/*TagLifeCycleLog tcl=tagLifeCycleLogDao.findAll(sort).get(0);
    	//System.out.println(tcl.getInputDate().getTime());
*/    	
//    	List<TagLifeCycleLog> list=tagLifeCycleLogDao.findAll(sort);
    	List<LifeCycleLogVO> listvo=new ArrayList<LifeCycleLogVO>();
    	LifeCycleLogVO vo;
    	if(AllList!=null){
    		for(TagLifeCycleLog log:AllList){
    			vo=new LifeCycleLogVO();
    			vo.setInput_date(DateUtil.formatDateString(log.getInputDate()));
    			vo.setLife_cycle_id(log.getLifeCycleId());
    			vo.setLife_cycle_name(log.getLifeCycleName());
    			vo.setOut_number(log.getOutNumber());
    			listvo.add(vo);
    		}
    	}
    	return listvo;
    } 
    
    public LifeCycleStatusVO getLifeCycleStatus(){
    	Sort sort=new Sort(Direction.DESC, "inputDate");
    	TagLifeCycleLog tcl=tagLifeCycleLogDao.findAll(sort).get(0);
    	List<TagLifeCycleLog> listlog=tagLifeCycleLogDao.findByInputDate(tcl.getInputDate());
    	List<LifeCycleLogVO> listlogvo=new ArrayList<LifeCycleLogVO>();
    	LifeCycleLogVO logvo;
    	List<TagLifeCycleStatistics> list=tagLifeCycleStatisticsDao.findByInputDate(tcl.getInputDate());
    	List<LifeCycleStatisticsVO> listvo=new ArrayList<LifeCycleStatisticsVO>();
    	LifeCycleStatisticsVO vo;
    	LifeCycleStatusVO status=new LifeCycleStatusVO();
    	if(listlog!=null){
    		for(TagLifeCycleLog log:listlog){
    			logvo=new LifeCycleLogVO();
    			logvo.setInput_date(DateUtil.formatDateString(log.getInputDate()));
    			logvo.setLife_cycle_id(log.getLifeCycleId());
    			logvo.setLife_cycle_name(log.getLifeCycleName());
    			logvo.setOut_number(log.getOutNumber());
    			listlogvo.add(logvo);
    		}
    	}
    	if(list!=null){
    		for(TagLifeCycleStatistics log:list){
    			vo=new LifeCycleStatisticsVO();
    			vo.setLast_life_cycle_id(log.getLastLifeCycleId()+"");
    			vo.setLast_life_cycle_name(log.getLastLifeCycleName());
    			vo.setLife_cycle_id(log.getLifeCycleId()+"");
    			vo.setLife_cycle_name(log.getLifeCycleName());
    			vo.setTrans_count(log.getTransCount());
    			listvo.add(vo);
    		}
    	}
    	status.setLifecylestatus(listlogvo);
    	status.setLifecylerelationship(listvo);
    	
    	return status;
    }
    
    public List<CustomerTagVO> getCustomerTag(String ids[]){
    	List<CustomerTagVO> listvo=new ArrayList<CustomerTagVO>();
    	CustomerTagVO vo;
    	for(String customer_id:ids ){
        	CustomerTag tag=customerTagDao.findByCustomerid(customer_id);
        	if (tag != null) {
        		vo=new CustomerTagVO();
            	vo.setCustomer_id(tag.getCustomerid());
            	vo.setLife_cycle_id(tag.getLife_cycle_id());
            	vo.setLife_cycle_name(tag.getLife_cycle_name());
            	listvo.add(vo);
			}
    	}
    	
    	return listvo;
    }

    public boolean findRepetition(List<String> list){
        String temp = "";
        for (int i = 0; i < list.size() - 1; i++)
        {
            temp = list.get(i);
            for (int j = i + 1; j < list.size(); j++)
            {
                if (temp.equals(list.get(j)))
                {
                   return true;
                }
            }
        }
        return false;
    }


}
