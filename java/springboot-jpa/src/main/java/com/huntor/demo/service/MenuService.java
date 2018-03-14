package com.huntor.demo.service;

//import com.huntor.demo.dao.AttrClassifyDao;

import com.huntor.demo.dao.AttrClassifyDao;
import com.huntor.demo.entity.AttrClassify;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyang on 2017/7/28.
 */
@Service
public class MenuService {

    @Resource
    private AttrClassifyDao attrClassifyDao;

    public List<Map<String,Object>> findAll(){
        List<AttrClassify> attrClassifyList=attrClassifyDao.findAll();
        List<AttrClassify> list1=new ArrayList<AttrClassify>();
        List<AttrClassify> list2=new ArrayList<AttrClassify>();
        List<AttrClassify> list3=new ArrayList<AttrClassify>();
        for (AttrClassify attr : attrClassifyList){
            if (attr.getAttributeLevels()==1){
                list1.add(attr);
            }else if (attr.getAttributeLevels()==2){
                list2.add(attr);
            }else if (attr.getAttributeLevels()==3){
                list3.add(attr);
            }
        }
        List<Map<String,Object>> mapList=new ArrayList<>();
        //第一级
        for (AttrClassify attr1 : list1){
            List<Map<String,Object>> mapList2=new ArrayList<>();
            List<Map<String,Object>> mapList3;
            Map<String,Object> attr1Map=new HashMap<>();
            attr1Map.put("label",attr1.getAttributeName());
            //第二级
            for (AttrClassify attr2: list2){
                mapList3=new ArrayList<>();
                if (attr1.getId()==attr2.getParentId()){
                    Map<String,Object> attr2Map=new HashMap<>();
                    attr2Map.put("label",attr2.getAttributeName());
                    //第三级
                    for (AttrClassify attr3 : list3){
                        if (attr2.getId()==attr3.getParentId()){
                            Map<String,Object> attr3Map=new HashMap<>();
                            attr3Map.put("label",attr3.getAttributeName());
                            attr3Map.put("menuId",attr3.getId());
                            mapList3.add(attr3Map);
                        }
                    }
                    if (mapList3.size()>0){
                        attr2Map.put("children",mapList3);
                    }else {
                        attr2Map.put("menuId",attr2.getId());
                    }
                    mapList2.add(attr2Map);
                }
            }
            attr1Map.put("children",mapList2);
            mapList.add(attr1Map);
        }
        return mapList;
    }

}
