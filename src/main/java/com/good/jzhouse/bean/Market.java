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
public class Market implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date time;
    private String areas;
    private String plot;
    private String location;
    private Integer price;
    private String unit;
    private Double acreage;

}
