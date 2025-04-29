package com.project.order.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodItemsDTOTest {

    @Test
    void constructorAndGetters_ShouldReturnCorrectValues() {
        // Arrange
        int id            = 101;
        String name       = "Paneer Tikka";
        String desc       = "Spicy grilled paneer cubes";
        boolean veg       = true;
        Long price        = 250L;
        Integer restId    = 5;
        Integer quantity  = 2;

        // Act
        FoodItemsDTO dto = new FoodItemsDTO(
                id, name, desc, veg, price, restId, quantity
        );

        // Assert
        assertEquals(id,           dto.getId());
        assertEquals(name,         dto.getItemName());
        assertEquals(desc,         dto.getItemDescription());
        assertTrue(dto.isVeg());
        assertEquals(price,        dto.getPrice());
        assertEquals(restId,       dto.getRestaurantId());
        assertEquals(quantity,     dto.getQuantity());
    }

    @Test
    void setters_ShouldUpdateValuesCorrectly() {
        // Arrange
        FoodItemsDTO dto = new FoodItemsDTO();

        // Act
        dto.setId(202);
        dto.setItemName("Chicken Curry");
        dto.setItemDescription("Rich and creamy");
        dto.setVeg(false);
        dto.setPrice(300L);
        dto.setRestaurantId(7);
        dto.setQuantity(4);

        // Assert
        assertEquals(202,          dto.getId());
        assertEquals("Chicken Curry", dto.getItemName());
        assertEquals("Rich and creamy", dto.getItemDescription());
        assertFalse(dto.isVeg());
        assertEquals(300L,         dto.getPrice());
        assertEquals(7,            dto.getRestaurantId());
        assertEquals(4,            dto.getQuantity());
    }

    @Test
    void defaultConstructor_ShouldInitializeDefaults() {
        // Act
        FoodItemsDTO dto = new FoodItemsDTO();

        // Assert
        assertEquals(0,            dto.getId());
        assertNull(dto.getItemName());
        assertNull(dto.getItemDescription());
        assertFalse(dto.isVeg());
        assertNull(dto.getPrice());
        assertNull(dto.getRestaurantId());
        assertNull(dto.getQuantity());
    }
}
