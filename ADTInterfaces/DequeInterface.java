package ADTInterfaces;

import java.util.NoSuchElementException;

/**
 * This is an interface describing the operations of a DEQue. It will be
 * implemented later by a class.
 * @param <T> the type the deque holds
 * @author BlueBowser
 */
public interface DequeInterface<T> {
    /**
     * Returns the size of the list.
     * @return the sizse of the list
     */
    public int size();

    /**
     * Checks whether the list is empty.
     * @return a boolean: {@code true} if it is empty, {@code false} otherwise
     */
    public boolean isEmpty();

    /**
     * Adds an element to the front of the Deque
     * @param elem the element to be added. Must not be null.
     * @throws IllegalArgumentException if the element entered is null.
     */
    public void pushFront(T elem) throws IllegalArgumentException;

    /**
     * Adds an element to the back of the Deque
     * @param elem the element to be added. Must not be null.
     * @throws IllegalArgumentException if the element entered is null.
     */
    public void pushBack(T elem) throws IllegalArgumentException;

    /**
     * Removes the element from the front of the Deque and returns it.
     * @return the front element of the Deque
     * @throws NoSuchElementException if the queue is empty
     */
    public T popFront() throws NoSuchElementException;

    /**
     * REmoves the element from the back of the Deque and returns it.
     * @return the back element of the Deque
     * @throws NoSuchElementException if the queue is empty
     */
    public T popBack() throws NoSuchElementException;

    /**
     * Returns first element in the Deque
     * @return the first element
     * @throws NoSuchElementException if the queue is empty.
     */
    public T first() throws NoSuchElementException;

    /**
     * Returns the last element in the Deque
     * @return the last element
     * @throws NoSuchElementException if the queue is empty
     */
    public T last() throws NoSuchElementException;
}
