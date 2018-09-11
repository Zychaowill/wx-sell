package com.project.wxsell.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.project.wxsell.enums.ProductStatusEnum;
import com.project.wxsell.enums.ResultEnum;
import com.project.wxsell.exception.WxSellException;
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
	
	@Override
	public ProductInfo findOne(String productId) {
		return productInfoRepository.findById(productId).orElse(null);
	}

	@Override
	public List<ProductInfo> findUpAll() {
		return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

	@Override
	public Page<ProductInfo> findAll(Pageable pageable) {
		return productInfoRepository.findAll(pageable);
	}

	@Override
	public ProductInfo save(ProductInfo productInfo) {
		return productInfoRepository.save(productInfo);
	}

	@Override
	public ProductInfo onSale(String productId) {
		ProductInfo productInfo = productInfoRepository.findById(productId).orElse(null);
		if (Objects.isNull(productInfo)) {
			throw new WxSellException(ResultEnum.PRODUCT_NOT_EXIST);
		}
		if (productInfo.productStatusEnum() == ProductStatusEnum.UP) {
			throw new WxSellException(ResultEnum.PRODUCT_STATUS_ERROR);
		}
		productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
		return productInfoRepository.save(productInfo);
	}

	@Override
	public ProductInfo offSale(String productId) {
		ProductInfo productInfo = productInfoRepository.findById(productId).orElse(null);
		if (Objects.isNull(productInfo)) {
			throw new WxSellException(ResultEnum.PRODUCT_NOT_EXIST);
		}
		if (productInfo.productStatusEnum() == ProductStatusEnum.DOWN) {
			throw new WxSellException(ResultEnum.PRODUCT_STATUS_ERROR);
		}
		productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
		return productInfoRepository.save(productInfo);
	}

}
