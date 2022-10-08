package ru.msu.math.mmalgo.intstack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasicOperationsTests {

    @Test
    @DisplayName("Test stack construction")
    public void testStackConstruction() {
        final IntStack[] intStack = {new IntStack()};
        assertEquals(16, intStack[0].getCapacity(), "Default capacity is wrong");

        intStack[0] = new IntStack(15);
        assertEquals(16, intStack[0].getCapacity(), "Default capacity is wrong");

        assertThrows(IllegalArgumentException.class, () -> new IntStack(0));

        assertThrows(IllegalArgumentException.class, () -> new IntStack(-10));
    }

    @Test
    @DisplayName("Test push and pop")
    public void testPopAndPush() {
        IntStack intStack = new IntStack();

        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        assertDoesNotThrow(() -> assertEquals(3, intStack.pop(), "Invalid value on top the stack"));

        assertDoesNotThrow(() -> assertEquals(2, intStack.pop(), "Invalid value on top the stack"));

        assertDoesNotThrow(() -> assertEquals(1, intStack.pop(), "Invalid value on top the stack"));
    }

    @Test
    @DisplayName("Test pop on empty stack")
    public void testPopOnEmptyStack() {
        IntStack intStack = new IntStack();

        assertThrows(StackUnderflowException.class, intStack::pop);
    }
}
