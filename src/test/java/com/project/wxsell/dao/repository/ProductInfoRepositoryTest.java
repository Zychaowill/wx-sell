package com.project.wxsell.dao.repository;

import com.project.wxsell.WxSellApplicationTests;
import com.project.wxsell.dao.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Created by yachao on 2018/9/11.
 */
public class ProductInfoRepositoryTest extends WxSellApplicationTests {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("sugar");
        productInfo.setProductPrice(new BigDecimal(2.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("sweet");
        productInfo.setProductIcon("https://www.baidu.com");
        productInfo.setCategoryType(10);

        ProductInfo result = productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() throws Exception {

    }

}