package com.amazonweb.model;

public class Product {

	private Long id;

	private int catalogId;

	private String name;

	private double price;

	private String description;

	private int discount;

	private String imageList;

	private int created;

	private int quantity_limit;
	
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity_limit() {
		return quantity_limit;
	}

	public void setQuantity_limit(int quantity_limit) {
		this.quantity_limit = quantity_limit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getImageList() {
		return imageList;
	}

	public void setImageList(String imageList) {
		this.imageList = imageList;
	}

	public int getCreated() {
		return created;
	}

	public void setCreated(int time) {
		this.created = time;
	}

}
