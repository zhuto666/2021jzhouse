package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Comment;
import com.good.jzhouse.bean.DataImg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DataImgDao {

    @Select("select * from DataImg")
    List<DataImg> findAll();


    @Select("select * from DataImg where id=#{id}")
    DataImg selectById(Integer id);

    @Select("select * from DataImg where type=#{type}")
    List<DataImg> selectByType(String type);

    @Delete("delete from DataImg where id=#{id}")
    int delete(Integer id);

    @Insert("insert into DataImg values(null,#{price},#{title},#{type})")
    Integer insert(Comment comment);

    @Update("upate DataImg set price=#{price},title=#{title},type=#{type} where id=#{id} ")
    int update(DataImg dateImg);

    @Select("select count(1) from DataImg")
    int selectCount();
}
