package com.project.wxsell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
	ORDER_NOT_EXIST(100101, "订单不存在"),
	ORDER_DETAIL_NOT_EXIST(100102, "订单详情不存在")
	;
	
	private Integer code;
	
	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
