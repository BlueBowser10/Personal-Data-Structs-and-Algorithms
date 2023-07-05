import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This implements a Doubly Linked List ADT, where nodes link the next nodes and previous nodes. This approach uses two dummy DoubleNodes at the beginning and the end to make thins a lot easier to implement.
 * @param <T> the type that the list holds
 * @author BlueBowser
*/
public class DoublyLinkedList<T> implements SinglyLinkedList<T>, Iterable<T> {
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

    /**
     * Reemoves the the item at the end of the list, if any exist
     * @return the last time that was removed from the beginning.
     * @throws NoSuchElementException when the list is empty
     */
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
    }

        /**
     * Internal function for deleting a node between two other doubly linked nodes.
     * @param a the node before the node to delete
     * @param b the node after the node to delete
     */
    private void removeBetween(DoubleNode<T> a, DoubleNode<T> b) {
        a.setNext(b);
        b.setPrev(a);
    }

    @Override
    public DoubleListIterator<T> iterator() {
        return new DoubleListIterator<T>();
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
