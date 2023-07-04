import java.util.Iterator;

/**This class implements a Circularly Linked List ADT, where the tail Node links
 * to the head Node.
 * @param <T> the type that the list holds
 */
public class CircularyLinkedList<T> implements SinglyLinkedList<T>, Iterable<T> {
    /**An iterator for the CirculalyLinkedList. This inner class can help to
     * iterate through the list, starting from head to tail.
     * @param <T> the type that the iterator holds
     * @author BlueBowser
    */
    public class CircularListIterator<T> implements Iterator<T> {
        /** The Node representing the start of the list. */
        Node list;
        /** whether the iterator has reached the head after iterating around
         * the circle.
         */
        boolean fullCircle;
        /** Default constructor that creates an Iterator that starts at the
         * head node.
         */
        public CircularListIterator() {
            list = head;
            fullCircle = false;
        }
        /**
         * Sees if the iterator can continue iterating, and an node exists
         * at the current point.
         * @return a boolean: {@code true} if there is another node to
         * iterate on, {@code false} otherwise.
         */
        public boolean hasNext() {
            if ((list == null) || (fullCircle && list == head)) {
                return false;
            }
            return true;
        }

        /**
         * Returns the element at the current node and advances to the next
         * node, stopping when the head has been reached.
         * @return the current element at the next 
         * @throws IllegalStateException if you finish iterating and you reached
         * the head or the list is empty
         */
        public T next() throws IllegalStateException {
            if (!hasNext()) {
                throw new IllegalStateException("no more iterable nodes!",
                    null);
            }
            if (list == head) {
                fullCircle = true;
            }
            T elem = (T) list.getElement();
            list = list.next();
            return elem;
        }
    }
    
    /**The head of the list. */
    private Node<T> head;
    /**The tail of the list. If the size of the list is 1, the tail will be
     * the same Node as the {@code head} is. It will always point to the head.*/
    private Node<T> tail;
    /**The size of the list (the number of Nodes in the list) */
    private int size;

    /** Default constructor for a circularly linked list. */
    public CircularyLinkedList() {
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
    public void addFirst(T elem) {
        Node<T> node = new Node<>(elem);
        if (this.isEmpty()) {
            node.setNext(node);
            this.head = node;
            this.tail = this.head;
        } else {
            node.setNext(this.head);
            this.tail.setNext(node);
            this.head = node;
        }

        ++this.size;
    }

    @Override
    public void addLast(T elem) {
        Node<T> node = new Node<>(elem);
        if (this.isEmpty()) {
            node.setNext(node);
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.setNext(node);
            node.setNext(this.head);
            this.tail = node;
        }

        ++this.size;
    }

    @Override
    public T removeFirst() throws IndexOutOfBoundsException {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("the list is empty!");
        } else {
            T data;
            if (this.size == 1) {
                data = this.head.getElement();
                this.head = null;
                this.tail = null;
            } else {
                data = this.head.getElement();
                this.tail.setNext(this.head.next());
                this.head = this.head.next();
            }

            --this.size;
            return data;
        }
    }

    @Override
    public T first() throws IndexOutOfBoundsException {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("the list is empty!");
        }
        return this.head.getElement();
    }

    @Override
    public T last() throws IndexOutOfBoundsException {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("this list is empty!");
        }
        return this.tail.getElement();
    }

    /**
     * Rotates around the circularly linked list by advancing the head
     * and tail by one, setting the head to the next Node and the tail
     * to the next Node.
     */
    public void rotate() {
        this.tail = this.tail.next();
        this.head = this.head.next();
    }

    @Override
    public String toString() {
        String f = "Circularly Linked List (" + this.size + "):\n\t";
        if (this.isEmpty()) {
            f += "None";
        } else if (this.size == 1) {
            f += this.head.getElement() + "-->\n\t";
        } else {
            Node<T> node = this.head;
            while (node != this.tail) {
                f += node.getElement() + " -->\n\t";
                node = node.next();
            }
            f += node.getElement() + " --> \n";
        }
        return f;
    }

    @Override
    public CircularListIterator<T> iterator() {
        return new CircularListIterator<T>();
    }
}
