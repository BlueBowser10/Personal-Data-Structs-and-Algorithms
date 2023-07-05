import java.util.NoSuchElementException;

/**
 * This is an interface that defines the operatiosn of a Singly Linked List ADT. It is to be implemented further using classes.
 * 
 * @param <T> the type that the list holds
 * @author BlueBowser
 */
interface SinglyLinkedList<T> {

    /** Gives the size of the LinkedList (the number of nodes it contains).
     * 
     * @return the size of the list.
     */
    public int size();

    /** Checks whether the LinkedList is empty or not.
     * 
     * @return a boolean: {@code true} if the list is empty and {@code false}
     * if it is not.
     */
    public boolean isEmpty();

    /**Adds an element to the head of the linked list, and shifts all elements
     * down by one.
     * 
     * @param elem the element to be added. Must not be null.
     * @throws IllegalArgumentException when the value passed is null
     */
    public void addFirst(T elem) throws IllegalArgumentException;

    /**
     * Adds an element to the tail of the linked lists, and shifts all the
     * elements up by one.
     * 
     * @param elem the element to be added. Must not be null.
     * @throws IllegalArgumentException when the value passed is null
     */
    public void addLast(T elem) throws IllegalArgumentException;

    /**
     * Reemoves the the item at the beginning of the list, if any exists,
     *  and returns it.
     * 
     * @return the first time that was removed from the beginning.
     * @throws NoSuchElementException when the list is empty
     */
    public T removeFirst() throws NoSuchElementException;

    /**
     * Returns the first element in the list.
     * @return the head element
     * @throws NoSuchElementException when the list is empty
     */
    public T first() throws NoSuchElementException;

    /**
     * Returns the last element in the list.
     * 
     * @return the tail element
     * @throws NoSuchElementException when the list is empty
     */
    public T last() throws NoSuchElementException;
}
