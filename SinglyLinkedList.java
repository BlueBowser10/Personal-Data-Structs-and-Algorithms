/**This is an interface that defines the operatiosn of a Singly Linked List ADT. IT is to be implemented further using classes.
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
     * @param elem the element to be added
     */
    public void addFirst(T elem);

    /**Adds an elemet to the tail of the linked lists,and shifts all the
     * elements up by one.
     * 
     * @param elem the element to be added
     */
    public void addLast(T elem);

    /**
     * Reemoves the the item at the beginning of the list, if any exists
     * @return the first time that was removed from the beginning.
     * @throws IndexOutOfBoundsException when the list is empty
     */
    public T removeFirst() throws IndexOutOfBoundsException;

    /**
     * Returns the first element in the list.
     * @return the head element
     * @throws IndexOutOfBoundsException when the list is empty
     */
    public T first() throws IndexOutOfBoundsException;

    /**
     * Returns the last element in the list.
     * @return the tail element
     * @throws IndexOutOfBoundsException when the list is empty
     */
    public T last() throws IndexOutOfBoundsException;
}
