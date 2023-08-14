package ADTInterfaces;

import java.util.NoSuchElementException;

/**
 * This is the interface for a Heap, a more specific type of binary tree. 
 * A heap is a compete binary tree, which mean all leaves are on the same
 * level, filling the leaves from left to right, and all bottom nodes have
 * at most two children. Heaps also have a special ordering principle
 * called the Heap Property, where the root node has an element smaller
 * that all other elements in the tree. As you go down the children,
 * node keys always increase. Heaps are useful for quickly modifying priority queues, as well as sorting.
 * @param <K> the key of the entry. Must be Comparable.
 * @param <V> the value of the entry.
 * @author BlueBowser
 * @see NonLinearDataStructures.Heap
 */
public interface HeapInterface<K extends Comparable, V> {
    /**
     * The size of the heap.
     * @return the size of the heap.
     */
    public int size();

    /**
     * Returns whether the heap is empty {@code true}, or not {@code false}.
     * @return a boolean
     */
    public boolean isEmpty();

    /**
     * Returns the top entry in the heap, or {@code null} if the heap is empty.
     * @return the top entry in the heap.
     */
    public Entry<K, V> top();

    /**
     * Inserts an entry into the heap.
     * @param key the key to insert. Must not be null
     * @param val the value with the key. Must not be null
     * @throws IllegalArgumentException if either of the argumetns are null/
     */
    public void insert(K key, V val) throws IllegalArgumentException;

    /**
     * Removes the entry from the root of the heap, and
     * updates the heap.
     * @return the entry at the top of the heap.
     * @throws NoSuchElementException if the heap is empty
     */
    public Entry<K, V> removeTop() throws NoSuchElementException;
}
