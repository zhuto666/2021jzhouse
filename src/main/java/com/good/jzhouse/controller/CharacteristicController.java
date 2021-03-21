package com.good.jzhouse.controller;

import com.good.jzhouse.bean.Characteristic;
import com.good.jzhouse.dao.CharacteristicDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/characteristic")
public class CharacteristicController {
    @Resource
    CharacteristicDao characteristicDao;

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Characteristic> selectAll(){
       // return JSONArray.parseArray(JSON.toJSONString(characteristicDao.findAll(), SerializerFeature.DisableCircularReferenceDetect));
        //return JSON.toJSON(characteristicDao.findAll());
        return characteristicDao.findAll();
       //return JSON.toJSONString(characteristicDao.findAll(),SerializerFeature.DisableCircularReferenceDetect);
    }
}
