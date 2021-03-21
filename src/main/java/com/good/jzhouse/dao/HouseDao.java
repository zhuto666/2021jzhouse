package com.good.jzhouse.dao;

import com.good.jzhouse.bean.House;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface HouseDao {

    @Select("select * from House")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="title",property="title"),
            @Result(column="describe",property="describe"),
            @Result(column="room",property="room"),
            @Result(column="hall",property="hall"),
            @Result(column="defend",property="defend"),
            @Result(column="houseSize",property="houseSize"),
            @Result(column="price",property="price"),
            @Result(column="storeyUser",property="storeyUser"),
            @Result(column="storeySum",property="storeySum"),
            @Result(column="roomFacilities",property="roomFacilities"),
            @Result(column="location",property="location"),
            @Result(column="beginTime",property="beginTime"),
            @Result(column="indoorImg",property="indoorImg"),
            @Result(column="houseTypeImg",property="houseTypeImg"),
            @Result(column="outdoorImg",property="outdoorImg"),
            @Result(column="video",property="video"),
            @Result(column="userId",property="user",many=@Many(select="com.good.jzhouse.dao.UsersDao.selectById")),
            @Result(column="houseTypeId",property="houseType",many=@Many(select="com.good.jzhouse.dao.HouseTypeDao.selectById")),
            @Result(column="villageId",property="village",many=@Many(select="com.good.jzhouse.dao.VillageDao.selectById")),
            @Result(column="areaId",property="area",many=@Many(select="com.good.jzhouse.dao.AreaDao.selectById")),
            @Result(column="renovationId",property="renovation",many=@Many(select="com.good.jzhouse.dao.RenovationDao.selectById")),
            @Result(column="facilitiesId",property="facilitie",many=@Many(select="com.good.jzhouse.dao.FacilitiesDao.selectById")),
            @Result(column="orientation",property="orientation")
    })
    List<House> findAll();

    @Select("SELECT h.* FROM sellhouse s,house h WHERE s.houseid=h.id AND TYPE=1 and s.propertieId=#{pid} limit 0,2")
    List<House> findAllNewHouse(Integer pid);

    @Update("update house set title=#{title},describe=#{describe},room=#{room},hall=#{hall},defend=#{defend}," +
            "houseSize=#{houseSize},price=#{price},storeyUser=#{storeyUser},storeySum=#{storeySum},roomFacilities=#{roomFacilities}," +
            "beginTime=#{beginTime},indoorImg=#{indoorImg},houseTypeImg=#{houseTypeImg},outdoorImg=#{outdoorImg},video=#{video}," +
            "userId=#{user.uid},houseTypeId=#{houseType.id},villageId=#{village.id},areaId=#{areaId.id},renovation=#{renvationId}," +
            "facilitieId=#{facilitieId},orientation=#{orientation} where id=#{id}")
    int update(House house);

    @Insert("insert into house values(#{title},#{describe},#{room},#{hall},#{defend}," +
            "#{houseSize},#{price},#{storeyUser},#{storeySum},#{roomFacilities}," +
            "#{beginTime},#{indoorImg},#{houseTypeImg},#{outdoorImg},#{video}," +
            "#{user.uid},#{houseType.id},#{village.id},#{areaId.id},#{renvationId}," +
            "#{facilitieId},#{orientation})")
    int insert(House house);

    @Delete("delete from house where id=#{id}")
    int delete(Integer id);

    @Select("select count(1) from house")
    int selectCount();

    @Select("select * from house where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="title",property="title"),
            @Result(column="describe",property="describe"),
            @Result(column="room",property="room"),
            @Result(column="hall",property="hall"),
            @Result(column="defend",property="defend"),
            @Result(column="houseSize",property="houseSize"),
            @Result(column="price",property="price"),
            @Result(column="storeyUser",property="storeyUser"),
            @Result(column="storeySum",property="storeySum"),
            @Result(column="roomFacilities",property="roomFacilities"),
            @Result(column="location",property="location"),
            @Result(column="beginTime",property="beginTime"),
            @Result(column="indoorImg",property="indoorImg"),
            @Result(column="houseTypeImg",property="houseTypeImg"),
            @Result(column="outdoorImg",property="outdoorImg"),
            @Result(column="video",property="video"),
            @Result(column="userId",property="user",many=@Many(select="com.good.jzhouse.dao.UsersDao.selectById")),
            @Result(column="houseTypeId",property="houseType",many=@Many(select="com.good.jzhouse.dao.HouseTypeDao.selectById")),
            @Result(column="villageId",property="village",many=@Many(select="com.good.jzhouse.dao.VillageDao.selectById")),
            @Result(column="areaId",property="area",many=@Many(select="com.good.jzhouse.dao.AreaDao.selectById")),
            @Result(column="renovationId",property="renovation",many=@Many(select="com.good.jzhouse.dao.RenovationDao.selectById")),
            @Result(column="facilitiesId",property="facilitie",many=@Many(select="com.good.jzhouse.dao.FacilitiesDao.selectById")),
            @Result(column="id",property="list",many=@Many(select="com.good.jzhouse.dao.LablelHouseDao.findByHouseId")),
            @Result(column="orientation",property="orientation")
    })
    House selectById(Integer id);

    @Select("SELECT h.* FROM sellhouse s,house h WHERE s.houseid=h.id AND TYPE=#{type} and h.id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="title",property="title"),
            @Result(column="describe",property="describe"),
            @Result(column="room",property="room"),
            @Result(column="hall",property="hall"),
            @Result(column="defend",property="defend"),
            @Result(column="houseSize",property="houseSize"),
            @Result(column="price",property="price"),
            @Result(column="storeyUser",property="storeyUser"),
            @Result(column="storeySum",property="storeySum"),
            @Result(column="roomFacilities",property="roomFacilities"),
            @Result(column="location",property="location"),
            @Result(column="beginTime",property="beginTime"),
            @Result(column="indoorImg",property="indoorImg"),
            @Result(column="houseTypeImg",property="houseTypeImg"),
            @Result(column="outdoorImg",property="outdoorImg"),
            @Result(column="video",property="video"),
            @Result(column="userId",property="user",many=@Many(select="com.good.jzhouse.dao.UsersDao.selectById")),
            @Result(column="houseTypeId",property="houseType",many=@Many(select="com.good.jzhouse.dao.HouseTypeDao.selectById")),
            @Result(column="villageId",property="village",many=@Many(select="com.good.jzhouse.dao.VillageDao.selectById")),
            @Result(column="areaId",property="area",many=@Many(select="com.good.jzhouse.dao.AreaDao.selectById")),
            @Result(column="renovationId",property="renovation",many=@Many(select="com.good.jzhouse.dao.RenovationDao.selectById")),
            @Result(column="facilitiesId",property="facilitie",many=@Many(select="com.good.jzhouse.dao.FacilitiesDao.selectById")),
            @Result(column="id",property="list",many=@Many(select="com.good.jzhouse.dao.LablelHouseDao.findByHouseId")),
            @Result(column="orientation",property="orientation")
    })
    House selectByXinId(@Param("id") Integer id,@Param("type") Integer type);

}
