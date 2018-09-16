package com.project.wxsell.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.project.wxsell.bean.dto.CartDto;
import com.project.wxsell.dao.entity.ProductInfo;
import com.project.wxsell.dao.repository.ProductInfoRepository;
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

	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Autowired
	private ProductService productService;
	
	@Override
	public OrderDto create(OrderDto orderDto) {
		BigDecimal orderAmount = new BigDecimal(0.0);

		// 1.query product (quantity, price)
		for (OrderDetail orderDetail : orderDto.getOrderDetailList()) {
			ProductInfo productInfo = productInfoRepository.findById(orderDetail.getProductId()).orElse(null);
			if (Objects.isNull(productInfo)) {
				throw new WxSellException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			// 2.calculate total of cost
			orderAmount = orderDetail.getProductPrice()
					.multiply(new BigDecimal(orderDetail.getProductQuantity()))
					.add(orderAmount);
		}
		// 3.write order into DB (order_master, order_detail)
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setOrderId(orderDto.getOrderId());
		orderMaster.setOrderAmount(orderAmount);
		BeanUtils.copyProperties(orderDto, orderMaster);
		OrderMaster returnOrderMaster = orderMasterRepository.save(orderMaster);

		// 4.decrease stock of product
		List<CartDto> cartDtoList = orderDto.getOrderDetailList()
				.stream()
				.map(orderDetail -> new CartDto(orderDetail.getProductId(), orderDetail.getProductQuantity()))
				.collect(Collectors.toList());
		productService.decreateStock(cartDtoList);
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
