package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Label;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LabelDao {

    @Select("select * from Label")
    List<Label> findAll();

    @Select("select * from Label where id=#{id}")
    Label selectById(Integer id);

    @Delete("delete from Label where id=#{id}")
    int delete(Integer id);

    @Insert("insert into Label values(null,#{name},#{type}")
    int insert(Label label);

    @Update("update Label set name=#{name},type=#{type} where id=#{id}")
    int update(Label label);

    @Select("select count(1) from Label")
    int selectCount();
}
