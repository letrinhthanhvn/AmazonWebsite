package com.amazonweb.utils;

import java.util.List;

public class MessageUtil<T> {
	private String message;
	private List<T> data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
