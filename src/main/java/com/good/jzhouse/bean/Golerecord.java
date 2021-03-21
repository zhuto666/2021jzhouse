package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
public class Golerecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    private String numberChange;
    private String goldRemark;
    private Timestamp updateTime;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Users user;

}
