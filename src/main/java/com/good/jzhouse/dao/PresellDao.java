package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Presell;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PresellDao {

    @Select("select * from Presell")
    List<Presell> findAll();

    @Select("select * from Presell id=#{id}")
    Presell selectById( @Param("id")Integer id);

    @Select("<script>" +
            " select count(*) from Presell " +
            " <where>" +
            "  <if test=\"license != null and license!=''\"> "+
            "  	license like concat('%',#{license},'%')" +
            "  </if>" +
            "  <if test=\"project != null and project!=''\"> "+
            "   or project like concat('%',#{project},'%')"+
            "  </if>" +
            "  <if test=\"company != null and company!=''\"> "+
            "   or company like concat('%',#{company},'%')"+
            "  </if>" +
            " </where>" +
            "</script>")
    int count(@Param("license")String license, @Param("project")String project
            , @Param("company") String company);

    /* 模糊查询*/
    @Select("<script>" +
            " select * from Presell " +
            " <where>" +
            "  <if test=\"license != null and license!=''\"> "+
            "  	license like concat('%',#{license},'%')" +
            "  </if>" +
            "  <if test=\"project != null and project!=''\"> "+
            "   or project like concat('%',#{project},'%')"+
            "  </if>" +
            "  <if test=\"company != null and company!=''\"> "+
            "   or company like concat('%',#{company},'%')"+
            "  </if>" +
            " </where>" +
            " order by id" +
            " limit #{offset},#{limit}" +
            "</script>")
    List<Presell> PresellSelect(@Param("license")String license, @Param("project")String project
                                , @Param("company") String company,
                               @Param("offset")Integer offset, @Param("limit")Integer limit);


}
