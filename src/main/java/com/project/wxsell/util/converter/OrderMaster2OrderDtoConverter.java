package com.project.wxsell.util.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.project.wxsell.bean.dto.OrderDto;
import com.project.wxsell.dao.entity.OrderMaster;

public class OrderMaster2OrderDtoConverter {

	public static OrderDto convert(OrderMaster orderMaster) {
		OrderDto dto = new OrderDto();
		BeanUtils.copyProperties(orderMaster, dto);
		return dto;
	}
	
	public static List<OrderDto> convert(List<OrderMaster> orderMasters) {
		return orderMasters.stream().map(orderMaster -> convert(orderMaster)).collect(Collectors.toList());
	}
}
