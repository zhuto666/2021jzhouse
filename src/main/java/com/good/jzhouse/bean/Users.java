package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String userId;
    private String linkman;
    private String communityName;
    private Boolean sex;
    private String password;
    private String phone;
    private String picture;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Role role;
    private Integer gold;
    private Integer integral;
    private Integer balance;
    private Timestamp createDate;
    private Timestamp lastLoginTime;

    public Users(Integer uid) {
        this.uid = uid;
    }

    public Users() {
    }
}
