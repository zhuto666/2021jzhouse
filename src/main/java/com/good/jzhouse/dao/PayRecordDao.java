package com.good.jzhouse.dao;

import com.good.jzhouse.bean.PayRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface
PayRecordDao {

    @Select("select * from PayRecord")
    List<PayRecord> findAll();

    @Select("select * from PayRecord where pid=#{id} ")
    PayRecord selectById( @Param("id") Integer id);

    @Select("update PayRecord set paymentBalance=#{paymentBalance},paymentWay=#{paymentWay},rechargeRemark=#{rechargeRemark}," +
            "rechargeIp=#{rechargeIp},rechargeTime=#{rechargeTime},#{user.uid} where pid=#{pid}")
    int update(PayRecord payRecord);

    @Select("insert into PayRecord values(#{id},{paymentBalance},#{paymentWay},#{rechargeRemark},#{rechargeIp},#{rechargeTime}," +
            "#{user.uid})")
    int insert(PayRecord payRecord);

    @Select("delete from PayRecord where pid=#{pid}")
    int del(@Param("pid")Integer pid);

    @Select("select count(*) from PayRecord")
    int count();
}
