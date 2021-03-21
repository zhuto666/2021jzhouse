package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Root implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Role role;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Menu menu;

}
