package ru.msu.math.mmalgo.intstack;

/**
 * This class implements stack of primitive integers
 */
public class IntStack {

    private static final int DEFAULT_CAPACITY = 16;

    // array with actual stack values
    private int[] values;

    // index of the top element. -1 when empty
    private int top = -1;

    private final int minimumCapacity;

    /**
     * Constructs a stack with provided capacity
     */
    public IntStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Initial capacity should be greater than zero");

        // set minimum capacity to the next power of 2
        this.minimumCapacity = 2 << (31 - Integer.numberOfLeadingZeros(capacity - 1));

        values = new int[minimumCapacity];
    }

    /**
     * Constructs a stack with default capacity of {@value #DEFAULT_CAPACITY}
     */
    public IntStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Push value on top of this stack
     * @param value value to push
     */
    public void push(int value) {
        resizeIfNeeded();

        values[++top] = value;
    }

    /**
     * Pops value from this stack
     * @return top value from this stack
     * @throws StackUnderflowException thrown when this stack is empty
     */
    public int pop() throws StackUnderflowException {
        // throw exception if stack is empty
        if (top == -1) throw new StackUnderflowException();

        resizeIfNeeded();

        // return top element and decrement top pointer
        return values[top--];
    }

    /**
     * Get actual size of this stack
     * @return size of this stack
     */
    public int size() {
        return top + 1;
    }

    /**
     * Get stack capacity
     * @return current stack capacity
     */
    public int getCapacity() {
        return values.length;
    }

    private void resizeIfNeeded() {
        // check if we need to extend the array
        if (top == values.length - 1) {
            resize(values.length * 2);
        }

        // check if we need to shrink the array
        if ((top <= values.length / 4) && (values.length > minimumCapacity)) {
            resize(values.length / 2);
        }
    }

    private void resize(int newSize) {
        int[] newValues = new int[newSize];

        //noinspection ManualArrayCopy
        for (int i = 0; i <= top; i++) newValues[i] = values[i];

        values = newValues;
    }
}
