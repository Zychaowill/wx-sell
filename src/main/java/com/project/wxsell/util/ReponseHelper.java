package com.project.wxsell.util;

import com.project.wxsell.bean.bo.JsonEntity;
import com.project.wxsell.enums.ResultEnum;

public class ReponseHelper {

	public static <T> JsonEntity<T> of(T data) {
		return createInstance(data);
	}
	
	public static <T> JsonEntity<T> createInstance(T data) {
		JsonEntity<T> jsonEntity = new JsonEntity<>(data);
		jsonEntity.setRequestId(null);
		return jsonEntity;
	}
	
	public static <T> JsonEntity<T> ofNothing() {
		return createInstance(null);
	}
	
	@SuppressWarnings("rawtypes")
	public static JsonEntity withMessage(ResultEnum resultEnum) {
		return new JsonEntity<>(resultEnum);
	}
}
