package com.good.jzhouse.controller;

import com.alibaba.fastjson.JSON;
import com.good.jzhouse.dao.MarketDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Market")
public class MarketController {

    @Resource
    private MarketDao marketDao;

    //跳转到tudi界面
    @RequestMapping("/tudi")
    String tu (){
        return "tudi";
    }

    @RequestMapping("/blurredSelect")
    @ResponseBody
   public String findAll(String unit ,String location,String plot,Integer limit,Integer page){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",marketDao.count(plot,location,unit));
        map.put("data",marketDao.blurredSelect(plot,location,unit,(page-1)*limit,limit));
        return JSON.toJSONStringWithDateFormat(map,"MM-dd");
    }


    }
