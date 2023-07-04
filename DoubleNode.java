/** This is an implementation of a Doubly Linked Node, which points to the
 * next and previous nodes. It is generic.
 * @param <T> the type a Node holds
 * @author BlueBowser
 */
public class DoubleNode<T> extends Node<T>{
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

    /** Default constructor which initlializes an empty DoubleNode object not
     * pointing to anything.
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
    public void setElement(T elem) {
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
}