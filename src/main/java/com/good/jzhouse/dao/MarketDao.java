package com.good.jzhouse.dao;

import com.good.jzhouse.bean.Market;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface MarketDao {

    /* 查询 */
    @Select("select * from Market")
    List<Market> findAll();

    /* 新增 */
    @Insert({"insert into Market values(null,#{time},#{areas},#{plot},#{location},#{price},#{unit},#{acreage}"})
    int insert(@Param("time")Date time,@Param("areas")String areas,@Param("plot")String plot,@Param("location")String location,@Param("price")String price,@Param("unit")String unit,@Param("acreage")String acreage);

    /* 根据id查询地块编号 */
    @Select("select * from Market where id=#{id}")
    Market selectById(Integer id);

    /* 分页查询全部信息 */
    @Select("<script> " +
            " select * from Market " +
            " order by id" +
            " limit #{offset},#{limit}" +
            " </script> ")
    List<Market> findAlls(@Param("offset")Integer offset
            ,@Param("limit")Integer limit);


    /* 模糊查询*/
    @Select("<script>" +
            " select * from Market " +
            " <where>" +
            "  <if test=\"plot != null and plot!=''\"> "+
            "  	plot like concat('%',#{plot},'%')" +
            "  </if>" +
            "  <if test=\"location != null and location!=''\"> "+
            "   or location like concat('%',#{location},'%')"+
            "  </if>" +
            "  <if test=\"unit != null and unit!=''\"> "+
            "   or unit like concat('%',#{unit},'%')"+
            "  </if>" +
            " </where>" +
            " order by id" +
            " limit #{offset},#{limit}" +
            "</script>")
    List<Market> blurredSelect(@Param("unit")String unit,@Param("location")String location, @Param("plot") String plot,
                               @Param("offset")Integer offset
                              ,@Param("limit")Integer limit);

    @Select("<script>" +
            " select count(*) from Market " +
            " <where>" +
            "  <if test=\"plot != null and plot!=''\"> "+
            "  	plot like concat('%',#{plot},'%')" +
            "  </if>" +
            "  <if test=\"location != null and location!=''\"> "+
            "   or location like concat('%',#{location},'%')"+
            "  </if>" +
            "  <if test=\"unit != null and unit!=''\"> "+
            "   or unit like concat('%',#{unit},'%')"+
            "  </if>" +
            " </where>" +
            "</script>")
    int count(@Param("unit")String unit,@Param("location")String location, @Param("plot") String plot);
}
