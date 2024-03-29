package com.eve.entity;

public class Dish {

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column TM_DISH.ID
	 *
	 * @mbg.generated
	 */
	private Long id;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column TM_DISH.NAME
	 *
	 * @mbg.generated
	 */
	private String name;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column TM_DISH.DESCRIPTION
	 *
	 * @mbg.generated
	 */
	private String description;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column TM_DISH.DISH_TYPE_ID
	 *
	 * @mbg.generated
	 */
	private Long dishTypeId;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column TM_DISH.PRICE
	 *
	 * @mbg.generated
	 */
	private Double price;

	/**
	 * This method returns the value of the database column TM_DISH.ID
	 *
	 * @return the value of TM_DISH.ID
	 *
	 * @mbg.generated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column TM_DISH.NAME
	 *
	 * @return the value of TM_DISH.NAME
	 *
	 * @mbg.generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column TM_DISH.DESCRIPTION
	 *
	 * @return the value of TM_DISH.DESCRIPTION
	 *
	 * @mbg.generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column TM_DISH.DISH_TYPE_ID
	 *
	 * @return the value of TM_DISH.DISH_TYPE_ID
	 *
	 * @mbg.generated
	 */
	public Long getDishTypeId() {
		return dishTypeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column TM_DISH.PRICE
	 *
	 * @return the value of TM_DISH.PRICE
	 *
	 * @mbg.generated
	 */
	public Double getPrice() {
		return price;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public void setDishTypeId(Long dishTypeId) {
		this.dishTypeId = dishTypeId;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}