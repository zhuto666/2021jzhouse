package com.good.jzhouse.controller;

import com.good.jzhouse.bean.BuyHouse;
import com.good.jzhouse.bean.Label;
import com.good.jzhouse.dao.BuyHouseDao;
import com.good.jzhouse.dao.LabelDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/lab")
public class LabelController {

    @Resource
    private LabelDao labelDao;

    @Resource
    private BuyHouseDao buyHouseDao;

    @RequestMapping("/findAll")
    public List<Label> findAll(){

        return labelDao.findAll();
    }

    @RequestMapping("/a")
    public List<BuyHouse> a(){
        return buyHouseDao.findAll();
    }

}
