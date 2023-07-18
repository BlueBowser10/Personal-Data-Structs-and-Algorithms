package LinearDataStructures;
import java.util.NoSuchElementException;

import ADTInterfaces.Position;
import ADTInterfaces.PositionalListInterface;
import java.util.Iterator;

/**
 * This is an implementation of a Positional List ADT, a more abstract version 
 * of a List ADT more suited for DoublyLinkedLists. It uses Nodes that have 
 * Position, so externally you can keep track of where you are in the list, 
 * while also having access to the internal list structure. It operates 
 * similarly to a DoublyLinkedList.
 * @param <T> the type that the list holds
 * @author BlueBowser
 * @see Position
 */
public class PositionalList<T> implements PositionalListInterface<T>, Iterable<T> {

    /**Internal node class for the LinkedList */
    private static class Node<T> implements Position<T> {
        /**The data that the node holds */
        T data;
        /**The next node.*/
        Node<T> next;
        /**The previous node.*/
        Node<T> prev;
    
        /**
         * Full constructor that initializes a Node object holding an element
         * {@code data}. It does not point to any nodes.
         * @param data the data that the node will hold.
         */
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    
        /**
         * Default constructor which initlializes an empty Node object not
         * pointing to anything. Only use this function when creating a
         *  sensintel node.
         */
        public Node() {
            this(null);
        }
    
        /**
         * Gets the element that the node is holding
         * @return the data that the node contains
         */
        public T getElement() {
            return this.data;
        }
    
        /**
         * Sets the element within node to a newer element.
         * @param elem the new value that the node will contain
         */
        public void setElement(T elem) throws IllegalArgumentException {
            if (elem == null) {
                throw new IllegalArgumentException("Node cannot hold null element!");
            }
            this.data = elem;
        }
    
        /**
         * Gives the node after the current one
         * @return the next node
         */
        public Node<T> next() {
            return this.next;
        }
    
        /**
         * Sets the next node to another node.
         * @param node the new next node
         */
        public void setNext(Node<T> node) {
            this.next = node;
        }
    
        /**
         * Returns the previous node.
         * @return the previous node
         */
        public Node<T> prev() {
            return this.prev;
        }
    
        /**
         * Sets the previous node to a new node
         * @param node the new previous node.
         */
        public void setPrev(Node<T> node) {
            this.prev = node;
        }
    
        /**
         * Determines if two Node are equal. Two nodes are equal if they have
         *  the same type and the same value.
         * 
         * @param o The object to be checked
         * @return a booolean: {@code true} if both objects are equal and
         *  {@code false} otherwise.
         */
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }
            Node other = (Node) o;
            return this.data.equals(other.data);
        }
    
        @Override
        public String toString() {
            return prev.getElement() + " <-- " + this.data + " --> " + next.getElement();
        }
    }

    private Node<T> HEAD;
    private Node<T> TAIL;
    private int size;

    public PositionalList() {
        HEAD = new Node<>();
        TAIL = new Node<>();
        this.size = 0;
    }

    /**
     * Turns a Node into a Position to use and manipulate
     * @param node a Node of the linked list
     * @return a Node object wrapped in a Position interface
     */
    private Position<T> position(Node<T> node) {
        if ((node == HEAD) || (node == TAIL)) {
            return null;
        }
        return node;
    }

    /**
     * Thisi makes sure that the Position {@code p} is still valid and exists
     * within the list, and it turns it back into a Node in the list. The user
     * will not be able to access the sentinel nodes.
     * @param p
     * @throws IllegalArgumentException
     */
    private Node<T> validate(Position<T> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid position");
        }
        Node<T> node = (Node<T>) p;
        if ((node.next() == null) && (node.prev() == null)) {
            throw new IllegalArgumentException("Position is not in the list anymore!");
        }
        return node;
    }

    @Override
    public Position<T> first() {
        if (this.isEmpty()) {
            return null;
        }
        return this.position(HEAD.next());
    }
    @Override
    public Position<T> last() {
        if (this.isEmpty()) {
            return null;
        }
        return this.position(TAIL.prev());
    }
    @Override
    public Position<T> before(Position<T> p) {
        return this.position(validate(p).prev());
    }
    @Override
    public Position<T> after(Position<T> p) {
        return this.position(validate(p).next());
    }
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    @Override
    public int size() {
        return this.size;
    }
    @Override
    public Position<T> addFirst(T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("Cannot have a null element!");
        }
        Node<T> node = new Node<>(elem);
        if (this.size == 0) {
            this.addBetween(node, HEAD, TAIL);
        } else {
            this.addBetween(node, HEAD, HEAD.next());
        }
        ++this.size;
        return node;
    }

    @Override
    public Position<T> addLast(T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("Cannot have a null element!");
        }
        Node<T> node = new Node<>(elem);
        if (this.size == 0) {
            this.addBetween(node, HEAD, TAIL);
        } else {
            this.addBetween(node, TAIL.prev(), TAIL);
        }
        ++this.size;
        return node;
    }
    @Override
    public Position<T> addBefore(Position<T> p, T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("Cannot have a null element!");
        }
        Node<T> pos = this.validate(p);
        Node<T> node = new Node<>(elem);
        this.addBetween(node, pos.prev(), pos);
        ++this.size;
        return node;
    }
    @Override
    public Position<T> addAfter(Position<T> p, T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("Cannot have a null element!");
        }
        Node<T> pos = this.validate(p);
        Node<T> node = new Node<>(elem);
        this.addBetween(node, pos, pos.next());
        ++this.size;
        return node;
    }
    @Override
    public T set(Position<T> p, T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("Cannot have a null element!");
        }
        Node<T> pos = this.validate(p);
        T lastElement = pos.getElement();
        pos.setElement(elem);
        return lastElement;
    }
    @Override
    public T remove(Position<T> p) {
        Node<T> pos = this.validate(p);
        T lastElement = pos.getElement();
        this.removeBetween(pos.prev(), pos.next());
        --this.size;
        return lastElement;
    }

    @Override
    public String toString() {
        String f = "Positional List: (" + this.size + "):\n\t";
        if (this.size() == 0) {
            f += "None";
        } else {
            Node<T> node = HEAD.next();
            int i = 1;
            while (node != TAIL) {
                f += String.format("%d: %s\n\t", i, node.getElement());
                node = node.next();
                ++i;
            }
        }
        return f;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PositionalList)) {
            return false;
        }
        PositionalList other = (PositionalList) o;
        if (this.size() != other.size()) {
            return false;
        }
        Position p1 = this.first();
        Position p2 = other.first();
        while (p1 != TAIL) {
            if (!p1.getElement().equals(p2.getElement())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Internal function for inserting a node between two other doubly linked nodes.
     * @param node the Doubly Linked Node to be inserted
     * @param a the previous node in the list
     * @param b the next node in the list
     */
    private void addBetween(Node<T> node, Node<T> a, Node<T> b) {
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
    private void removeBetween(Node<T> a, Node<T> b) {
        a.next().setPrev(null);
        a.next().setNext(null);
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
     * Returns an Iterator object which iterates through all the Positions
     * in the PositionalList.
     * @return an Iterator.
     */
    public Iterator<T> iterator() {
        return new PositionalListIterator<T>(this);
    }
}
