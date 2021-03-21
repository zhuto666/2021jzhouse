package com.good.jzhouse.dao;

import com.good.jzhouse.bean.NewsType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsTypeDao {

    /* 查询Menu */
    @Select("select * from NewsType")
    List<NewsType> findAll();

    /* 根据id查询菜单编号 */
    @Select("select * from NewsType where id=#{id}")
    NewsType selectById(Integer id);
}
