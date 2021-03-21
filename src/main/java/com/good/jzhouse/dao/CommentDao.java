package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CommentDao {

    @Select("select * from Comment")
    @Results({
            @Result(id = true,column = "id" ,property = "id"),
            @Result(column = "content" ,property = "content"),
            @Result(column = "userId",property = "user",one = @One(select = "com.good.jzhouse.dao.UsersDao.selectById")),
            @Result(column = "propertiesId",property = "properties",one = @One(select="com.good.jzhouse.dao.PropertiesDao.selectById")),
            @Result(column = "newsId",property = "news",one = @One(select = "com.good.jzhouse.dao.NewsDao.selectById")),
            @Result(column = "fid",property = "fid"),
            @Result(column = "beginTime",property = "beginTime"),
            @Result(column = "good",property = "good")
    })
    List<Comment> findAll();

    @Select("<script>SELECT * FROM `Comment` WHERE buildingId=#{id} AND fid=0 ORDER BY beginTime DESC <if test='index!=-1'>limit #{index},#{size}</if></script>")
    @Results({
            @Result(id = true,column = "id" ,property = "id"),
            @Result(column = "content" ,property = "content"),
            @Result(column = "userId",property = "user",one = @One(select = "com.good.jzhouse.dao.UsersDao.selectById")),
            @Result(column = "propertiesId",property = "properties",one = @One(select="com.good.jzhouse.dao.PropertiesDao.selectById")),
            @Result(column = "fid",property = "fid"),
            @Result(column = "beginTime",property = "beginTime"),
            @Result(column = "good",property = "good"),
            @Result(column = "id",property = "clist",many = @Many(select = "com.good.jzhouse.dao.CommentDao.selectByFid"))
    })
    List<Comment> findAllPro1(@Param("index") Integer index,@Param("size") Integer size,@Param("id") Integer id);

    @Select("<script>SELECT * FROM `Comment` WHERE buildingId=#{id} AND fid=0 ORDER BY good DESC <if test='index!=-1'>limit #{index},#{size}</if></script>")
    @Results({
            @Result(id = true,column = "id" ,property = "id"),
            @Result(column = "content" ,property = "content"),
            @Result(column = "userId",property = "user",one = @One(select = "com.good.jzhouse.dao.UsersDao.selectById")),
            @Result(column = "propertiesId",property = "properties",one = @One(select="com.good.jzhouse.dao.PropertiesDao.selectById")),
            @Result(column = "fid",property = "fid"),
            @Result(column = "beginTime",property = "beginTime"),
            @Result(column = "good",property = "good"),
            @Result(column = "id",property = "clist",many = @Many(select = "com.good.jzhouse.dao.CommentDao.selectByFid"))
    })
    List<Comment> findAllPro2(@Param("index") Integer index,@Param("size") Integer size,@Param("id") Integer id);

    @Select("select * from Comment where id=#{id}")
    @Results({
            @Result(id = true,column = "id" ,property = "id"),
            @Result(column = "content" ,property = "content"),
            @Result(column = "userId",property = "user",one = @One(select = "com.good.jzhouse.dao.UsersDao.selectById")),
            @Result(column = "propertiesId",property = "properties",one = @One(select="com.good.jzhouse.dao.PropertiesDao.selectById")),
            @Result(column = "newsId",property = "news",one = @One(select = "com.good.jzhouse.dao.NewsDao.selectById")),
            @Result(column = "fid",property = "fid"),
            @Result(column = "beginTime",property = "beginTime"),
            @Result(column = "good",property = "good"),
    })
    Comment selectById(Integer id);

    @Select("select * from Comment ORDER BY beginTime DESC limit 0,1")
    @Results({
            @Result(id = true,column = "id" ,property = "id"),
            @Result(column = "content" ,property = "content"),
            @Result(column = "userId",property = "user",one = @One(select = "com.good.jzhouse.dao.UsersDao.selectById")),
            @Result(column = "propertiesId",property = "properties",one = @One(select="com.good.jzhouse.dao.PropertiesDao.selectById")),
            @Result(column = "fid",property = "fid"),
            @Result(column = "beginTime",property = "beginTime"),
            @Result(column = "good",property = "good"),
    })
    Comment selectByNew();

    @Select("select * from Comment where fid=#{id} ORDER BY beginTime DESC")
    @Results({
            @Result(id = true,column = "id" ,property = "id"),
            @Result(column = "content" ,property = "content"),
            @Result(column = "userId",property = "user",one = @One(select = "com.good.jzhouse.dao.UsersDao.selectById")),
            @Result(column = "propertiesId",property = "properties",one = @One(select="com.good.jzhouse.dao.PropertiesDao.selectById")),
            @Result(column = "fid",property = "fid"),
            @Result(column = "beginTime",property = "beginTime"),
            @Result(column = "good",property = "good")
    })
    List<Comment> selectByFid(Integer id);



    @Delete("delete from Comment where id=#{id}")
    int delete(Integer id);

    @Insert("INSERT INTO `Comment` VALUES(null,#{content},#{user.uid},#{properties.id},#{news.id},#{fid},NOW(),#{good})")
    Integer insert(Comment comment);

    @Update("update Comment set content=#{content},userId=#{user.uid},propertiesId=#{properties.id},newsId=#{news.id},fid=#{fid},beginTime=#{beginTime},good=#{good} where id=#{id} ")
    int update(Comment comment);

    @Select("select count(1) from Comment")
    int selectCount();

    @Select("select count(1) from Comment where fid=#{fid}")
    int countByFid(Integer fid);
    @Select("SELECT count(1) FROM `Comment` WHERE buildingId=#{id} AND fid=0")
    int countPage(Integer id);

}
