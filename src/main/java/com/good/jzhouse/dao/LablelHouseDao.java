package com.good.jzhouse.dao;

import com.good.jzhouse.bean.LabelHouse;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LablelHouseDao {

    @Select("select * from LabelHouse")
    List<LabelHouse> findAll();

    @Select("select * from LabelHouse where houseid=#{hid}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "lableid",property = "label",one = @One(select = "com.good.jzhouse.dao.LabelDao.selectById"))
    })
    List<LabelHouse> findByHouseId(Integer hid);

    @Select("select * from LabelHouse where id=#{id}")
    LabelHouse selectById(Integer id);

    @Delete("delete from LabelHouse where id=#{id}")
    int delete(Integer id);

    @Insert("insert into LabelHouse values(null,#{House.houseId},#{Label.lableId}")
    int insert(LabelHouse labelHouse);

    @Update("update LabelHouse set houseId=#{House.houseId},lableId=#{Label.lableId} where id=#{id}")
    int update(LabelHouse labelHouse);

    @Select("select count(1) from LabelHouse")
    int selectCount();
}
