package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Root;
import com.good.jzhouse.bean.Sellhouse;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RootDao {

    @Select("select * from Root")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="roleId",property="role",one=@One(select="com.good.jzhouse.dao.RoleDao.selectById")),
            @Result(column="mid",property="menu",one=@One(select="com.good.jzhouse.dao.MenuDao.selectById"))
    })
    List<Sellhouse> findAll();

    @Select("select * from Root where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="roleId",property="role",one=@One(select="com.good.jzhouse.dao.RoleDao.selectById")),
            @Result(column="mid",property="menu",one=@One(select="com.good.jzhouse.dao.MenuDao.selectById"))
    })
    Root selectById(Integer id);

    @Insert("insert into Root values(#{id},#{role.roleId},#{menu.mid}")
    int insert(Root u);

    @Update("update Root set roleId=#{role.roleId},mid=#{menu.mid} WHERE id=#{id})")
    int update(Root u);

    @Delete("delete from Root where id=#{id}")
    int del(int id);

    @Select("select count(*) from Root")
    int count();
}
