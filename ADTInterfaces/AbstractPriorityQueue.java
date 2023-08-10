package ADTInterfaces;

import java.util.Comparator;
import java.util.NoSuchElementException;


/**
 * This is an abstract class for impementing a Priority Queue. A priority queue
 * is a special sort of queue where items are arranged in an order relative to
 * their priority number, which is called a 'key'. The highest priority element
 * (usually determined by some sort of total ordering) is at the front, and the
 * farther back down the Priority Queue you go, the lower the priority of the
 * elements. For default, we will assume that an element with the highest 
 * priority will have the smallest key.
 * @author BlueBowser
 * @param <K> the type that will be used to assign priority. It must be comparable to itself.
 * @param <V> the content that will be used to assign priority. It must be comparable to itself.
*/
public abstract class AbstractPriorityQueue<K extends Comparable, V> {
    /**
     * Internal default comparator for elemts of the same priority.
     */
    protected class DefaultComparator<K> implements Comparator<K> {
        @Override
        public int compare(K a, K b) throws ClassCastException {
            return ((Comparable<K>) a).compareTo(b);
        }
    }

    /**The size of the Priority Queue. */
    protected int size;

    /**The comparator used to compare the priority of entries. */
    protected Comparator<K> comp;

    /**
     * Returns the size of the priority queue.
     * @return the size of the priority queue.
     */
    public int size() {
        return size;
    }

    /**
     * Determines whether the prioiryt queue is empty or not.
     * @return {@code true} if the size is 0, false otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**Creates an empty queue with a default comparator. */
    public AbstractPriorityQueue() {
        this.size = 0;
        this.comp = (Comparator<K>) new DefaultComparator<K>();
    }

    /**
     * Creates an empty queue with a custom comparatr.
     * @param comp the Comparator to use when determining priority in the
     * queue. Must not be null.
     * @throws IllegalArgumentException if {@code comp} is null.
     */
    public AbstractPriorityQueue(Comparator<K> comp) throws IllegalArgumentException {
        if (comp == null) {
            throw new IllegalArgumentException("Element is null");
        }
        this.size = 0;
        this.comp = comp;
    }

    /**
     * Inserts an entry with priority {@code key} and content {@code val}
     * @param key priority of entry. Must not be null.
     * @param val content of entry. Must not be null.
     * @throws IllegalArgumentException if either of the arguments are null.
     */
    public abstract void insert(K key, V val);

    /**
     * Returns the entry with the most important priority level.
     * @return Entry with most important priority level, or {@code null} if the
     * priority queue is empty.
     */
    public abstract Entry<K,V> mostImportant();

    /**
     * Removes and returns the entry with the most important priority level.
     * @return Entry with most important priority level
     * @throws NoSuchElementException if the list is empty.
     */
    public abstract Entry<K,V> removeMostImportant() throws NoSuchElementException;
    
}
