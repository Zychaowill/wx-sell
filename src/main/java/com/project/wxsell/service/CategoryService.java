package com.project.wxsell.service;

import java.util.List;

import com.project.wxsell.dao.entity.ProductCategory;

public interface CategoryService {

	ProductCategory findOne(Integer categoryId);
	
	List<ProductCategory> findAll();
	
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);
	
	ProductCategory save(ProductCategory productCategory);
}
