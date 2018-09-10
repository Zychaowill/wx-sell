package com.project.wxsell.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.wxsell.bean.dto.OrderDto;
import com.project.wxsell.dao.entity.OrderDetail;
import com.project.wxsell.dao.entity.OrderMaster;
import com.project.wxsell.dao.repository.OrderDetailRepository;
import com.project.wxsell.dao.repository.OrderMasterRepository;
import com.project.wxsell.enums.ResultEnum;
import com.project.wxsell.exception.WxSellException;
import com.project.wxsell.util.converter.OrderMaster2OrderDtoConverter;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMasterRepository orderMasterRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Override
	public OrderDto create(OrderDto orderDto) {
		return null;
	}

	@Override
	public OrderDto findOne(String orderId) {
		Optional<OrderMaster> orderMaster = orderMasterRepository.findById(orderId);
		if (!orderMaster.isPresent()) {
			throw new WxSellException(ResultEnum.ORDER_NOT_EXIST);
		}
		List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
		if (CollectionUtils.isEmpty(orderDetailList)) {
			throw new WxSellException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
		}
		OrderDto dto = new OrderDto();
		BeanUtils.copyProperties(orderMaster, dto);
		dto.setOrderDetailList(orderDetailList);
		return dto;
	}

	@Override
	public Page<OrderDto> findByBuyerOpenid(String buyerOpenid, Pageable pageable) {
		Page<OrderMaster> orderMasters = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);
		List<OrderDto> orderDtoList = OrderMaster2OrderDtoConverter.convert(orderMasters.getContent());
		return new PageImpl<>(orderDtoList, pageable, orderMasters.getTotalElements());
	}

	@Override
	public OrderDto cancel(OrderDto orderDto) {
		return null;
	}

	@Override
	public OrderDto finish(OrderDto orderDto) {
		return null;
	}

	@Override
	public OrderDto paied(OrderDto orderDto) {
		return null;
	}

	@Override
	public Page<OrderDto> list(Pageable pageable) {
		Page<OrderMaster> orderMasters = orderMasterRepository.findAll(pageable);
		List<OrderDto> orderDtoList = OrderMaster2OrderDtoConverter.convert(orderMasters.getContent());
		return new PageImpl<>(orderDtoList, pageable, orderMasters.getTotalElements());
	}

}
