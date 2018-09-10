package com.project.wxsell.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.wxsell.enums.ProductStatusEnum;
import com.project.wxsell.util.EnumUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class ProductInfo implements Serializable {

	private static final long serialVersionUID = 4998703594977981362L;

	@Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
    
    @JsonIgnore
    public ProductStatusEnum productStatusEnum() {
    	return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
