/**
 * This is an implementation of a Doubly Linked Node, which points to the
 * next and previous nodes. It is generic. It can hold null values, but only
 * in the cases that it is a sentinel node (a node at the beginning or end
 *  of the doubly linked list).
 * @param <T> the type a Node holds
 * @author BlueBowser
 */
public class DoubleNode<T> {
    /**The data that the node holds */
    T data;
    /**The next node.*/
    DoubleNode<T> next;
    /**The previous node.*/
    DoubleNode<T> prev;

    /**
     * Full constructor that initializes a DoubleNode object holding an element
     * {@code data}. It does not point to any nodes.
     * @param data the data that the node will hold.
     */
    public DoubleNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    /**
     * Default constructor which initlializes an empty DoubleNode object not
     * pointing to anything. Only use this function when creating a
     *  sensintel node.
     */
    public DoubleNode() {
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
            throw new IllegalArgumentException("DoubleNode cannot hold null element!");
        }
        this.data = elem;
    }

    /**
     * Gives the node after the current one
     * @return the next node
     */
    public DoubleNode<T> next() {
        return this.next;
    }

    /**
     * Sets the next node to another node.
     * @param node the new next node
     */
    public void setNext(DoubleNode<T> node) {
        this.next = node;
    }

    /**
     * Returns the previous node.
     * @return the previous node
     */
    public DoubleNode<T> prev() {
        return this.prev;
    }

    /**
     * Sets the previous node to a new node
     * @param node the new previous node.
     */
    public void setPrev(DoubleNode<T> node) {
        this.prev = node;
    }

    /**
     * Determines if two DoubleNode are equal. Two nodes are equal if they have
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
        if (!(o instanceof DoubleNode)) {
            return false;
        }
        DoubleNode other = (DoubleNode) o;
        return this.data.equals(other.data);
    }
}