package com.good.jzhouse.controller;

import com.alibaba.fastjson.JSON;
import com.good.jzhouse.dao.PresellDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Presell")
public class PresellController {
    @Resource
    private PresellDao presellDao;

    //跳转到yuyue界面
    @RequestMapping("/yuyue")
    String tu (){
        return "yuyue";
    }

    @RequestMapping("/PresellSelect")
    @ResponseBody
    public String findAll(String license,String project,String company, Integer limit, Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",presellDao.count(license,project,company));
        map.put("data",presellDao.PresellSelect(license,project,company,(page-1)*limit,limit));
        return JSON.toJSONStringWithDateFormat(map,"MM-dd");
    }
}
