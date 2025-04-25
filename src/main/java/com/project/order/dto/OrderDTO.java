package com.project.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderDTO {

    private Integer orderId;

    @JsonProperty("foodItemsList")      // <- matches JSON key
    private List<FoodItemsDTO> foodItemsList;

    private Restaurant restaurant;

    @JsonProperty("userDTO")
    private UserDTO userDTO;

    public OrderDTO(Integer orderId, List<FoodItemsDTO> foodItemsList, Restaurant restaurant, UserDTO userDTO) {
        this.orderId = orderId;
        this.foodItemsList = foodItemsList;
        this.restaurant = restaurant;
        this.userDTO = userDTO;
    }

    public OrderDTO() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<FoodItemsDTO> getFoodItemsList() {
        return foodItemsList;
    }

    public void setFoodItemsList(List<FoodItemsDTO> foodItemsList) {
        this.foodItemsList = foodItemsList;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
