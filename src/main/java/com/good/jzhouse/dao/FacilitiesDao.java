package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Facilities;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FacilitiesDao {

    @Select("select * from Facilities")
    List<Facilities> findAll();

    @Select("select * from Facilities where id=#{id}")
    Facilities selectById(Integer id);

    @Delete("delete from Facilities where id=#{id}")
    int delete(Integer id);

    @Insert("insert into Facilities values(null,#{name})")
    Integer insert(Facilities facilities);

    @Update("upate Facilities set name=#{name} where id=#{id} ")
    int update(Facilities facilities);

    @Select("select count(1) from Facilities")
    int selectCount();
}
