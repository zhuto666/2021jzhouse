package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoleDao {

    @Select("select * from Role")
    List<Role> findAll();

    @Select("select * from Role where roleid = #{id}")
    Role selectById(Integer id);

    @Insert("insert into Role values(#{roleid},#{roleName}")
    int insert(Role u);

    @Update("update Role set roleName=#{roleName} WHERE roleid=#{roleid})")
    int update(Role u);

    @Delete("delete from Role where roleid=#{id}")
    int del(int id);

    @Select("select count(*) from Role")
    int count();
}
