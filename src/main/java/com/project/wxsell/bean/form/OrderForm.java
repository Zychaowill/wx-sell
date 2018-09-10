package com.project.wxsell.bean.form;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class OrderForm {

	@NotEmpty(message = "buyer's name required")
	private String name;
	
	@NotEmpty(message = "buyer's phone required")
	private String phone;
	
	@NotEmpty(message = "buyer's address required")
	private String address;
	
	@NotEmpty(message = "buyer's openid required")
	private String openid;
	
	@NotEmpty(message = "cart cannot be empty")
	private String items;
}
