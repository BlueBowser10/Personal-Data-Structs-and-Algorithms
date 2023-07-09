package ADTInterfaces;

import java.util.NoSuchElementException;

/**
 * An interface that defines the operations of a Stack. To be
 * implemented later with a class.
 * @param <T> the type the stack holds
 * @author BlueBowser
 */
public interface StackInterface<T> {

    /**
     * Returns the number of elements in the Stack.
     * @return the number of elements in the stack.
     */
    public int size();

    /**
     * Checks whether the stack is empty or not.
     * @return a boolean: {@code true} if the list is empty and {@code false}
     * otherwise.
     */
    public boolean isEmpty();
    
    /**
     * Places an element on the top of a Stack.
     * @param elem the element to be pushed to the stack. Must not be null.
     * @throws IllegalArgumentException when the element passed is null
     */
    public void push(T elem) throws IllegalArgumentException;

    /**
     * Removes the top element on the Stack.
     * @return the elemement on top of the stack.
     * @throws NoSuchElementException if the list is empty
     */
    public T pop() throws NoSuchElementException;

    /**
     * Looks at the top element on the stack.
     * @return the top element on the stack
     * @throws NoSuchElementException if the list is empty
     */
    public T top() throws NoSuchElementException;
}
