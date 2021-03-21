package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Properties implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;	//名称	不能为空
    private String status;	//状态	不能为空
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private HouseType houseType;	//楼盘类型id	外键，不能为空
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Village village;//小区id	外键，不能为空
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Area area;	//区域id	外键，不能为空
    private Double price;		//价格	不能为空
    private String describe;	//描述	不能为空
    private String deceloper;	//开发商	不能为空
    private String salesAdd;		//售楼处地址	不能为空
    private String propertiesAdd;		//楼盘地址	不能为空
    private String salesPhone;	//售楼处电话	不能为空
    private Timestamp developTime;	//开发时间	不能为空
    private Timestamp beginTime;	//发布时间	不能为空
    private String builtArea;	//建筑面积	不能为空
    private String referenceSum;	//参考总价	不能为空
    private String introduce;	//介绍	不能为空
    @OneToMany(cascade= CascadeType.REMOVE)
    private List<Chapro> chapros;
    private String ImgPath;     //楼盘图片地址

    public Properties(){};

    public Properties(Integer id) {
        this.id = id;
    }

    public Properties(Integer id, String name, String describe){
        this.id = id;
        this.name = name;
        this.describe = describe;
    }
}
