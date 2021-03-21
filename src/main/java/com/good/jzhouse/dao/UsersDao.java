package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UsersDao {

    @Select("select * from Users")
    @Results({
            @Result(id=true,column="uid",property="uid"),
            @Result(column="userId",property="userId"),
            @Result(column="linkman",property="linkman"),
            @Result(column="communityName",property="communityName"),
            @Result(column="sex",property="sex"),
            @Result(column="password",property="password"),
            @Result(column="phone",property="phone"),
            @Result(column="picture",property="picture"),
            @Result(column="gold",property="gold"),
            @Result(column="integral",property="integral"),
            @Result(column="balance",property="balance"),
            @Result(column="createDate",property="createDate"),
            @Result(column="lastLoginTime",property="lastLoginTime"),
            @Result(column="propertyCpy",property="propertyCpy"),
            @Result(column="propertyFee",property="propertyFee"),
            @Result(column="roleId",property="role",one=@One(select="com.good.jzhouse.dao.RoleDao.selectById"))
    })
    List<Users> findAll();

    @Select("select * from users where uid=#{id}")
    @Results({
            @Result(id=true,column="uid",property="uid"),
            @Result(column="userId",property="userId"),
            @Result(column="linkman",property="linkman"),
            @Result(column="communityName",property="communityName"),
            @Result(column="sex",property="sex"),
            @Result(column="password",property="password"),
            @Result(column="phone",property="phone"),
            @Result(column="picture",property="picture"),
            @Result(column="gold",property="gold"),
            @Result(column="integral",property="integral"),
            @Result(column="balance",property="balance"),
            @Result(column="createDate",property="createDate"),
            @Result(column="lastLoginTime",property="lastLoginTime"),
            @Result(column="propertyCpy",property="propertyCpy"),
            @Result(column="propertyFee",property="propertyFee"),
            @Result(column="roleId",property="role",one=@One(select="com.good.jzhouse.dao.RoleDao.selectById"))
    })
    Users selectById(Integer id);

    @Insert("insert into Users values(#{uid},#{userId},#{linkman},#{communityName},#{sex},#{password},#{phone},#{picture},#{role.roleid},#{gold},#{integral},#{balance},#{createDate}," +
            "#{lastLoginTime},#{propertyCpy},#{propertyFee})")
    int insert(Users u);

    @Update("update Users set userId=#{userId},linkman=#{linkman},communityName=#{communityName},sex=#{sex},password=#{password},phone=#{phone},picture=#{picture},roleId=#{role.roleid},gold=#{gold},integral=#{integral},balance=#{balance},createDate=#{createDate},"+
            "lastLoginTime=#{lastLoginTime},propertyCpy=#{propertyCpy},propertyFee=#{propertyFee} WHERE uid=#{uid})")
    int update(Users u);

    @Delete("delete from Users where uid=#{id}")
    int del(int id);

    @Select("select count(*) from Users")
    int count();
}
