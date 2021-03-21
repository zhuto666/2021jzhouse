package com.good.jzhouse.controller;

import com.good.jzhouse.bean.Properties;
import com.good.jzhouse.dao.PropertiesDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/properties")
public class PropertiesController {

    @Resource
    PropertiesDao propertiesDao;



   /* 首页加条件查询的*/
   @ResponseBody
   @RequestMapping("/findAllIndexTJ")
   public List<Properties> findAllIndexTJ(int tj){
       System.out.println("tj:" + tj);
       return propertiesDao.findAllIndexTJ(tj);
       //return JSON.toJSONString(propertiesDao.findAllIndex());
   }
}
