package com.good.jzhouse.controller;

import com.good.jzhouse.dao.HouseDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/xinxi")
public class XinxiController {

    @Resource
    private HouseDao houseDao;

    @RequestMapping("/er")
    public String tu (Model model,Integer id,Integer type){
        model.addAttribute("h",houseDao.selectByXinId(id,type));
        model.addAttribute("type",type);
        return "xinxi";
    }
}
