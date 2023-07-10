import ADTInterfaces.Position;

/**
 * This is an implementation of a Positional List ADT, a more abstract version 
 * of a List ADT more suited for DoublyLinkedLists. It uses Nodes that have 
 * Position, so externally you can keep track of where you are in the list, 
 * while also having access to the internal list structure. It operates 
 * similarly to a List.
 * @param <T> the type that the list holds
 * @author BlueBowser
 * @see Position
 */
public class PositionalList<T> {

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

    
}
