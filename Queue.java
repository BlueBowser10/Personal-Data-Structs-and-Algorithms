import java.util.NoSuchElementException;
import ADTInterfaces.QueueInterface;

/** This class implements a dynamic Queue ADT supported by a
 * Singularly Linked List.
 * @param <T> THe type the queue holds
 * @author BlueBowser
 */
public class Queue<T> implements QueueInterface<T> {
    /** The LinkedList that will hold the queue data. */
    private LinkedList<T> list;

    /** A default structure creating an empty queue. */
    public Queue() {
        list = new LinkedList<>();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    @Override
    public void enqueue(T elem) throws IllegalArgumentException {
        if (elem == null) {
            throw new IllegalArgumentException("cannt add null element to the queue!");
        }
        this.list.addLast(elem);
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the queue is empty");
        }
        return this.list.removeFirst();
    }

    @Override
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