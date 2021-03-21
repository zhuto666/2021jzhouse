package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Chapro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Properties propertie;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Characteristic characteristic;
    private Integer propertiesId;

}
