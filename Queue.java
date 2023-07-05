import java.util.NoSuchElementException;

/** This class implements a dynamic Queue ADT supported by a
 * Singularly Linked List.
 * @param <T> THe type the queue holds
 * @author BlueBowser
 */
public class Queue<T> {
    /** The LinkedList that will hold the queue data. */
    private LinkedList<T> list;

    /** A default structure creating an empty queue. */
    public Queue() {
        list = new LinkedList<>();
    }

    /**
     * Gets the size of the queue
     * @return the size of the queue.
     */
    public int size() {
        return this.list.size();
    }

    /**
     * Checks whether the LinkedList is empty or not.
     * 
     * @return a boolean: {@code true} if the list is empty and {@code false}
     * if it is not.
     */
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    /**
     * Add an item to the back of the queue.
     * @param elem the item to be added to the back. Must not be null.
     * @throws IllegalArgumentException if the element is null
     */
    public void enqueue(T elem) throws IllegalArgumentException {
        if (elem == null) {
            throw new IllegalArgumentException("cannt add null element to the queue!");
        }
        this.list.addLast(elem);
    }

    /**
     * Remove item from the front of the queue and return it.
     * @return the front element of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the queue is empty");
        }
        return this.list.removeFirst();
    }

    /**
     * Gets the first item in the queue.
     * @return the first item in the queue.
     * @throws NoSuchElementException if the list is empty.
     */
    public T first() throws NoSuchElementException {
        return this.list.first();
    }

    @Override
    public String toString() {
        return "Queue " + list.toString().substring(12);
    }

    /**
     * Determines if two Queues are equal. Two queues are equals if they have
     * the same elements of the same type in the same order.
     * @param o object to be checked
     * @return a boolean: {@code true} if the objects are equal
     *  and {@code false} otherwise.
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Queue)) {
            return false;
        }
        Queue other = (Queue) o;
        return this.list.equals(other.list);
    }
}