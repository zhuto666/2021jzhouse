package com.good.jzhouse.controller;

import com.alibaba.fastjson.JSON;
import com.good.jzhouse.dao.HouseTypeDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/housetype")
public class HouseTypeController {
    @Resource
    HouseTypeDao houseTypeDao;

    @ResponseBody
    @RequestMapping("/selectAllIndex")
    public String selectAllIndex(){
        return JSON.toJSONString(houseTypeDao.findAllIndex());
    }
}
