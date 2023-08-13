package NonLinearDataStructures;

import ADTInterfaces.Entry;

import java.util.NoSuchElementException;

import ADTInterfaces.AbstractPriorityQueue;
import java.util.Comparator;


/**
 * This class implements a priority queue using a minimum oriented heap
 * data structure, where elements with smaller priority keys get precedence.
 * @param <K> the priority key of the element. Must be Comparable.
 * @param <V> the value of the element
 * @author BlueBowser
 */
public class HeapPriorityQueue<K extends Comparable, V> extends AbstractPriorityQueue<K,V> {

    /**The heap to store the priority queue. */
    Heap<K,V> heap;

    /**
     * Creates a heap based priority queue with a default 
     * minimum oriented Comparator.
     */
    public HeapPriorityQueue() {
        super();
        heap = new Heap<>();
    }

    /**
     * Creates a heap based priority queu with a custom
     * Comparator
     * @param comp the Comparator to use in comparison.
     */
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
        heap = new Heap<>(comp);
    }


    /**
     * Returns the number of elements in the heap.
     */
    public int size() {
        return heap.size();
    }

    /**
     * Returns {@code true it the heap is empty and {@code false} otherwise.}
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public void insert(K key, V val) {
        heap.insert(key, val);
        size = heap.size();
    }

    @Override
    public Entry<K, V> mostImportant() {
        return heap.top();
    }

    @Override
    public Entry<K, V> removeMostImportant() throws NoSuchElementException {
        --size;
        return heap.removeTop();
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
