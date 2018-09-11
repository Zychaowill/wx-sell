package com.project.wxsell.dao.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "product_category")
@DynamicUpdate
public class ProductCategory implements Serializable {

	private static final long serialVersionUID = 224886609450647373L;

	@Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

	@Column(name = "category_name")
    private String categoryName;

	@Column(name = "category_type")
    private Integer categoryType;

	@Column(name = "create_time")
    private Date createTime;

	@Column(name = "update_time")
    private Date updateTime;

    public ProductCategory() {}

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
