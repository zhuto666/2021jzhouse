package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Chapro;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ChaproDao {

    @Select("SELECT * FROM chapro")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="propertiesId",property="propertie",one=@One(select="com.good.jzhouse.dao.PropertiesDao.selectById")),
            @Result(column="characteristicId",property="characteristic",one=@One(select="com.good.jzhouse.dao.CharacteristicDao.selectById"))
    })
    List<Chapro> findAll();

    @Select("SELECT * FROM chapro where propertiesId=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="propertiesId",property="propertiesId"),
            @Result(column="characteristicId",property="characteristic",one=@One(select="com.good.jzhouse.dao.CharacteristicDao.selectById"))
    })
    List<Chapro> findAllByC(Integer id);

    @Delete("delete from chapro where id = #{id} ")
    Integer deleteById();


}
