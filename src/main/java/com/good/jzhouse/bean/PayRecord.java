package com.good.jzhouse.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
public class PayRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    private	Integer	paymentBalance; //支付金额	不能为空
    private String paymentWay;	//支付方式	不能为空
    private String rechargeRemark;	//备注	不能为空
    private String rechargeIp;	//充值ip	不能为空
    private Timestamp rechargeTime;	//充值时间	不能为空	Timestamp
    @ManyToOne(cascade= CascadeType.REMOVE,optional=true)
    private Users user;	//用户id	用户外键，不能为空

}
