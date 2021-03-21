package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Presell implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date time; //时间	不能为空
    private String areas;	//区域	不能为空
    private String license;	//许可证号	不能为空
    private String project;	//项目名称	不能为空
    private String company;	//公司名称	不能为空
    private double totalArea;	//总面积	不能为空

}
