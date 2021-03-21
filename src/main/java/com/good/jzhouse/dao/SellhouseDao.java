package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Sellhouse;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SellhouseDao {

    @Select("select * from Sellhouse where type=#{sid} and online=true limit 14")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="type",property="type"),
            @Result(column="online",property="online"),
            @Result(column="beginTime",property="beginTime"),
            @Result(column="effectiveTime",property="effectiveTime"),
            @Result(column="houseId",property="house",one=@One(select="com.good.jzhouse.dao.HouseDao.selectById")),
            @Result(column="propertieId",property="propertie",one=@One(select="com.good.jzhouse.dao.PropertiesDao.selectById"))
    })
    List<Sellhouse> findAllIndex(int sid);



    @Select("select * from Sellhouse")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="type",property="type"),
            @Result(column="online",property="online"),
            @Result(column="beginTime",property="beginTime"),
            @Result(column="effectiveTime",property="effectiveTime"),
            @Result(column="houseId",property="house",one=@One(select="com.good.jzhouse.dao.HouseDao.selectById")),
            @Result(column="propertieId",property="propertie",one=@One(select="com.good.jzhouse.dao.PropertiesDao.selectById"))
    })
    List<Sellhouse> findAll();

    @Select("<script>SELECT s.* FROM sellhouse s,house h WHERE s.houseId = h.id AND TYPE=#{type}" +
            "<if test='name!=null'> and h.title like concat('%',#{name},'%')</if>" +
            "<if test='areaId!=null and areaId!=-1 and (areaIdz==null or areaIdz==-1)'> and h.areaId IN(SELECT id FROM AREA WHERE id=#{areaId} OR pid=#{areaId})</if>" +
            "<if test='areaIdz!=null and areaIdz!=-1'> and h.areaId=#{areaIdz}</if>" +
            "<if test='priceMin!=null and priceMin!=-1 and (priceMax==null or priceMax==-1)'> and h.price &lt; #{priceMin}</if>" +
            "<if test='priceMax!=null and priceMax!=-1 and (priceMin==null or priceMin==-1)'> and h.price &gt; #{priceMax}</if>" +
            "<if test='priceMin!=null and priceMin!=-1 and priceMax!=null and priceMax!=-1'> and h.price BETWEEN #{priceMin} AND #{priceMax}</if>" +
            "<if test='mjMin!=null and mjMin!=-1 and (mjMax==null or mjMax==-1)'> and h.houseSize &lt; #{mjMin}</if>" +
            "<if test='mjMax!=null and mjMax!=-1 and (mjMin==null or mjMin==-1)'> and h.houseSize &gt; #{mjMax}</if>" +
            "<if test='mjMin!=null and mjMin!=-1 and mjMax!=null and mjMax!=-1'> and h.houseSize BETWEEN #{mjMin} AND #{mjMax}</if>" +
            "<if test='hx!=null and hx!=-1'> and h.room=#{hx}</if>" +
            "<if test='houseTypeId!=null and houseTypeId!=-1'> and h.houseTypeId=#{houseTypeId}</if>" +
            "<if test='renovationId!=null and renovationId!=-1'> and h.renovationId=#{renovationId}</if>" +
            " <if test='paixu==1'>order by h.price</if> <if test='paixu==2'>order by h.price desc</if> limit #{index},#{size}</script>")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="type",property="type"),
            @Result(column="online",property="online"),
            @Result(column="beginTime",property="beginTime"),
            @Result(column="effectiveTime",property="effectiveTime"),
            @Result(column="houseId",property="house",one=@One(select="com.good.jzhouse.dao.HouseDao.selectById"))
    })
    //type 类型， name 标题， index
    List<Sellhouse> findAllPageHouse(@Param("type") Integer type,@Param("name") String name,
                                   @Param("index") Integer index, @Param("size") Integer size,
                                   @Param("areaId") Integer areaId,@Param("areaIdz") Integer areaIdz,
                                   @Param("priceMin") Integer priceMin,@Param("priceMax") Integer priceMax,
                                   @Param("mjMin") Integer mjMin,@Param("mjMax") Integer mjMax,
                                   @Param("hx") Integer hx, @Param("renovationId") Integer renovationId, @Param("houseTypeId") Integer houseTypeId,@Param("paixu") Integer paixu);

    @Select("select * from Sellhouse where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="type",property="type"),
            @Result(column="online",property="online"),
            @Result(column="beginTime",property="beginTime"),
            @Result(column="effectiveTime",property="effectiveTime"),
            @Result(column="houseId",property="house",one=@One(select="com.good.jzhouse.dao.HouseDao.selectById")),
            @Result(column="propertieId",property="propertie",one=@One(select="com.good.jzhouse.dao.PropertiesDao.selectById"))
    })
    Sellhouse selectById(Integer id);

    @Insert("insert into Sellhouse values(#{id},#{house.id},#{type},#{online},#{propertie.id},#{beginTime},#{effectiveTime})")
    int insert(Sellhouse u);

    @Update("update Sellhouse set houseId=#{house.id},type=#{type},online=#{online},propertieId=#{propertie.id},beginTime=#{beginTime},effectiveTime=#{effectiveTime} WHERE id=#{id})")
    int update(Sellhouse u);

    @Delete("delete from Sellhouse where id=#{id}")
    int del(int id);

    @Select("select count(*) from Sellhouse")
    int count();

    @Select("<script>select count(*) from sellhouse s,house h where s.houseId = h.id AND type=#{type} <if test='name!=null'> and h.title like concat('%',#{name},'%')</if></script>")
    int countByType(Integer type,@Param("name") String name);

    @Select("<script>SELECT count(*) FROM sellhouse s,house h WHERE s.houseId = h.id AND TYPE=#{type}" +
            "<if test='name!=null'> and h.title like concat('%',#{name},'%')</if>" +
            "<if test='areaId!=null and areaId!=-1 and (areaIdz==null or areaIdz==-1)'> and h.areaId IN(SELECT id FROM AREA WHERE id=#{areaId} OR pid=#{areaId})</if>" +
            "<if test='areaIdz!=null and areaIdz!=-1'> and h.areaId=#{areaIdz}</if>" +
            "<if test='priceMin!=null and priceMin!=-1 and (priceMax==null or priceMax==-1)'> and h.price &lt; #{priceMin}</if>" +
            "<if test='priceMax!=null and priceMax!=-1 and (priceMin==null or priceMin==-1)'> and h.price &gt; #{priceMax}</if>" +
            "<if test='priceMin!=null and priceMin!=-1 and priceMax!=null and priceMax!=-1'> and h.price BETWEEN #{priceMin} AND #{priceMax}</if>" +
            "<if test='mjMin!=null and mjMin!=-1 and (mjMax==null or mjMax==-1)'> and h.houseSize &lt; #{mjMin}</if>" +
            "<if test='mjMax!=null and mjMax!=-1 and (mjMin==null or mjMin==-1)'> and h.houseSize &gt; #{mjMax}</if>" +
            "<if test='mjMin!=null and mjMin!=-1 and mjMax!=null and mjMax!=-1'> and h.houseSize BETWEEN #{mjMin} AND #{mjMax}</if>" +
            "<if test='hx!=null and hx!=-1'> and h.room=#{hx}</if>" +
            "<if test='houseTypeId!=null and houseTypeId!=-1'> and houseTypeId=#{houseTypeId}</if>" +
            "<if test='renovationId!=null and renovationId!=-1'> and h.renovationId=#{renovationId}</if>" +
            "</script>")
    int countPage(@Param("type") Integer type,@Param("name") String name,
                  @Param("areaId") Integer areaId,@Param("areaIdz") Integer areaIdz,
                  @Param("priceMin") Integer priceMin,@Param("priceMax") Integer priceMax,
                  @Param("mjMin") Integer mjMin,@Param("mjMax") Integer mjMax,
                  @Param("hx") Integer hx, @Param("renovationId") Integer renovationId, @Param("houseTypeId") Integer houseTypeId);
}
