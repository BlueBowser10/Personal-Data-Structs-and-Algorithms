/**
 * This is a private generic Node class used to represent the Node
 * of a linked list.
 */
public class Node<T> {
    /** the data that the Node holds */
    private T data;

    /** the next Node on the list */
    private Node<T> nextNode;

    /**
     * Creates a Node holding an element T, and the Node does not
     * point to any other Node
     */
    public Node(T elem) {
        this.data = elem;
        this.nextNode = null;
    }

    /** Default constructor that creates an empty Node not pointing to anything. */
    public Node() {
        this(null);
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
     * Sets the data of the current node
     * 
     * @param data the new data you want to write to the Node.
     */
    public void setElement(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        T a = this.getElement();
        T b = (this.nextNode == null ? null : this.nextNode.getElement());
        return a + " -> " + b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        Node other = (Node) o;
        if (this.data == null) {
            if (other.data == null) {
                return true;
            }
            return false;
        }
        return this.data.equals(other.data);
    }
}