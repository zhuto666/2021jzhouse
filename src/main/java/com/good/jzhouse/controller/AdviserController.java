package com.good.jzhouse.controller;

import com.good.jzhouse.bean.Adviser;
import com.good.jzhouse.dao.AdviserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Adviser")
public class AdviserController {

    @Resource
    AdviserDao adviserDao;

    @RequestMapping("/guwen")
    String Adviser (){
        return "guwen";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String, Object> findAll(Integer limit,Integer page,String consultantName){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",adviserDao.count(consultantName));
        map.put("data",adviserDao.findAll(consultantName,(page-1)*limit,limit));
        return map;
    }

    @RequestMapping("/find5")
    @ResponseBody
    public List<Adviser> find5(){
        return adviserDao.find5();
    }
}
