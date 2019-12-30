package com.eve.dto;

public class DishDto {

	private Long id;

	private String name;

	private String description;

	private Long dishTypeId;

	private Double price;

	private String typeName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDishTypeId() {
		return dishTypeId;
	}

	public void setDishTypeId(Long dishTypeId) {
		this.dishTypeId = dishTypeId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
