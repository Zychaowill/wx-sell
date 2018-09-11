package com.project.wxsell.dao.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "order_master")
@DynamicUpdate
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = -7678679361695381797L;

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    private Date createTime;

    private Date updateTime;
}
