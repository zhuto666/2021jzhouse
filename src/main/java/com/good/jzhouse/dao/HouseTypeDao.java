package com.good.jzhouse.dao;

import com.good.jzhouse.bean.HouseType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface HouseTypeDao {

    @Select("select * from HouseType where type = 1")
    List<HouseType> findAllIndex();

    @Select("select * from HouseType")
    List<HouseType> findAll();

    @Select("select * from HouseType where type=#{type}")
    List<HouseType> findAllByType(Integer type);

    @Select("select * from houseType where id=#{id}")
    HouseType selectById(Integer id);

    @Delete("delete from houseType where id=#{id}")
    int delete(Integer id);

    @Insert("insert into houseType values(null,#{name},#{type})")
    int insert(HouseType houseType);

    @Update("update houseType set name=#{name},type=#{type} where id=#{id}")
    int update(HouseType houseType);

    @Select("select count(1) from houseType")
    int selectCount();

}
