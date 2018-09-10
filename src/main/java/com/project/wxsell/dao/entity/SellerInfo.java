package com.project.wxsell.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SellerInfo implements Serializable {

	private static final long serialVersionUID = -5148352633627195393L;

	@Id
	private String sellId;
	
	private String userName;
	
	private String password;
	
	private String openid;
}
