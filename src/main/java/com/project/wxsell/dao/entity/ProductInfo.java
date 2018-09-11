package com.project.wxsell.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.wxsell.enums.ProductStatusEnum;
import com.project.wxsell.util.EnumUtil;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "product_info")
@DynamicUpdate
public class ProductInfo implements Serializable {

	private static final long serialVersionUID = 4998703594977981362L;

	@Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "product_stock")
    private Integer productStock;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_icon")
    private String productIcon;

    @Column(name = "product_status")
    private Integer productStatus;

    @Column(name = "category_type")
    private Integer categoryType;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
    
    @JsonIgnore
    public ProductStatusEnum productStatusEnum() {
    	return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
