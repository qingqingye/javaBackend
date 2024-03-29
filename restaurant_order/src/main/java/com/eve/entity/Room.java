package com.eve.entity;

public class Room {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TM_ROOM.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TM_ROOM.NAME
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TM_ROOM.MIN_PRICE
     *
     * @mbg.generated
     */
    private Double minPrice;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TM_ROOM.ID
     *
     * @return the value of TM_ROOM.ID
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TM_ROOM.ID
     *
     * @param id the value for TM_ROOM.ID
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TM_ROOM.NAME
     *
     * @return the value of TM_ROOM.NAME
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TM_ROOM.NAME
     *
     * @param name the value for TM_ROOM.NAME
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TM_ROOM.MIN_PRICE
     *
     * @return the value of TM_ROOM.MIN_PRICE
     *
     * @mbg.generated
     */
    public Double getMinPrice() {
        return minPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TM_ROOM.MIN_PRICE
     *
     * @param minPrice the value for TM_ROOM.MIN_PRICE
     *
     * @mbg.generated
     */
    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

}