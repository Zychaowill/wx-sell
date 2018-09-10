package com.project.wxsell.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.wxsell.bean.dto.OrderDto;

public interface OrderService {

	OrderDto create(OrderDto orderDto);
	
	OrderDto findOne(String orderId);
	
	Page<OrderDto> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
	
	OrderDto cancel(OrderDto orderDto);
	
	OrderDto finish(OrderDto orderDto);
	
	OrderDto paied(OrderDto orderDto);
	
	Page<OrderDto> list(Pageable pageable);
}
