package com.project.wxsell.dao.repository;

import com.project.wxsell.WxSellApplicationTests;
import com.project.wxsell.dao.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * Created by yachao on 2018/9/11.
 */
public class ProductCategoryRepositoryTest extends WxSellApplicationTests {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void testSave() throws Exception {
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(1);
        if (productCategory.isPresent()) {
            ProductCategory category = productCategory.get();
            category.setCategoryType(10);
            productCategoryRepository.save(category);
        }
    }
}
