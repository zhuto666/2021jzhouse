package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Users user;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Properties properties;
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private News news;
    private Integer fid;
    private Timestamp beginTime;
    private Integer good;
    @OneToMany(cascade= CascadeType.REMOVE)
    private List<Comment> clist;

    public Comment() {
    }

    public Comment(Integer id, String content, Users user, Properties properties, News news, Integer fid, Timestamp beginTime, Integer good) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.properties = properties;
        this.news = news;
        this.fid = fid;
        this.beginTime = beginTime;
        this.good = good;
    }
}
