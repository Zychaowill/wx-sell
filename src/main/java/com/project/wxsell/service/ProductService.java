package com.project.wxsell.service;

import java.util.List;

import com.project.wxsell.bean.dto.CartDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.wxsell.dao.entity.ProductInfo;

public interface ProductService {
	
	ProductInfo findOne(String productId);
	
	List<ProductInfo> findUpAll();
	
	Page<ProductInfo> findAll(Pageable pageable);
	
	ProductInfo save(ProductInfo productInfo);

	ProductInfo onSale(String productId);
	
	ProductInfo offSale(String productId);

	void increaseStock(List<CartDto> cartDtoList);

	void decreateStock(List<CartDto> cartDtoList);
}
