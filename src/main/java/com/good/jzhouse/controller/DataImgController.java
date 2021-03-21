package com.good.jzhouse.controller;

import com.alibaba.fastjson.JSON;
import com.good.jzhouse.bean.DataImg;
import com.good.jzhouse.dao.DataImgDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dataimg")
public class DataImgController {



    @Resource
    DataImgDao dataImgDao;


    @RequestMapping("/cha")
    @ResponseBody
    public String cha(){
        Map<String,List<Object>> map = new HashMap<>();
        List<Object> list1 =new ArrayList<>();
        List<Object> list2 =new ArrayList<>();
        List<Object> list3 =new ArrayList<>();
        for(DataImg i:dataImgDao.selectByType("荆州新房在售均价走势")){
            list1.add(i.getPrice());
            list2.add(i.getType());
            list3.add(i.getTitle());
        }
        map.put("a1",list1);
        map.put("a2",list2);
        map.put("a3",list3);


        List<Object> list4 =new ArrayList<>();
        List<Object> list5 =new ArrayList<>();
        List<Object> list6 =new ArrayList<>();
        for(DataImg i:dataImgDao.selectByType("荆州商品房网签成交数量统计")){
            list4.add(i.getPrice());
            list5.add(i.getType());
            list6.add(i.getTitle());
        }
        map.put("b1",list4);
        map.put("b2",list5);
        map.put("b3",list6);



        List<Object> list7 =new ArrayList<>();
        List<Object> list8 =new ArrayList<>();
        List<Object> list9 =new ArrayList<>();
        for(DataImg i:dataImgDao.selectByType("荆州商品房预售许可数量数据统计")){
            list7.add(i.getPrice());
            list8.add(i.getType());
            list9.add(i.getTitle());
        }
        map.put("c1",list7);
        map.put("c2",list8);
        map.put("c3",list9);


        List<Object> list10 =new ArrayList<>();
        List<Object> list11 =new ArrayList<>();
        List<Object> list12 =new ArrayList<>();
        for(DataImg i:dataImgDao.selectByType("荆州商品房预售许可总面积统计")){
            list10.add(i.getPrice());
            list11.add(i.getType());
            list12.add(i.getTitle());
        }
        map.put("d1",list10);
        map.put("d2",list11);
        map.put("d3",list12);

        return JSON.toJSONString(map) ;
    }
}
