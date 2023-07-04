/** This class implements a Deque ADT, a more general version of a Queue that
 * can add and remove elements from the front as well as the back. It uses the
 * DoublyLinkedList as the backbone.
 * @param <T> the type that the Deque holds
 * @author BlueBowser
 */
public class Deque<T> {
    /** The Doubly Linekd List that will hold the Deque data.*/
    private DoublyLinkedList<T> list;

    /** Default constructor that creates an empty Deque. */
    public Deque() {
        list = new DoublyLinkedList<>();
    }

    /**
     * Returns the size of the list
     * @return the sizse of the list
     */
    public int size() {
        return this.list.size();
    }

    /**
     * Checks whether the list is empty.
     * @return a boolean: {@code true} if it is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    /**
     * Adds an element to the front of the Deque
     * @param elem the element to be added
     */
    public void pushFront(T elem) {
        this.list.addFirst(elem);
    }

    /**
     * Adds an element to the back of the Deque
     * @param elem the element to be added
     */
    public void pushBack(T elem) {
        this.list.addLast(elem);
    }

    /**
     * Removes the element from the front of the Deque and returns it.
     * @return the front element of the Deque
     * @throws IndexOutOfBoundsException if the queue is empty
     */
    public T popFront() throws IndexOutOfBoundsException {
        return this.list.removeFirst();
    }

    /**
     * REmoves the element from the back of the Deque and returns it.
     * @return the back element of the Deque
     * @throws IndexOutOfBoundsException if the queue is empty
     */
    public T popBack() throws IndexOutOfBoundsException {
        return this.list.removeLast();
    }

    /**
     * Returns first element in the Deque
     * @return the first element
     * @throws IndexOutOfBoundsException if the queue is empty.
     */
    public T first() throws IndexOutOfBoundsException {
        return this.list.first();
    }

    /**
     * Returns the last element in the Deque
     * @return the last element
     * @throws IndexOutOfBoundsException if the queue is empty
     */
    public T last() throws IndexOutOfBoundsException {
        return this.list.last();
    }

    @Override
    public String toString() {
        return "DEQue" + this.list.toString().substring(18);
    }
}
