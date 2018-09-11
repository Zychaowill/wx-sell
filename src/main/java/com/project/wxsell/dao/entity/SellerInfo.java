package com.project.wxsell.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@Table(name = "seller_info")
@DynamicUpdate
public class SellerInfo implements Serializable {

	private static final long serialVersionUID = -5148352633627195393L;

	@Id
	@Column(name = "sell_id")
	private String sellId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "openid")
	private String openid;
}
