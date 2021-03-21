package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Area;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AreaDao {

    @Select("select * from Area limit 5")
    List<Area> findAllIndex();

    @Select("select * from Area")
    List<Area> findAll();

    @Select("select * from Area where pid=#{pid}")
    List<Area> findAllByPid(Integer pid);

    @Update("UPDATE AREA SET NAME=#{name},pid=#{pid} where #{id}")
    Integer update(Area a);

    @Select("select * from area where id=#{id}")
    Area selectById(Integer id);

    @Delete("delete  from area where id=#{id}")
    Integer delById(Integer id);

    @Insert("insert into AREA values(null,#{name},#{pid})")
    Integer insert(Area a);


}
