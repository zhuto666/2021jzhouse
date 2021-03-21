package com.good.jzhouse.dao;

import com.good.jzhouse.bean.News;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsDao {

    @Select("select * from News")
    List<News> findAll();
}
