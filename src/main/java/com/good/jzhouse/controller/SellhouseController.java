package com.good.jzhouse.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.good.jzhouse.dao.HouseDao;
import com.good.jzhouse.dao.SellhouseDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sellhouse")
public class SellhouseController {
    @Resource
    SellhouseDao sellhouseDao;

    @Resource
    HouseDao houseDao;

    /*下面这个是首页房信息的查找*/
    @ResponseBody
    @RequestMapping("/selectAllIndex")
    public String selectAllIndex(int sid){
        return JSON.toJSONString(sellhouseDao.findAllIndex(sid),SerializerFeature.DisableCircularReferenceDetect);
    }


}
