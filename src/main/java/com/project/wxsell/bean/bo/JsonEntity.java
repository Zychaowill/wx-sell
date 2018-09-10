package com.project.wxsell.bean.bo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.wxsell.enums.ResultEnum;

public class JsonEntity<T> implements Serializable {

	private static final long serialVersionUID = -6613148896500714261L;

	private String requestId;
	
	private Integer code = 200;
	
	private String message;
	
	private T data;
	
	public JsonEntity() {
		super();
	}
	
	public JsonEntity(T data) {
		super();
		this.data = data;
	}

	public JsonEntity(ResultEnum resultEnum) {
		super();
		this.code = resultEnum.getCode();
		this.message = resultEnum.getMessage();
	}

	@JsonIgnore
	public boolean normal() {
		return code == 200;
	}
	
	public String getRequestId() {
		return requestId;
	}

	public JsonEntity<T> setRequestId(String requestId) {
		this.requestId = requestId;
		return this;
	}

	public Integer getCode() {
		return code;
	}

	public JsonEntity<T> setCode(Integer code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public JsonEntity<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getData() {
		return data;
	}

	public JsonEntity<T> setData(T data) {
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return "{requestId:" + requestId + ", code:" + code + ", message:" + message + ", data:" + data + "}";
	}
}
