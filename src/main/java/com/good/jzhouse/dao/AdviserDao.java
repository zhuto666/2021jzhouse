package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Adviser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdviserDao {

    //模糊查询加分页
    @Select("<script>" +
            " select * from Adviser " +
            " <where>" +
            "  <if test=\"consultantName != null and consultantName!=''\"> "+
            "  	consultantName like concat('%',#{consultantName},'%')" +
            "  </if>" +
            " </where>" +
            " limit #{offset},#{limit}" +
            "</script>")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column ="ranking",property ="ranking"),
            @Result(column = "consultantName",property = "consultantName"),
            @Result(column = "consultanPortrait",property = "consultanPortrait"),
            @Result(column = "propertiesid",property = "properties",one =@One(select = "com.good.jzhouse.dao.PropertiesDao.selectById")),
            @Result(column = "grade",property = "grade"),
            @Result(column = "likes",property = "likes"),
            @Result(column = "views",property = "views"),
            @Result(column = "activity",property = "activity")
    })
    List<Adviser> findAll(@Param("consultantName") String consultantName,@Param("offset")Integer offset,@Param("limit")Integer limit);

    @Select("select * from Adviser limit 0,6")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column ="ranking",property ="ranking"),
            @Result(column = "consultantName",property = "consultantName"),
            @Result(column = "consultanPortrait",property = "consultanPortrait"),
            @Result(column = "grade",property = "grade"),
            @Result(column = "likes",property = "likes"),
            @Result(column = "views",property = "views"),
            @Result(column = "activity",property = "activity")
    })
    List<Adviser> find5();

    //模糊查询加分页总数
    @Select("<script>" +
            " select count(*) from Adviser " +
            " <where>" +
            "  <if test=\"consultantName != null and consultantName!=''\"> "+
            "  	consultantName like concat('%',#{consultantName},'%')" +
            "  </if>" +
            " </where>" +
            "</script>")
    int count(@Param("consultantName") String consultantName);
}
