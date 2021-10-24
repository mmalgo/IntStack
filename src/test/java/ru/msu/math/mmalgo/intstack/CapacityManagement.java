package ru.msu.math.mmalgo.intstack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapacityManagement {

    @Test
    @DisplayName("Test array extension")
    public void testArrayExtension() {
        IntStack intStack = new IntStack(3);
        assertEquals(4, intStack.getCapacity(), "Default capacity is wrong");

        // push 4 elements
        for (var i = 0; i <= 3; i++) intStack.push(i);

        assertEquals(4, intStack.size(), "Size is wrong");
        assertEquals(4, intStack.getCapacity(), "Capacity is wrong");

        // push one more
        intStack.push(4);
        assertEquals(5, intStack.size(), "Size is wrong");
        assertEquals(8, intStack.getCapacity(), "Capacity is wrong");
    }

    @Test
    @DisplayName("Test array shrink")
    public void testArrayShrink() {
        IntStack intStack = new IntStack(3);
        assertEquals(4, intStack.getCapacity(), "Default capacity is wrong");

        // push 17 elements
        for (var i = 0; i <= 16; i++) intStack.push(i);

        assertEquals(17, intStack.size(), "Size is wrong");
        assertEquals(32, intStack.getCapacity(), "Capacity is wrong");

        // pop 9 elements
        for (var i = 0; i <= 8; i++) assertDoesNotThrow((Executable) intStack::pop);

        assertEquals(8, intStack.size(), "Size is wrong");
        assertEquals(16, intStack.getCapacity(), "Capacity is wrong");

        // pop 4 elements
        for (var i = 0; i <= 3; i++) assertDoesNotThrow((Executable) intStack::pop);

        assertEquals(4, intStack.size(), "Size is wrong");
        assertEquals(8, intStack.getCapacity(), "Capacity is wrong");

        // pop 2 elements
        for (var i = 0; i <= 1; i++) assertDoesNotThrow((Executable) intStack::pop);

        assertEquals(2, intStack.size(), "Size is wrong");
        assertEquals(4, intStack.getCapacity(), "Capacity is wrong");

        // pop 1 element and check we do not shrink below minimum capacity
        assertDoesNotThrow((Executable) intStack::pop);

        assertEquals(1, intStack.size(), "Size is wrong");
        assertEquals(4, intStack.getCapacity(), "Capacity is wrong");
    }


}
