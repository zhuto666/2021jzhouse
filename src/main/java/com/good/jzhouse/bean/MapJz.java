package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class MapJz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Properties propertie;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private House house;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Village village;
    private Double lng;
    private Double lat;

}
