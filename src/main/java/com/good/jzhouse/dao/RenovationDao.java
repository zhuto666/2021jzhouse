package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Renovation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RenovationDao {

    @Select("select * from Renovation")
    List<Renovation> findAll();

    @Select("select * from Renovation where id=#{id}")
    Renovation selectById(@Param("id") Integer id);

    @Select("update Renovation set name=#{name} where id=#{id}")
    int update(Renovation renovation);

    @Select("insert into Renovation values(#{id},#{name})")
    int insert(Renovation renovation);

    @Select("delete from Renovation where id=#{id}")
    int del(@Param("id") Integer id);

    @Select("select count(*) from Renovation ")
    int count();
}
