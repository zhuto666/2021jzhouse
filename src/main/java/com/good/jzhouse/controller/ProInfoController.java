package com.good.jzhouse.controller;

import com.good.jzhouse.bean.Comment;
import com.good.jzhouse.bean.Properties;
import com.good.jzhouse.dao.CommentDao;
import com.good.jzhouse.dao.HouseDao;
import com.good.jzhouse.dao.MapJzDao;
import com.good.jzhouse.dao.PropertiesDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/proinfo")
public class ProInfoController {

    @Resource
    private PropertiesDao propertiesDao;
    @Resource
    private HouseDao houseDao;
    @Resource
    private CommentDao commentDao;
    @Resource
    private MapJzDao mapJzDao;

    @RequestMapping("/pro1")
    public String pro1(Model model, HttpSession s, Integer id){
        Properties p = (Properties) s.getAttribute("p");
        if(p==null || id!=null){
            s.setAttribute("p",propertiesDao.selectById(id));
        }else{
            id=p.getId();
        }
        model.addAttribute("houselist",houseDao.findAllNewHouse(id));
        model.addAttribute("commentlist",commentDao.findAllPro1(0,3,id));
        model.addAttribute("countPage",commentDao.countPage(id));
        return "properties/pro1";
    }

    @RequestMapping("/hd")
    public String hd(Model model,HttpSession s){
        Properties p = (Properties) s.getAttribute("p");
        model.addAttribute("prozblist",propertiesDao.findAllNotId(p.getId()));
        model.addAttribute("mapAddress",mapJzDao.selectByPid(p.getId()));
        return "properties/Housing_details";
    }

    @RequestMapping("/fo")
    public String fo(Model model, HttpSession s){
        Properties p = (Properties) s.getAttribute("p");
        model.addAttribute("houselist",houseDao.findAllNewHouse(p.getId()));
        return "properties/Family_of";
    }


    @RequestMapping("/ppa")
    public String ppa(){
        return "properties/properties_photo_album";
    }

    @RequestMapping("/comm")
    public String findAll(HttpSession s,Model model,Integer index,Integer size,Integer type){
        Properties p = (Properties) s.getAttribute("p");
        index=index==null?1:index;
        size=size==null?6:size;
        type=type==null?1:type;
        if (type==1){
            model.addAttribute("commentlist",commentDao.findAllPro1((index-1)*size,size,p.getId()));
        }else{
            model.addAttribute("commentlist",commentDao.findAllPro2((index-1)*size,size,p.getId()));
        }
        model.addAttribute("index",index);
        model.addAttribute("type",type);
        model.addAttribute("countPage",commentDao.countPage(p.getId()));
        model.addAttribute("prozblist",propertiesDao.findAllNotId(p.getId()));
        return "properties/commAll";
    }

    @RequestMapping("/proAll")
    @ResponseBody
    public List<Properties> proAll(Integer id){
        return propertiesDao.findAllNotId(id);
    }


    @RequestMapping("/b")
    @ResponseBody
    public List<Comment> b(Integer id){
        return commentDao.selectByFid(id);
    }



}
