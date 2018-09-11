package com.project.wxsell.service;

import com.project.wxsell.WxSellApplicationTests;
import com.project.wxsell.dao.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yachao on 2018/9/11.
 */
public class CategoryServiceImplTest extends WxSellApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(3, 10));
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("男生专属");
        productCategory.setCategoryType(3);
        ProductCategory category = categoryService.save(productCategory);
        Assert.assertNotNull(category);
    }

}