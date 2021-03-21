package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Sellhouse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private House house;
    private Integer type;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Properties propertie;
    private Boolean online;
    private Date beginTime;
    private Integer effectiveTime;

}
