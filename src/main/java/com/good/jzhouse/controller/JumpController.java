package com.good.jzhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jump")
public class JumpController {

    @RequestMapping("/newhouse")
    public String newhouse(){
        return "newhouse";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/dataimg")
    public String dataimg(){
        return "fangjia";
    }



    @RequestMapping("/news")
    public String news(){
        return "news";
    }
    @RequestMapping("/news10")
    public String news10(){
        return "news10";
    }

    @RequestMapping("/news1")
    public String news1(){
        return "/newsList/news1";
    }

    @RequestMapping("/news2")
    public String news2(){
        return "/newsList/news2";
    }

    @RequestMapping("/news3")
    public String news3(){
        return "/newsList/news3";
    }

    @RequestMapping("/news4")
    public String news4(){
        return "/newsList/news4";
    }

    @RequestMapping("/news5")
    public String news5(){
        return "/newsList/news5";
    }

    @RequestMapping("/news6")
    public String news6(){
        return "/newsList/news6";
    }
}
