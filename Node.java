/**
 * This is a public generic Node class used to represent the Node
 * of a linked list.
 * 
 * @param <T> the type the Node holds
 * @author BlueBowser
 */
public class Node<T> {
    /** the data that the Node holds */
    private T data;

    /** the next Node on the list */
    private Node<T> nextNode;

    /**
     * Creates a Node holding an element T, and the Node does not
     * point to any other Node. The element must not be {@code null}.
     * 
     * @param elem the element that the Node will hold
     * @throws IllegalArgumentException if the value passed is null
     */
    public Node(T elem) throws IllegalArgumentException {
        if (elem == null) {
            throw new IllegalArgumentException("A Node cannot hold a null element");
        }
        this.data = elem;
        this.nextNode = null;
    }

    /**
     * returns the Node that the current one is pointing to, if it exists.
     * 
     * @return the next Node a the current Node is pointing to
     */
    public Node<T> next() {
        return this.nextNode;
    }

    /**
     * Points the current Node to a newer Node.
     * 
     * @param elem the new Node that you will point to.
     */
    public void setNext(Node<T> elem) {
        this.nextNode = elem;
    }

    /**
     * Returns the data that the Node is holding.
     * 
     * @return the data of the Node.
     */
    public T getElement() {
        return this.data;
    }

    /**
     * Sets the data of the current node.
     * 
     * @param data the new data you want to write to the Node.
     * @throws IllegalArgumentException if the element passed is null
     */
    public void setElement(T data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Node cannot hold a null  element!");
        }
        this.data = data;
    }

    @Override
    public String toString() {
        T a = this.getElement();
        T b = (this.nextNode == null ? null : this.nextNode.getElement());
        return a + " -> " + b;
    }

    /**
     * Determines if two Nodes are equal. Two nodes are equal if they have
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
}