package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class BuyHouse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private HouseType houseType;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Area area;
    private Double price;
    private String title;
    private String describe;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Users user;
    private Date beginTime;
    private String status;
    private Integer type;

}
