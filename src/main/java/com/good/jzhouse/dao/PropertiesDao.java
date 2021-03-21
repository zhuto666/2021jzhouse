package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Properties;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PropertiesDao {








    /*查询全部*/
    @Select("select * from Properties")
    @Results({
        @Result(id=true,column="id",property="id"),
        @Result(column="name",property="name"),
        @Result(column="status",property="status"),
        @Result(column="price",property="price"),
        @Result(column="describe",property="describe"),
        @Result(column="deceloper",property="deceloper"),
        @Result(column="salesAdd",property="salesAdd"),
        @Result(column="propertiesAdd",property="propertiesAdd"),
        @Result(column="salesPhone",property="salesPhone"),
        @Result(column="developTime",property="developTime"),
        @Result(column="beginTime",property="beginTime"),
        @Result(column="builtArea",property="builtArea"),
        @Result(column="referenceSum",property="referenceSum"),
        @Result(column="introduce",property="introduce"),
        @Result(column="houseTypeId",property="houseType",one=@One(select="com.good.jzhouse.dao.HouseTypeDao.selectById")),
        @Result(column="villageId",property="village",one=@One(select="com.good.jzhouse.dao.VillageDao.selectById")),
        @Result(column="id",property="chapros",many = @Many(select = "com.good.jzhouse.dao.ChaproDao.findAllByC")),
        @Result(column="areaId",property="area",one=@One(select="com.good.jzhouse.dao.AreaDao.selectById")),
        @Result(column = "ImgPath",property = "ImgPath")
    })
    List<Properties> findAll();


    /*楼盘表和特色关系表连表查*/
    @Select("<script>SELECT  DISTINCT p.* FROM Properties p ,Chapro cp\n" +
            "WHERE cp.`propertiesId` = p.`id`\n" +
            "<if test='tj!=-1'>AND characteristicId = #{tj}</if>" +
            "limit 6</script>")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="status",property="status"),
            @Result(column="price",property="price"),
            @Result(column="describe",property="describe"),
            @Result(column="deceloper",property="deceloper"),
            @Result(column="salesAdd",property="salesAdd"),
            @Result(column="propertiesAdd",property="propertiesAdd"),
            @Result(column="salesPhone",property="salesPhone"),
            @Result(column="developTime",property="developTime"),
            @Result(column="beginTime",property="beginTime"),
            @Result(column="builtArea",property="builtArea"),
            @Result(column="referenceSum",property="referenceSum"),
            @Result(column="introduce",property="introduce"),
            @Result(column="houseTypeId",property="houseType",one=@One(select="com.good.jzhouse.dao.HouseTypeDao.selectById")),
            @Result(column="villageId",property="village",one=@One(select="com.good.jzhouse.dao.VillageDao.selectById")),
            @Result(column="id",property="chapros",many = @Many(select = "com.good.jzhouse.dao.ChaproDao.findAllByC")),
            @Result(column="areaId",property="area",one=@One(select="com.good.jzhouse.dao.AreaDao.selectById")),
            @Result(column = "ImgPath",property = "ImgPath")
    })
    List<Properties> findAllIndexTJ(@Param("tj") int tj);





    //楼盘的加各种条件查询
    @Select("<script>SELECT DISTINCT p.id did,p.* FROM properties p LEFT JOIN chapro c ON p.id=c.propertiesId" +
            "<where>"+
                "<if test='name!=null'> and name like concat('%',#{name},'%')</if>" +
                "<if test='areaId!=null and areaId!=-1 and (areaIdz==null or areaIdz==-1)'> and areaId IN(SELECT id FROM AREA WHERE id=#{areaId} OR pid=#{areaId})</if>" +
                "<if test='areaIdz!=null and areaIdz!=-1'> and areaId=#{areaIdz}</if>" +
                "<if test='priceMin!=null and priceMin!=-1 and (priceMax==null or priceMax==-1)'> and price &lt; #{priceMin}</if>" +
                "<if test='priceMax!=null and priceMax!=-1 and (priceMin==null or priceMin==-1)'> and price &gt; #{priceMax}</if>" +
                "<if test='priceMin!=null and priceMin!=-1 and priceMax!=null and priceMax!=-1'> and price BETWEEN #{priceMin} AND #{priceMax}</if>" +
                "<if test='stutas!=null'> and status=#{stutas}</if>" +
                "<if test='houseTypeId!=null and houseTypeId!=-1'> and houseTypeId=#{houseTypeId}</if>" +
                "<if test='characteristicId!=null and characteristicId!=-1'> and c.characteristicId=#{characteristicId}</if>" +
            "</where>"+
            " <if test='paixu==1'>order by price</if> <if test='paixu==2'>order by price desc</if> limit #{index},#{size}</script>")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="status",property="status"),
            @Result(column="price",property="price"),
            @Result(column="describe",property="describe"),
            @Result(column="deceloper",property="deceloper"),
            @Result(column="salesAdd",property="salesAdd"),
            @Result(column="propertiesAdd",property="propertiesAdd"),
            @Result(column="salesPhone",property="salesPhone"),
            @Result(column="developTime",property="developTime"),
            @Result(column="beginTime",property="beginTime"),
            @Result(column="builtArea",property="builtArea"),
            @Result(column="referenceSum",property="referenceSum"),
            @Result(column="introduce",property="introduce"),
            @Result(column="houseTypeId",property="houseType",one=@One(select="com.good.jzhouse.dao.HouseTypeDao.selectById")),
            @Result(column="villageId",property="village",one=@One(select="com.good.jzhouse.dao.VillageDao.selectById")),
            @Result(column="id",property="chapros",many = @Many(select = "com.good.jzhouse.dao.ChaproDao.findAllByC")),
            @Result(column="areaId",property="area",one=@One(select="com.good.jzhouse.dao.AreaDao.selectById")),
            @Result(column = "ImgPath",property = "ImgPath")
    })
    List<Properties> findAllPage(@Param("name") String name,@Param("index") Integer index,
                                 @Param("size") Integer size,@Param("areaId") Integer areaId,@Param("areaIdz") Integer areaIdz,
                                 @Param("priceMin") Integer priceMin,@Param("priceMax") Integer priceMax,@Param("stutas") String stutas,
                                 @Param("characteristicId") Integer characteristicId,@Param("houseTypeId") Integer houseTypeId,@Param("paixu") Integer paixu);

    @Select("select * from Properties where id<>#{id} limit 0,6")
    List<Properties> findAllNotId(@Param("id") Integer id);

    @Select("select * from Properties where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="status",property="status"),
            @Result(column="price",property="price"),
            @Result(column="describe",property="describe"),
            @Result(column="deceloper",property="deceloper"),
            @Result(column="salesAdd",property="salesAdd"),
            @Result(column="propertiesAdd",property="propertiesAdd"),
            @Result(column="salesPhone",property="salesPhone"),
            @Result(column="developTime",property="developTime"),
            @Result(column="beginTime",property="beginTime"),
            @Result(column="builtArea",property="builtArea"),
            @Result(column="referenceSum",property="referenceSum"),
            @Result(column="introduce",property="introduce"),
            @Result(column="houseTypeId",property="houseType",one=@One(select="com.good.jzhouse.dao.HouseTypeDao.selectById")),
            @Result(column="villageId",property="village",one=@One(select="com.good.jzhouse.dao.VillageDao.selectById")),
            @Result(column="id",property="chapros",many = @Many(select = "com.good.jzhouse.dao.ChaproDao.findAllByC")),
            @Result(column="areaId",property="area",one=@One(select="com.good.jzhouse.dao.AreaDao.selectById")),
            @Result(column = "ImgPath",property = "ImgPath")
    })
    Properties selectById(@Param("id") Integer id);

    @Select("select p.id,p.name,p.describe from Properties p where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name")
    })
    Properties selectByIdMap(@Param("id") Integer id);

    @Update("update Properties set name=#{name},status=#{status},houseTypeId=#{houseType.id},villageId=#{village.id},"+
            "areaId=#{area.id},price=#{price},describe=#{describe},deceloper=#{deceloper},salesAdd=#{salesAdd},"+
            "propertiesAdd=#{propertiesAdd},salesPhone=#{salesPhone},developTime=#{developTime},beginTime=#{beginTime},"+
            "builtArea=#{builtArea},referenceSum=#{referenceSum},introduce=#{introduce},ImgPath=#{ImgPath} where id=#{id}"
           )
    int update(Properties properties);

    @Insert("insert into Properties values(#{id},#{name},#{status},#{houseType.id},#{village.id},#{area.id},#{price}," +
            "#{describe},#{deceloper},#{salesAdd},#{propertiesAdd},#{salesPhone},#{developTime},#{beginTime}," +
            "#{builtArea},#{referenceSum},#{introduce},#{ImgPath})")
    int insert(Properties properties);

    @Delete("delete from Properties where id=#{id}")
    int del(@Param("id")Integer id);

    @Select("select count(*) from Properties")
    int count();
    @Select("select count(*) from Properties where name like concat('%',#{name},'%')")
    int count2(String name);

    @Select("<script>SELECT COUNT(DISTINCT p.id) FROM properties p LEFT JOIN chapro c ON p.id=c.propertiesId" +
            "<where>" +
                "<if test='name!=null'> and name like concat('%',#{name},'%')</if>" +
                "<if test='areaId!=null and areaId!=-1 and (areaIdz==null or areaIdz==-1)'> and areaId IN(SELECT id FROM AREA WHERE id=#{areaId} OR pid=#{areaId})</if>" +
                "<if test='areaIdz!=null and areaIdz!=-1'> and areaId=#{areaIdz}</if>" +
                "<if test='priceMin!=null and priceMin!=-1 and priceMax==null and priceMax==-1'> and price &lt; #{priceMin}</if>" +
                "<if test='priceMax!=null and priceMax!=-1 and priceMin==null and priceMin==-1'> and price &gt; #{priceMax}</if>" +
                "<if test='priceMin!=null and priceMin!=-1 and priceMax!=null and priceMax!=-1'> and price BETWEEN #{priceMin} AND #{priceMax}</if>" +
                "<if test='stutas!=null'> and status=#{stutas}</if>" +
                "<if test='houseTypeId!=null and houseTypeId!=-1'> and houseTypeId=#{houseTypeId}</if>" +
                "<if test='characteristicId!=null and characteristicId!=-1'> and c.characteristicId=#{characteristicId}</if>" +
            "</where>" +
            "</script>")
    int countPage(@Param("name") String name,@Param("areaId") Integer areaId,@Param("areaIdz") Integer areaIdz,
                  @Param("priceMin") Integer priceMin,@Param("priceMax") Integer priceMax,@Param("stutas") String stutas,
                  @Param("characteristicId") Integer characteristicId,@Param("houseTypeId") Integer houseTypeId);
}

