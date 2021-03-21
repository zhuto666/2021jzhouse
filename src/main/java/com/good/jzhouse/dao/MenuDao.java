package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuDao {

    /* 查询Menu */
    @Select("select * from Menu")
    List<Menu> findAll();

    /* 根据id查询菜单编号 */
    @Select("select * from Menu where mid=#{id}")
    Menu selectById(Integer id);
}
