package com.project.order.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    @Test
    void constructorAndGetters_ShouldReturnCorrectValues() {
        // Arrange
        int id          = 10;
        String name     = "The Food Place";
        String address  = "123 Flavor St";
        String city     = "Gourmet City";
        String desc     = "A place for delicious meals";

        // Act
        Restaurant r = new Restaurant(id, name, address, city, desc);

        // Assert
        assertEquals(id,   r.getId());
        assertEquals(name, r.getName());
        assertEquals(address, r.getAddress());
        assertEquals(city, r.getCity());
        assertEquals(desc, r.getRestaurantDescription());
    }

    @Test
    void setters_ShouldUpdateValuesCorrectly() {
        // Arrange
        Restaurant r = new Restaurant();

        // Act
        r.setId(20);
        r.setName("Cafe Delight");
        r.setAddress("456 Tasty Ave");
        r.setCity("Flavor Town");
        r.setRestaurantDescription("Cozy spot for coffee and treats");

        // Assert
        assertEquals(20,   r.getId());
        assertEquals("Cafe Delight", r.getName());
        assertEquals("456 Tasty Ave", r.getAddress());
        assertEquals("Flavor Town", r.getCity());
        assertEquals("Cozy spot for coffee and treats", r.getRestaurantDescription());
    }

    @Test
    void defaultConstructor_ShouldInitializeDefaults() {
        // Act
        Restaurant r = new Restaurant();

        // Assert
        assertEquals(0, r.getId());
        assertNull(r.getName());
        assertNull(r.getAddress());
        assertNull(r.getCity());
        assertNull(r.getRestaurantDescription());
    }
}
