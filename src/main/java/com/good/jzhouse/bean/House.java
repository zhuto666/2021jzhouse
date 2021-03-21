package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class House implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String describe;
    private Integer room;
    private Integer hall;
    private Integer defend;
    private Double houseSize;
    private Double price;
    private Integer storeyUser;
    private Integer storeySum;
    private String roomFacilities;
    private Timestamp beginTime;
    private String indoorImg;
    private String houseTypeImg;
    private String outdoorImg;
    private String video;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Users user;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private HouseType houseType;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Village village;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Area area;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Renovation renovation;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Facilities facilitie;
    private String orientation;
    @ManyToMany
    private List<LabelHouse> list;

}
