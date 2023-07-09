import java.util.Iterator;
import java.util.NoSuchElementException;

import ADTInterfaces.SinglyLinkedList;


/** This is a generic Singularly Linked List. It is an implementation of a
 * Linked List ADT.
 * 
 * @param <T> the type that the linked list holds
 * @author BlueBowser
 */
public class LinkedList<T> implements SinglyLinkedList<T>, Iterable<T> {
    /**An iterator for the LinkedList. This inner class can help to iterate
     * through the list, starting from head to tail.
     * 
     * @param <T> the type that the iterator holds
     * @author BlueBowser
    */
    public class ListIterator<T> implements Iterator<T> {
        /** The Node representing the start of the list. */
        Node list;
        /** 
         * Default constructor that creates an Iterator that starts at the
         * head node.
         */
        public ListIterator() {
            list = head;
        }
        /**
         * Sees if the iterator can continue iterating, and an node exists
         * at the current point.
         * 
         * @return a boolean: {@code true} if there is another node to
         * iterate on, {@code false} otherwise.
         */
        public boolean hasNext() {
            if (list == null) {
                return false;
            }
            return true;
        }

        /**
         * Returns the element at the current node and advances to the next
         * node, if one exists.
         * 
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

    /**The head of the list. */
    private Node<T> head;
    /**The tail of the list. If the size of the list is 1, the tail will be
     * the same Node as the {@code head} is.*/
    private Node<T> tail;
    /**The size of the list (the number of Nodes in the list) */
    private int size;

    /**
     * Default constructor for a LinkedList. This initializes an empty
     * LinkedList.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
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
        Node<T> n = new Node<>(elem);
        if (this.isEmpty()) {
            this.head = n;
            this.tail = this.head;
        } else {
            n.setNext(this.head);
            this.head = n;
        }
        ++this.size;
    }

    @Override
    public void addLast(T elem) throws IllegalArgumentException {
        if (elem == null) {
            throw new IllegalArgumentException("you cannot add a null element!");
        }
        Node<T> n = new Node<>(elem);
        if (this.isEmpty()) {
            this.head = n;
            this.tail = this.head;
        } else {
            this.tail.setNext(n);
            this.tail = n;
        }
        ++this.size;
    }
    
    @Override
    public T removeFirst() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        } else {
            T data = this.head.getElement();
            if (this.size() == 1) {
                this.head = null;
                this.tail = null;
            } else if (this.size() == 2) {
                this.head = this.tail;
            } else {
                this.head = this.head.next();
            }

            --this.size;
            return data;
        }

    }

    @Override
    public T first() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the list is empty!");
        }
        return this.head.getElement();
    }

    @Override
    public T last() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the list is empty!");
        }
        return this.tail.getElement();
    }

    @Override
    public String toString() {
        String f = "Linked List (" + this.size + "):\n\t";
        if (this.isEmpty()) {
            f += "None";
        } else {
            Node<T> node = this.head;
            while (node != null) {
                f += node.getElement() + " -->\n\t";
                node = node.next();
            }
        }
        return f;
    }
    
    @Override
    public ListIterator<T> iterator() {
        return new ListIterator<T>();
    }

    /**
     * Returns whether two LinkedLists are equal. Two LinkedLists are equal if
     * they have the smae size and hold the same elements in the same order.
     * @return a boolean: {@code true} if the objects are equal and
     * {@code false} otherwise
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LinkedList)) {
            return false;
        }
        LinkedList other = (LinkedList) o;
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