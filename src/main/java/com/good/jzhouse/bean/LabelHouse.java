package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class LabelHouse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private House house;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Label label;

}
