package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Characteristic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CharacteristicDao {

    @Select("select * from characteristic")
    List<Characteristic> findAll();

    @Select("select * from characteristic where id=#{id}")
    Characteristic selectById(Integer id);

    @Delete("delete from characteristic where id = #{id}")
    Integer deleteById(Integer id);


}
