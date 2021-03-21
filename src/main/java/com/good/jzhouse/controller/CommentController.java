package com.good.jzhouse.controller;

import com.alibaba.fastjson.JSON;
import com.good.jzhouse.bean.Comment;
import com.good.jzhouse.bean.News;
import com.good.jzhouse.bean.Properties;
import com.good.jzhouse.bean.Users;
import com.good.jzhouse.dao.CommentDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/comm")
public class CommentController {
    @Resource
    CommentDao commentDao;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        return "properties/commAll";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Boolean insert(String context,Integer pid,Integer fid){
        Comment c = new Comment(null,context,new Users(1),new Properties(pid),new News(),fid,null,0);
        return commentDao.insert(c)>0;
    }
    @RequestMapping("/selectByNew")
    @ResponseBody
    public String selectByNew(){
        return JSON.toJSONStringWithDateFormat(commentDao.selectByNew(),"yyyy-MM-dd HH:mm:ss");
    }
    @RequestMapping("/selectById")
    @ResponseBody
    public Boolean selectById(Integer id){
        return true;
    }
}
