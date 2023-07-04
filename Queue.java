/** This class implements a dynamic Queue ADT supported by a
 * Singularly Linked List.
 * 
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

    /** Checks whether the LinkedList is empty or not.
     * 
     * @return a boolean: {@code true} if the list is empty and {@code false}
     * if it is not.
     */
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    /**
     * Add an item to the back of the queue
     * @param elem the item to be added to the back.
     */
    public void enqueue(T elem) {
        this.list.addLast(elem);
    }

    /**
     * Remove item from the front of the queue and return it.
     * @return the front element of the queue
     * @throws IndexOutOfBoundsException if the queue is empty
     */
    public T dequeue() throws IndexOutOfBoundsException {
        return this.list.removeFirst();
    }

    /**
     * Gets the first item in the queue.
     * @return the first item in the queue.
     * @throws IndexOutOfBoundsException if the list is empty.
     */
    public T first() throws IndexOutOfBoundsException {
        return this.list.first();
    }

    @Override
    public String toString() {
        return "Queue " + list.toString().substring(12);
    }
}