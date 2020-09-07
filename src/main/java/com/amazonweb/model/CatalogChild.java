package com.amazonweb.model;

import java.util.Date;

public class CatalogChild {
	private long id;

	private String name;

	private Integer catalogParentId;

	private Integer lastUpdate;

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCatalogParentId() {
		return catalogParentId;
	}

	public void setCatalogParentId(int catalogParentId) {
		this.catalogParentId = catalogParentId;
	}

	public Integer getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(int lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
