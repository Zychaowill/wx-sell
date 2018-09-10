package com.project.wxsell.dao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.wxsell.dao.entity.OrderMaster;

@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
	
	Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
