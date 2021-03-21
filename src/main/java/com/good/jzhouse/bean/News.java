package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String context;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Users user;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Properties propertie;
    private Timestamp beginTime;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private NewsType newsType;

}
