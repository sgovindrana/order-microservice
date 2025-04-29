package com.project.order.controller;

import com.project.order.dto.OrderDTO;
import com.project.order.dto.OrderDTOFromFE;
import com.project.order.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveOrder_shouldReturnCreatedStatus() {
        // Arrange
        OrderDTOFromFE orderDetails = new OrderDTOFromFE();
        OrderDTO orderSavedInDB = new OrderDTO();
        when(orderService.saveOrderInDb(orderDetails)).thenReturn(orderSavedInDB);

        // Act
        ResponseEntity<OrderDTO> response = orderController.saveOrder(orderDetails);

        // Assert
        verify(orderService, times(1)).saveOrderInDb(orderDetails);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(orderSavedInDB, response.getBody());
    }
    @Test
    void saveOrder_whenServiceThrowsException_shouldPropagate() {
        // Arrange
        OrderDTOFromFE orderDetails = new OrderDTOFromFE();
        when(orderService.saveOrderInDb(orderDetails))
                .thenThrow(new RuntimeException("DB failure"));

        // Act & Assert
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            orderController.saveOrder(orderDetails);
        });
        assertEquals("DB failure", ex.getMessage());
        verify(orderService, times(1)).saveOrderInDb(orderDetails);
    }

}