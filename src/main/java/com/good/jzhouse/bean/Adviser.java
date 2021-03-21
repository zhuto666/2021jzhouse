package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Adviser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                    // 编号
    private Integer ranking;         	   // 名次
    private String consultantName;         // 顾问名
    private String consultanPortrait;      // 顾问头像
    @OneToOne(cascade= CascadeType.REMOVE,optional=true)
    private Properties properties;         // 楼盘id
    private String grade;                  // 等级
    private Integer likes;                 // 点赞数
    private Integer views;                 // 浏览量
    private Integer activity;              // 活跃度

    public Adviser() {
    }


}
