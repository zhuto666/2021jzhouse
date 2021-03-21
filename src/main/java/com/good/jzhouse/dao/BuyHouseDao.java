package com.good.jzhouse.dao;

import com.good.jzhouse.bean.BuyHouse;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BuyHouseDao {

    @Select("select * from BuyHouse")
    @Results({
        @Result(id=true,column="id",property="id"),
        @Result(column="price",property="price"),
        @Result(column="title",property="title"),
        @Result(column="describe",property="describe"),
        @Result(column="beginTime",property="beginTime"),
        @Result(column="type",property="type"),
        @Result(column="houseTypeId",property="houseType",one=@One(select="com.good.jzhouse.dao.HouseTypeDao.selectById")),
        @Result(column="areaId",property="area",one=@One(select="com.good.jzhouse.dao.AreaDao.selectById")),
        @Result(column="userId",property="user",one=@One(select="com.good.jzhouse.dao.UsersDao.selectById"))
    })
    List<BuyHouse> findAll();

    @Update("UPDATE BuyHouse SET  houseTypeId = #{houseType.id} , areaId = #{area.id} , price = #{price} , title = #{title} , " +
            "describe = #{describe} , userId = #{user.uid} , beginTime = #{beginTime} , status = #{status} , type =#{type} ")
    Integer update(BuyHouse buyHouse);

    @Select("select * from BuyHouse WHERE id = #{id}")
        @Results({
                @Result(id=true,column="id",property="id"),
                @Result(column="price",property="price"),
                @Result(column="title",property="title"),
                @Result(column="describe",property="describe"),
                @Result(column="beginTime",property="beginTime"),
                @Result(column="type",property="type"),
                @Result(column="houseTypeId",property="houseType",one=@One(select="com.good.jzhouse.dao.HouseTypeDao.selectById")),
                @Result(column="areaId",property="area",one=@One(select="com.good.jzhouse.dao.AreaDao.selectById")),
                @Result(column="userId",property="user",one=@One(select="com.good.jzhouse.dao.UsersDao.selectById"))
    })
    BuyHouse selectById(Integer id);

    @Delete("delete  from BuyHouse where id=#{id}")
    Integer delById(Integer id);

    @Insert("insert into BuyHouse values(null,#{houseType.id},#{area.id}), #{price}, #{title} ,#{describe} , #{user.uid} , #{beginTime} , #{status} , #{type}")
    Integer insert(BuyHouse buyHouse);
}
