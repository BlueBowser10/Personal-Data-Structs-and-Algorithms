package LinearDataStructures;
import java.util.Iterator;
import java.util.NoSuchElementException;

import ADTInterfaces.DoublyLinkedLIstInterface;
import ADTInterfaces.SinglyLinkedList;

/**
 * This implements a Doubly Linked List ADT, where nodes link the next nodes and previous nodes. This approach uses two dummy DoubleNodes at the beginning and the end to make thins a lot easier to implement.
 * @param <T> the type that the list holds
 * @author BlueBowser
*/
public class DoublyLinkedList<T> implements DoublyLinkedLIstInterface<T>, Iterable<T> {
    /**
     * An iterator for the DoublyLinkedList. This inner class
     *  can help to iterate through the list, starting from head to tail.
     * @param <T> the type that the iterator holds
     * @author BlueBowser
    */
    public class DoubleListIterator<T> implements Iterator<T> {
        /** The Node representing the start of the list. */
        DoubleNode list;

        /**
         * Full constructor that creates and Iterator that traverses like a
         * normal list.
         */
        public DoubleListIterator() {
            list = HEAD.next();
        }
        /**
         * Sees if the iterator can continue iterating, and an node exists
         * at the current point.
         * @return a boolean: {@code true} if there is another node to
         * iterate on, {@code false} otherwise.
         */
        public boolean hasNext() {
            if (isEmpty() || list == TAIL) {
                return false;
            }
            return true;
        }

        /**
         * Returns the element at the current node and advances to the next'
         * node.
         * @return the current element at the next 
         * @throws IllegalStateException if you finish iterating and there are
         * no more items to iterate over or the list is empty.
         */
        public T next() throws IllegalStateException {
            if (!hasNext()) {
                throw new IllegalStateException("no more iterable nodes!",
                    null);
            }
            T elem = (T) list.getElement();
            list = list.next();
            return elem;
        }
    }

    /**The head dummy node which is the marker for the beginning of the list. */
    private DoubleNode<T> HEAD;
    /**The tail dummy node which is the marker for the end of the list. */
    private DoubleNode<T> TAIL;
    /**The size of the list (the number of nodes between the start and end
     * nodes) */
    private int size;

