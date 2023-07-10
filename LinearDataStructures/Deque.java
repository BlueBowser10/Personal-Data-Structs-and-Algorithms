package LinearDataStructures;
import java.util.NoSuchElementException;

import ADTInterfaces.DequeInterface;

/**
 * This class implements a Deque ADT, a more general version of a Queue that
 * can add and remove elements from the front as well as the back. It uses the
 * DoublyLinkedList as the backbone.
 * @param <T> the type that the Deque holds
 * @author BlueBowser
 */
public class Deque<T> implements DequeInterface<T> {
    /** The Doubly Linekd List that will hold the Deque data.*/
    private DoublyLinkedList<T> list;

    /** Default constructor that creates an empty Deque. */
    public Deque() {
        list = new DoublyLinkedList<>();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void pushFront(T elem) throws IllegalArgumentException {
        if (elem == null) {
            throw new IllegalArgumentException("cannot add null element to the DEQue!");
        }
        this.list.addFirst(elem);
    }

    @Override
    public void pushBack(T elem) throws IllegalArgumentException  {
        if (elem == null) {
            throw new IllegalArgumentException("cannot add null element to the DEQue!");
        }
        this.list.addLast(elem);
    }

    @Override
    public T popFront() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the DEQue is empty!");
        }
        return this.list.removeFirst();
    }

    @Override
    public T popBack() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the DEQue is empty!");
        }
        return this.list.removeLast();
    }

    @Override
    public T first() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the DEQue is empty!");
        }
        return this.list.first();
    }

    @Override
    public T last() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the DEQue is empty!");
        }
        return this.list.last();
    }

    @Override
    public String toString() {
        return "DEQue" + this.list.toString().substring(18);
    }

    /**
     * Determines if two DEQues are equal. Two DEQues are equals if they have
     * the same elements of the same type in the same order.
     * @param o object to be checked
     * @return a boolean: {@code true} if the objects are equal
     *  and {@code false} otherwise.
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque other = (Deque) o;
        return this.list.equals(other.list);
    }
}
