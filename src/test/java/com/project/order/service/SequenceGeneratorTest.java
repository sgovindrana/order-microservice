package com.project.order.service;

import com.project.order.entity.Sequence;
import com.project.order.service.SequenceGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class SequenceGeneratorTest {

    @InjectMocks
    private SequenceGenerator sequenceGenerator;

    @Mock
    private MongoOperations mongoOperations;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerateNextOrderId_ReturnsNextSequenceValue() {
        // Arrange
        Sequence seq = new Sequence();
        seq.setSequence(42);
        when(mongoOperations.findAndModify(
                any(Query.class),
                any(Update.class),
                any(FindAndModifyOptions.class),
                eq(Sequence.class)
        )).thenReturn(seq);

        // Act
        int result = sequenceGenerator.generateNextOrderId();

        // Assert
        assertEquals(42, result);
        verify(mongoOperations, times(1)).findAndModify(
                any(Query.class), any(Update.class), any(FindAndModifyOptions.class), eq(Sequence.class)
        );
    }

    @Test
    public void testGenerateNextOrderId_WhenNoSequence_ThrowsNullPointerException() {
        // Arrange: simulate no document found
        when(mongoOperations.findAndModify(
                any(Query.class), any(Update.class), any(FindAndModifyOptions.class), eq(Sequence.class)
        )).thenReturn(null);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> sequenceGenerator.generateNextOrderId());
        verify(mongoOperations, times(1)).findAndModify(
                any(Query.class), any(Update.class), any(FindAndModifyOptions.class), eq(Sequence.class)
        );
    }
}
