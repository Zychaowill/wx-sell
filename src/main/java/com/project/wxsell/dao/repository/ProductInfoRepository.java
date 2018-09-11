package com.project.wxsell.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.wxsell.dao.entity.ProductInfo;

import java.util.List;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
