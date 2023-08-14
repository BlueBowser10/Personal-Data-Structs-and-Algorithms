package LinearDataStructures;

import ADTInterfaces.Entry;
import ADTInterfaces.Position;
import java.util.Comparator;

/**
 * This is an Adaptable Priority Queue. It is like a priority Queue, but it
 * has the ability to update the entries in the queue. If an entry's 
 * priority key is updated, the entry's position is modified. This queue defaults to be minimum oriented, so small priority keys get higher priority.
 * @param <K> the priority key of an entry. Must be Comparable.
 * @param <V> the value of the entry.
 * @author BlueBowser
 */
public class AdaptablePriorityQueue<K extends Comparable,V> extends LinearPriorityQueue<K,V> {
    /**
     * Create an emtpy AdaptablePriorityQueue where the minimum elments
     * get priority.
     */
    public AdaptablePriorityQueue() {
        super();
    }

    /**
     * Create an empty AdaptablePriorityQueue with a custom
     * Comparator.
     * @param comp the comparator to use for the priority queue.
     */
    public AdaptablePriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    /**
     * Replaces the key of an entry, if it exists, and shifts
     * the priority of the entry into its proper place.
     * @param entry the entry to look for in the list.
     * @param newPriority the new prioirty key to set it to.
     * @throws IllegalArgumentException if either of the arguments
     * are null.
     */
    public void replaceKey(Entry<K,V> entry, K newPriority) {
        checkIfNull(entry); checkIfNull(newPriority);
        if (entry.getKey().equals(newPriority)) {
            return;
        }
        Position<Entry<K,V>> pos = findEntry(entry);
        if (pos == null) {
            return;
        }
        K lastPriority = pos.getElement().getKey();
        entry.setKey(newPriority);
        queue.set(pos, entry);
        if (comp.compare(newPriority, lastPriority) < 0) {
            shiftUpEntry(pos);
        } else if (comp.compare(newPriority, lastPriority) > 0) {
            shiftDownEntry(pos);
        }
    }

    /**
     * Replaces the value of an entry, if it exists.
     * @param entry the entry to look for in the list.
     * @param newValue the new value to write
     * @throws IllegalArgumentException if either of the arguments are null.
     */
    public void replaceValue(Entry<K,V> entry, V newValue) {
        if (entry.getVal().equals(newValue)) {
            return;
        }
        checkIfNull(newValue); checkIfNull(entry);
        Position<Entry<K,V>> pos = findEntry(entry);
        if (pos == null) {
            return;
        }
        entry.setVal(newValue);
        queue.set(pos, entry);
    }

    /**
     * An internal function to find the entry, and return
     * its position, or return null if the entry is not in 
     * the list.
     * @param e the entry to look for
     * @return the Position of the Entry in the queue, or
     * {@code null} if it does not exist.
     */
    private Position<Entry<K,V>> findEntry(Entry<K,V> e) {
        Position<Entry<K,V>> pos = queue.first();
        while (pos != null) {
            if (pos.getElement().equals(e)) {
                return pos;
            }
            pos = queue.after(pos);
        }
        return null;
    }

    /**
     * Moves the entry into its proper place into the list if it's priority needs to be boosted.
     * @param entry the entry to insert into its proper place in the
     * list.
     */
    private void shiftUpEntry(Position<Entry<K,V>> pos) {
        if (queue.size() > 1) {
            Position<Entry<K, V>> marker = queue.before(pos);
            while ((marker != null) && (comp.compare(pos.getElement().getKey(), marker.getElement().getKey()) > 0)) {
                marker = queue.before(marker);
            }
            if (pos == null) {
                queue.addFirst(pos.getElement());
            } else {
                queue.addBefore(marker, pos.getElement());
            }
            queue.remove(pos);
        }
    }

    /**
     * Moves the entry into its proper place into the list if it's priority needs to be diminished.
     * @param entry the entry to insert into its proper place in the
     * list.
     */
    private void shiftDownEntry(Position<Entry<K,V>> pos) {
        if (queue.size() > 1) {
            Position<Entry<K,V>> marker = queue.after(pos);
            while (marker != null) {
                if (comp.compare(pos.getElement().getKey(), marker.getElement().getKey()) < 0) {
                    marker = queue.after(marker);
                } else {
                    break;
                }
            }
            if (marker == null) {
                queue.addLast(pos.getElement());
            } else {
                queue.addAfter(marker, pos.getElement());
            }
            queue.remove(pos);
        }
    }
}