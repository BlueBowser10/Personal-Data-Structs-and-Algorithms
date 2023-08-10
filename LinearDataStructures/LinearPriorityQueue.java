package LinearDataStructures;

import java.util.Comparator;
import java.util.NoSuchElementException;


import ADTInterfaces.AbstractPriorityQueue;
import ADTInterfaces.Position;
import ADTInterfaces.Entry;

/**
 * This is a Linear Priority Queue. It implements a priority queue using
 * a Sorted List, more specificially a PositionalList. The priority scheme is
 * that the entry with the smallest key gets the most precedent.
 * @param <K> the type of priority key to use for an entry. It must be
 * comparable
 * @param <V> the type of value an entry will hold for an associated key
 * @author BlueBowser
 */
public class LinearPriorityQueue<K extends Comparable, V> extends  AbstractPriorityQueue<K, V> {
    /**
     * The sorted list to hold the queue.
     */
    PositionalList<Entry<K,V>> queue;

    /**
     * Creates an empty priority queue.
     */
    public LinearPriorityQueue() {
        super();
        this.queue = new PositionalList<>();
    }

    /**
     * Creates a priority queue with a special Comparator that allows you to
     * switch the order.
     * @param newComp the new Comparator to use for compariosn
     */
    public LinearPriorityQueue(Comparator<K> newComp) {
        super(newComp);
        this.queue = new PositionalList<>();
    }

    @Override
    public void insert(K key, V val) {
        checkIfNull(key); checkIfNull(val);
        Entry<K, V> entry = new Entry<K, V>(key, val);
        if (size == 0) {
            queue.addFirst(entry);
        } else {
            Position<Entry<K, V>> pos = queue.first();
            while (pos != null) {
                if (this.comp.compare(key, pos.getElement().getKey()) < 0) {
                    break;
                }
                pos = queue.after(pos);
            }
            if (pos == null) {
                queue.addLast(entry);
            } else {
                queue.addBefore(pos, entry);
            }
        }
        ++size;
    }

    @Override
    public Entry<K, V> mostImportant() {
        return (queue.first() == null ? null : queue.first().getElement());
    }

    @Override
    public Entry<K, V> removeMostImportant() throws NoSuchElementException {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("the queue is empty!");
        }
        --this.size;
        return queue.remove(queue.first());
    }

    /**
     * Internal method to check whether an argumet is null. If it is, throw an error.
     * @param o argument to be checked.
     * @throws IllegalArgumentException if the object is null.
     */
    private void checkIfNull(Object o) throws IllegalArgumentException{
        if (o == null) {
            throw new IllegalArgumentException("argument is null!");
        }
    }

    @Override
    public String toString() {
        return "Priority Queue (Linear) (" + this.size() + "):\t" + this.mostImportant();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LinearPriorityQueue)) {
            return false;
        }
        LinearPriorityQueue<K,V> other;
        try {
            other = (LinearPriorityQueue<K,V>) o;
        } catch (Exception e) {
            return false;
        }
        if (this.queue.equals(other.queue)) {
            return true;
        }
        return false;
    }
}
