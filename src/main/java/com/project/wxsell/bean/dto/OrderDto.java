package com.project.wxsell.bean.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.wxsell.dao.entity.OrderDetail;
import com.project.wxsell.enums.OrderStatusEnum;
import com.project.wxsell.enums.PayStatusEnum;
import com.project.wxsell.util.EnumUtil;
import com.project.wxsell.util.serializer.Date2LongSerializer;

import lombok.Data;

@Data
public class OrderDto {

	private String orderId;
	
	private String buyerName;
	
	private String buyerPhone;
	
	private String buyerAddress;
	
	private String buyerOpenid;
	
	private BigDecimal orderAmount;
	
	private Integer orderStatus;
	
	private Integer payStatus;
	
	@JsonSerialize(using = Date2LongSerializer.class)
	private Date createTime;
	
	@JsonSerialize(using = Date2LongSerializer.class)
	private Date updateTime;
	
	List<OrderDetail> orderDetailList;
	
	public OrderStatusEnum orderStatusEnum() {
		return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
	}
	
	public PayStatusEnum payStatusEnum() {
		return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
	}
}
