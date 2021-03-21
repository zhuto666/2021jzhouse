package com.good.jzhouse.controller;

import com.alibaba.fastjson.JSON;
import com.good.jzhouse.dao.AreaDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/Area")
public class AreaController {
    @Resource
    AreaDao areaDao;


    @RequestMapping("/selectAllIndex")
    @ResponseBody
    public String selectAllIndex(){
        return JSON.toJSONString(areaDao.findAllIndex());
    }
}
