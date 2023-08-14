package ADTInterfaces;
import java.lang.IndexOutOfBoundsException;

/**
 * This is an inteface for the methods of a simple List ADT. The List
 * index starts at {@code 0}
 * @param <T> the type the list holds
 * @author BlueBowser
 * @see LinearDataStructures.ItemList
 */
public interface ListInterface<T> {
    /**
     * Returns the size of the list.
     * 
     * @return the size of the list.
     */
    public int size();

    /**
     * Checks if the list is empty.
     * @return a boolean: true if the List is empty, and false if it is not
     */
    public boolean isEmpty();

    /**
     * Gets the ith element of the list
     * @param i the index of the elemtn in the list
     * @return the element at that index
     * @throws IndexOutOfBoundsException if the index of the list is less than 0
     * or greater than the List's size minus one.
     */
    public T get(int i) throws IndexOutOfBoundsException;
    
    /**
     * Sets the ith element to a newer element
     * @param i the ith element in the list
     * @param elem the new element to replace the old element with.
     *  Must not be null.
     * @throws IllegalArgumentException if the element passed is null.
     * @throws IndexOutOfBoundsException if the index of the list is less than 0
     * or greater than the List's size.
     */
    public void set(int i, T elem) throws IllegalArgumentException, IndexOutOfBoundsException;

    /**
     * Adds a new element to the ith position, and shifts all the elements
     *  after i up by one.
     * @param i the ith element in the list
     * @param elem the new element to add
     *  Must not be null.
     * @throws IllegalArgumentException if the element passed is null.
     * @throws IndexOutOfBoundsException if the index of the list is less than 0
     * or greater than the List's size.
     */
    public void add(int i, T elem) throws IllegalArgumentException, IndexOutOfBoundsException;

    /**
     * Adds a new element to the back of the list.
     * @param elem the new element to add
     *  Must not be null.
     * @throws IllegalArgumentException if the element passed is null.
     * @throws IndexOutOfBoundsException if the index of the list is less than 0
     * or greater than the List's size.
     */
    public void add(T elem) throws IllegalArgumentException, IndexOutOfBoundsException;

    /**
     * Removes an the ith position, and shifts all the elements
     *  after i down by one.
     * @param i the ith element in the list
     * @return the elem at that index
     * @throws IndexOutOfBoundsException if the index of the list is less than 0
     * or greater than the List's size, or the list is empty
     */
    public T remove(int i) throws IndexOutOfBoundsException;
}