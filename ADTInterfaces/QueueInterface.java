package ADTInterfaces;

import java.util.NoSuchElementException;

/**
 * An interface defining the operations of a Queue. It will
 * by a class.
 * @param <T> the type the queue holds
 * @author BlueBowser
 */
public interface QueueInterface<T> {
    /**
     * Gets the size of the queue
     * @return the size of the queue.
     */
    public int size();

    /**
     * Checks whether the LinkedList is empty or not.
     * 
     * @return a boolean: {@code true} if the list is empty and {@code false}
     * if it is not.
     */
    public boolean isEmpty();

    /**
     * Add an item to the back of the queue.
     * @param elem the item to be added to the back. Must not be null.
     * @throws IllegalArgumentException if the element is null
     */
    public void enqueue(T elem) throws IllegalArgumentException;

    /**
     * Remove item from the front of the queue and return it.
     * @return the front element of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() throws NoSuchElementException;

    /**
     * Gets the first item in the queue.
     * @return the first item in the queue.
     * @throws NoSuchElementException if the list is empty.
     */
    public T first() throws NoSuchElementException;
}
