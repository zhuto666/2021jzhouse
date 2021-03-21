package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Golerecord;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GolerecordDao {

    @Select("select * from Golerecord")
    @Results({
            @Result(id = true,column = "gid",property = "gid"),
            @Result(column = "numberChange",property = "numberChange"),
            @Result(column = "goldRemark",property = "goldRemark"),
            @Result(column = "updateTime",property = "updateTime"),
            @Result(column = "userId",property = "user",one = @One(select = "com.good.jzhouse.dao.UsersDao.selectById"))
    })
    List<Golerecord> findAll();

    @Select("select * from Golerecord where gid=#{gid}")
    @Results({
            @Result(id = true,column = "gid",property = "gid"),
            @Result(column = "numberChange",property = "numberChange"),
            @Result(column = "goldRemark",property = "goldRemark"),
            @Result(column = "updateTime",property = "updateTime"),
            @Result(column = "userId",property = "user",one = @One(select = "com.good.jzhouse.dao.UsersDao.selectById"))
    })
    Golerecord selectById(Integer gid);

    @Delete("delete from Golerecord where gid=#{gid}")
    int delete(Integer gid);

    @Insert("insert into Golerecord values(null,#{numberChange},#{goldRemark},#{updateTime},#{user.uid})")
    Integer insert(Golerecord golerecord);

    @Update("upate Golerecord set numberChange=#{numberChange},goldRemark=#{goldRemark},updateTime=#{updateTime} where userId=#{user.uid} ")
    int update(Golerecord golerecord);

    @Select("select count(1) from Golerecord")
    int selectCount();
}


