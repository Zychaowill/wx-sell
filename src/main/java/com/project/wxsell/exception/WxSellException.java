package com.project.wxsell.exception;

import com.project.wxsell.enums.ResultEnum;

public class WxSellException extends RuntimeException {

	private static final long serialVersionUID = -1386053024635304117L;
	
	private Integer code;
	
	public WxSellException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
	
	public WxSellException(Integer code, String message) {
		super(message);
		this.code = code;
	}
}
