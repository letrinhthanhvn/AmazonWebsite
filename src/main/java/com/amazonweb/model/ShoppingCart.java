package com.amazonweb.model;

public class ShoppingCart {
	
	private Long id;
	
	private Integer userId;
	
	private Integer lastUpdate;
	
	private Integer totalPrice;
	
	private Integer statusId;
	
	private String shippingInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Integer lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(String shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
	
}
