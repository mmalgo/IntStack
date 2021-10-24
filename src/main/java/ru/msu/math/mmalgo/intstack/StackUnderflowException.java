package ru.msu.math.mmalgo.intstack;

/**
 * Exception thrown when pop is attempted on an empty stack
 */
public class StackUnderflowException extends Exception {


    public StackUnderflowException() {
        super("Stack is empty");
    }
}
