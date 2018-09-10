package com.project.wxsell.util;

import com.project.wxsell.enums.CodeEnum;

public class EnumUtil {

	public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
		T t = null;
		for (T each : enumClass.getEnumConstants()) {
			if (code.equals(each.getCode())) {
				t = each;
				break;
			}
		}
		return t;
	}
}