    public DoublyLinkedList() {
        HEAD = new DoubleNode<>();
        TAIL = new DoubleNode<>();
        HEAD.setNext(TAIL);
        HEAD.setPrev(TAIL);
        TAIL.setNext(HEAD);
        TAIL.setNext(TAIL);
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public void addFirst(T elem) throws IllegalArgumentException {
        if (elem == null) {
            throw new IllegalArgumentException("you cannot add a null element!");
        }
        DoubleNode<T> node = new DoubleNode<>(elem);
        if (this.isEmpty()) {
            this.addBetween(node, HEAD, TAIL);
        } else {
            this.addBetween(node, HEAD, HEAD.next());
        }
        ++this.size;
    }

    @Override
    public void addLast(T elem) throws IllegalArgumentException {
        if (elem == null) {
            throw new IllegalArgumentException("you cannot add a null element!");
        }
        DoubleNode<T> node = new DoubleNode<>(elem);
        if (this.isEmpty()) {
            this.addBetween(node, HEAD, TAIL);
        } else {
            this.addBetween(node, TAIL.prev(), TAIL);
        }
        ++this.size;
    }

    @Override
    public T removeFirst() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the list is empty!");
        }
        T data = HEAD.next().getElement();
        removeBetween(HEAD, HEAD.next().next());
        --this.size;
        return data;
    }

    @Override
    public T removeLast() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the list is empty!");
        }
        T data = TAIL.prev().getElement();
        this.removeBetween(TAIL.prev().prev(), TAIL);
        --this.size;
        return data;
    }

    @Override
    public T first() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the list is empty!");
        }
        return HEAD.next().getElement();
    }

    @Override
    public T last() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the list is empty!");
        }
        return TAIL.prev().getElement();
    }

    @Override
    public String toString() {
        String f = "Doubly Linked List (" + this.size + "):\n\t";
        if (this.isEmpty()) {
            f += "None";
        } else {
            DoubleNode<T> node = HEAD.next();
            while (node != TAIL) {
                f += node.getElement() + " -->\n\t";
                node = node.next();
            }
        }
        return f;
    }

    /**
     * Internal function for inserting a node between two other doubly linked nodes.
     * @param node the Doubly Linked Node to be inserted
     * @param a the previous node in the list
     * @param b the next node in the list
     */
    private void addBetween(DoubleNode<T> node, DoubleNode<T> a, DoubleNode<T> b) {
        //update forward links
        a.setNext(node);
        node.setNext(b);
        //update back links
        b.setPrev(node);
        node.setPrev(a);

        if (a == HEAD) {
            a.setPrev(node);
        }
        if (b == TAIL) {
            b.setNext(node);
        }
    }

    /**
     * Internal function for deleting a node between two other doubly linked nodes.
     * @param a the node before the node to delete
     * @param b the node after the node to delete
     */
    private void removeBetween(DoubleNode<T> a, DoubleNode<T> b) {
        a.setNext(b);
        b.setPrev(a);
        if (b == TAIL) {
            b.setNext(a);
        }
        if (a == HEAD) {
            a.setPrev(b);
        }
    }

    /**
     * Inserts an element at the {@code pos}th Node in the DoublyLinkedList.
     * The element must not be null. The head is at index 0, and the tail is
     *  at index {@code this.size - 1}. If you insert an index in the
     *  {@code this.size}th index, it will add a new element at the end of the
     *  List.
     * @param elem the element to be inserted. Must not be null.
     * @param pos the index of the element. Must be within the bounds of the list.
     * @throws IllegalArgumentException if the element is null
     * @throws IndexOutOfBoundsException if the pos argument is negative or greater than the size of the list
     */
    public void insert(T elem, int pos) 
        throws IllegalArgumentException, IndexOutOfBoundsException {
        if (elem == null) {
            throw new IllegalArgumentException("cannot insert a null element!");
        }
        if ((pos < 0) || (pos > this.size)) {
            throw new IndexOutOfBoundsException(pos + " out of bounds for size " + this.size);
        } else if (pos == 0) {
            this.addFirst(elem);
        } else if (pos == this.size) {
            this.addLast(elem);
        } else {
            int i = 0;
            DoubleNode<T> list = this.HEAD.next();
            while (i < pos - 1) {
                list = list.next();
                ++i;
            }
            this.addBetween(new DoubleNode<T>(elem), list, list.next());
            ++this.size;
        }
    }

    /**
     * Removes the element from the {@code pos}th position in the list,
     *  and returns it
     * @param pos the index of the element to be removed
     * @return the element at that index
     * @throws IndexOutOfBoundsException if the pos argument is negative or greater than the size of the list minus one
     */
    public T remove(int pos) throws IndexOutOfBoundsException {
        if ((pos < 0) || (pos > this.size - 1)) {
            throw new IndexOutOfBoundsException(pos + " out of bounds for size " + this.size);
        }
        DoubleNode<T> list = this.HEAD.next();
        int i = 0;
        while (i < pos) {
            list = list.next();
            ++i;
        }
        T data = (T) list.getElement();
        this.removeBetween(list.prev(), list.next());
        --this.size;
        return data;
    }

    /**
     * Gets the element at index i in the doubly linked list.
     * The head starts at an index of 0, and the tail is at an index
     * of {@code this.size - 1}.
     * 
     * @param pos the index of the elemen
     * @return the element at that position
     * @throws IndexOutOfBoundsException if the pos argument is negative or greater than the size of the list minus one
     */
    public T get(int pos) throws IndexOutOfBoundsException {
        if ((pos < 0) || (pos > this.size - 1)) {
            throw new IndexOutOfBoundsException(pos + " out of bounds for size " + this.size);
        }
        int i = 0;
        DoubleNode<T> list = this.HEAD.next();
        while (i < pos) {
            list = list.next();
            ++i;
        }
        return list.getElement();
    }

    

    @Override
    public DoubleListIterator<T> iterator() {
        return new DoubleListIterator<T>();
    }

    /**
     * Gets the element at index i in the doubly linked list.
     * The head starts at an index of 0, and the tail is at an index
     * of {@code this.size - 1}.
     * 
     * @param elem the element to be added to the list. Must not be null.
     * @param pos the index of the elemen. Must be nonnegative and less than the size of the list.
     * @return the element at that position
     * @throws IndexOutOfBoundsException if the pos argument is negative or greater than the size of the list minus one
     * @throws IllegalArgumentException if the element is null.
     */
    public void set(T elem, int pos)
        throws IndexOutOfBoundsException, IllegalArgumentException {
        if (elem == null) {
            throw new IllegalArgumentException("Can't add null value to the lsit.");
        }
        if ((pos < 0) || (pos > this.size - 1)) {
            throw new IndexOutOfBoundsException(pos + " out of bounds for size " + this.size);
        }
        int i = 0;
        DoubleNode<T> list = this.HEAD.next();
        while (i < pos) {
            list = list.next();
            ++i;
        }
        list.setElement(elem);
    }

    /**
     * Returns whether two DoublyLinkedLists are equal. Two DoublyLinkedLists
     *  are equal if they have the smae size and hold the same elements in the same order.
     * @return a boolean: {@code true} if the objects are equal and
     * {@code false} otherwise
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DoublyLinkedList)) {
            return false;
        }
        DoublyLinkedList other = (DoublyLinkedList) o;
        if (other.size != this.size) {
            return false;
        }
        Iterator iter = this.iterator();
        Iterator otherIter = other.iterator();
        while (iter.hasNext()) {
            if (!iter.next().equals(otherIter.next())) {
                return false;
            }
        }
        return true;
    }
}
