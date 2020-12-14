package com.tool;

import com.alibaba.fastjson.JSON;

/**
 * 表单请求Json字符串
 * @author Wenz
 */
public class FormDataUtil {
	
	private String josnStr;

	public String getJosnStr() {
		return josnStr;
	}

	public void setJosnStr(String josnStr) {
		this.josnStr = josnStr;
	}

	public <T> T getFormEntity(Class<T> clazz) {
		return JSON.parseObject(this.josnStr, clazz);
	}
}
