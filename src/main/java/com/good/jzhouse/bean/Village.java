package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Village implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String propertyType;
    private String eng;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Renovation renovation;
    private String investors;
    private String surrounding;
    private String marketing;
    private Double plotRatio;
    private Double greening;
    private Double builtArea;
    private Double landArea;
    private String parking;
    private String totalPeople;
    private String propertyCpy;
    private Double propertyFee;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Area area;

}
