package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Village;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface VillageDao {

    @Select("select * from Village")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="propertyType",property="propertyType"),
            @Result(column="eng",property="eng"),
            @Result(column="investors",property="investors"),
            @Result(column="surrounding",property="surrounding"),
            @Result(column="marketing",property="marketing"),
            @Result(column="plotRatio",property="plotRatio"),
            @Result(column="greening",property="greening"),
            @Result(column="builtArea",property="builtArea"),
            @Result(column="landArea",property="landArea"),
            @Result(column="parking",property="parking"),
            @Result(column="totalPeople",property="totalPeople"),
            @Result(column="propertyCpy",property="propertyCpy"),
            @Result(column="propertyFee",property="propertyFee"),
            @Result(column="renovationId",property="renovation",one=@One(select="com.good.jzhouse.dao.RenovationDao.selectById")),
            @Result(column="areaId",property="area",one=@One(select="com.good.jzhouse.dao.AreaDao.selectById"))
    })
    List<Village> findAll();

    @Select("select * from Village where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="propertyType",property="propertyType"),
            @Result(column="eng",property="eng"),
            @Result(column="investors",property="investors"),
            @Result(column="surrounding",property="surrounding"),
            @Result(column="marketing",property="marketing"),
            @Result(column="plotRatio",property="plotRatio"),
            @Result(column="greening",property="greening"),
            @Result(column="builtArea",property="builtArea"),
            @Result(column="landArea",property="landArea"),
            @Result(column="parking",property="parking"),
            @Result(column="totalPeople",property="totalPeople"),
            @Result(column="propertyCpy",property="propertyCpy"),
            @Result(column="propertyFee",property="propertyFee"),
            @Result(column="renovationId",property="renovation",one=@One(select="com.good.jzhouse.dao.RenovationDao.selectById")),
            @Result(column="areaId",property="area",one=@One(select="com.good.jzhouse.dao.AreaDao.selectById"))
    })
    Village selectById(Integer id);

    @Insert("insert into Village values(#{id},#{name},#{propertyType},#{eng},#{renovation.id},#{investors},#{surrounding},#{marketing},#{plotRatio},#{greening},#{builtArea},#{landArea}," +
            "#{parking},#{totalPeople},#{propertyCpy},#{propertyFee},#{area.id})")
    int insert(Village v);

    @Update("update Village set name=#{name},propertyType=#{propertyType},eng=#{eng},renovationId=#{renovationId},investors=#{investors},surrounding=#{surrounding},marketing=#{marketing},plotRatio=#{plotRatio},greening=#{greening},builtArea=#{builtArea},landArea=#{landArea}," +
            "parking=#{parking},totalPeople=#{totalPeople},propertyCpy#{propertyCpy},propertyFee=#{propertyFee},areaId=#{area.id} WHERE id=#{id})")
    int update(Village v);

    @Delete("delete from Village where id=#{id}")
    int del(int id);

    @Select("select count(*) from Village")
    int count();
}
