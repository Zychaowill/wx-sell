package com.project.wxsell.util.converter;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.project.wxsell.bean.dto.OrderDto;
import com.project.wxsell.bean.form.OrderForm;
import com.project.wxsell.dao.entity.OrderDetail;
import com.project.wxsell.enums.ResultEnum;
import com.project.wxsell.exception.WxSellException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderForm2OrderDtoConverter {

	@SuppressWarnings("serial")
	public static OrderDto convert(OrderForm orderForm) {
		OrderDto dto = new OrderDto();
		dto.setBuyerName(orderForm.getName());
		dto.setBuyerPhone(orderForm.getPhone());
		dto.setBuyerAddress(orderForm.getAddress());
		dto.setBuyerOpenid(orderForm.getOpenid());

		List<OrderDetail> orderDetailList = Lists.newArrayListWithCapacity(0);
		Gson gson = new Gson();
		try {
			orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
			}.getType());
		} catch (Exception ex) {
			log.error("【对象转化】错误，String={}", orderForm.getItems());
			throw new WxSellException(ResultEnum.PARAM_FORMAT_ERROR);
		}
		dto.setOrderDetailList(orderDetailList);
		return dto;
	}
}
