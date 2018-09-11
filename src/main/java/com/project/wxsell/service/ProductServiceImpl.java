package com.project.wxsell.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.wxsell.dao.entity.ProductInfo;
import com.project.wxsell.dao.repository.ProductCategoryRepository;
import com.project.wxsell.dao.repository.ProductInfoRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Override
	public ProductInfo findOne(String productId) {
		return null;
	}

	@Override
	public List<ProductInfo> findUpAll() {
		return null;
	}

	@Override
	public Page<ProductInfo> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public ProductInfo save(ProductInfo productInfo) {
		return null;
	}

	@Override
	public ProductInfo onSale(String productId) {
		return null;
	}

	@Override
	public ProductInfo offSale(String productId) {
		return null;
	}

}
