package com.good.jzhouse.dao;

import com.good.jzhouse.bean.MapJz;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MapJzDao {

    @Select("<script> SELECT * FROM map WHERE propertieId in <foreach collection='list' index='index' item='item' open='(' separator=',' close=')'> #{item} </foreach></script>")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="lng",property="lng"),
            @Result(column="lat",property="lat"),
            @Result(column="propertieId",property="propertie",one=@One(select="com.good.jzhouse.dao.PropertiesDao.selectByIdMap"))
    })
    public List<MapJz> findByProId(@Param("list") List<Integer> pid);

    @Select("<script> SELECT * FROM map WHERE houseId in <foreach collection='list' index='index' item='item' open='(' separator=',' close=')'> #{item} </foreach></script>")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="lng",property="lng"),
            @Result(column="lat",property="lat"),
            @Result(column="houseId",property="house",one=@One(select="com.good.jzhouse.dao.HouseDao.selectById")),
    })
    public List<MapJz> findByHouseId(@Param("list") List<Integer> pid);

    @Select("SELECT * FROM map WHERE propertieId=#{pid};")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="lng",property="lng"),
            @Result(column="lat",property="lat"),
    })
    public MapJz selectByPid(Integer pid);
}
