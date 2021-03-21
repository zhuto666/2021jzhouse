package com.good.jzhouse.controller;

import com.good.jzhouse.bean.*;
import com.good.jzhouse.dao.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/selhouse")
public class NewHouseController {

    @Resource
    private AreaDao areaDao;
    @Resource
    private CharacteristicDao characteristicDao;
    @Resource
    private HouseTypeDao houseTypeDao;
    @Resource
    private PropertiesDao propertiesDao;
    @Resource
    private ChaproDao chaproDao;
    @Resource
    private SellhouseDao sellhouseDao;
    @Resource
    private MapJzDao mapJzDao;
    @Resource
    private RenovationDao renovationDao;


    @RequestMapping("/newhouse")
    public String newhouse(Model m, HttpSession session,String name2){
        name2= name2==null?"":name2;
        List<Properties> plist = propertiesDao.findAllPage(name2,0,6,-1,-1,-1,-1,null,-1,-1,0);
        session.setAttribute("mapPid",getMapPid(plist));
        m.addAttribute("arealist",areaDao.findAllByPid(0));
        m.addAttribute("name",name2);
        m.addAttribute("characteristiclist",characteristicDao.findAll());
        m.addAttribute("housetypelist",houseTypeDao.findAllByType(1));
        m.addAttribute("propertieslist",plist);
        m.addAttribute("countPage",propertiesDao.count2(name2));
        m.addAttribute("chaprolist",chaproDao.findAll());
        return "newhouse";
    }

    @RequestMapping("/newhouse2")
    public String newhouse2(Model m, HttpSession session,Integer type,String name2){
        List<Sellhouse> plist = sellhouseDao.findAllPageHouse(type,name2,0,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,0);
        session.setAttribute("mapPid2",getMapPid2(plist));
        m.addAttribute("name",name2);
        m.addAttribute("arealist",areaDao.findAllByPid(0));
        m.addAttribute("renovationList",renovationDao.findAll());
        m.addAttribute("housetypelist",houseTypeDao.findAllByType(2));
        m.addAttribute("selllist",plist);
        m.addAttribute("countPage",sellhouseDao.countByType(type,name2));
        m.addAttribute("chaprolist",chaproDao.findAll());
        if(type==2){
            return "oldhouse";
        }else{
            return "zoldhouse";
        }
    }

    @RequestMapping("/pages")
    @ResponseBody
    public Pages findAllPages(HttpSession session,String name, Integer index, Integer size,
                                 Integer areaId,Integer areaIdz,Integer priceMin,Integer priceMax,String stutas, Integer characteristicId, Integer houseTypeId,Integer paixu){
        name = "".equals(name)?null:name;
        List<Properties> plist = propertiesDao.findAllPage(name,(index-1)*size,size,areaId,areaIdz,priceMin,priceMax,stutas.equals("")?null:stutas,characteristicId,houseTypeId,paixu);
        session.setAttribute("mapPid",getMapPid(plist));
        Pages<Properties> page = new Pages(index,size,
                propertiesDao.countPage(name,areaId,areaIdz,priceMin,priceMax,stutas.equals("")?null:stutas,characteristicId,houseTypeId),
                plist);
        return page;
    }

    @RequestMapping("/oldpages")
    @ResponseBody
    public Pages findAllOldPages(HttpSession session,Integer type,String name, Integer index, Integer size,
                              Integer areaId,Integer areaIdz,Integer priceMin,Integer priceMax,
                              Integer mjMin,Integer mjMax,
                              Integer hx, Integer renovationId, Integer houseTypeId,Integer paixu){
        name = "".equals(name)?null:name;
        List<Sellhouse> plist = sellhouseDao.findAllPageHouse(type,name,(index-1)*size,size,areaId,areaIdz,priceMin,priceMax,
                mjMin,mjMax,hx,renovationId,houseTypeId,paixu);
        session.setAttribute("mapPid2",getMapPid2(plist));
        Pages<Properties> page = new Pages(index,size,
                sellhouseDao.countPage(type,name,areaId,areaIdz,priceMin,priceMax,
                        mjMin,mjMax,hx,renovationId,houseTypeId),
                plist);
        return page;
    }

    @RequestMapping("/findAllByPid")
    @ResponseBody
    public List<Area> findAllByPid(Integer id){
        return areaDao.findAllByPid(id);
    }

    @RequestMapping("/getMap")
    @ResponseBody
    public List<MapJz> getMap(HttpSession session){
        return mapJzDao.findByProId((List<Integer>) session.getAttribute("mapPid"));
    }
    @RequestMapping("/getMap2")
    @ResponseBody
    public List<MapJz> getMap2(HttpSession session){
        return mapJzDao.findByHouseId((List<Integer>) session.getAttribute("mapPid2"));
    }

    private List<Integer> getMapPid(List<Properties> plist){
        List<Integer> mapPid = new ArrayList<>();
        for (Properties p : plist){
            mapPid.add(p.getId());
        }
        return mapPid;
    }

    private List<Integer> getMapPid2(List<Sellhouse> plist){
        List<Integer> mapPid = new ArrayList<>();
        for (Sellhouse s : plist){
            mapPid.add(s.getHouse().getId());
        }
        return mapPid;
    }
}
