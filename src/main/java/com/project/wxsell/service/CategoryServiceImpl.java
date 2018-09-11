package com.project.wxsell.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.wxsell.dao.entity.ProductCategory;
import com.project.wxsell.dao.repository.ProductCategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Override
	public ProductCategory findOne(Integer categoryId) {
		return productCategoryRepository.findById(categoryId).orElse(null);
	}

	@Override
	public List<ProductCategory> findAll() {
		return productCategoryRepository.findAll();
	}

	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes) {
		return productCategoryRepository.findByCategoryTypeIn(categoryTypes);
	}

	@Override
	public ProductCategory save(ProductCategory productCategory) {
		return productCategoryRepository.save(productCategory);
	}

}
