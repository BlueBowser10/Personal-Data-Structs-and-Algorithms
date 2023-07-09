package ADTInterfaces;

/**
 * This is the interface containing all the methods for a cirularly linked list.
 * It will be implemented later using classes.
 * @param <T> the type the list holds
 * @author BlueBowser
 * @see SinglyLinkedList
 */
public interface CircularlyLinkedListInterface<T> extends SinglyLinkedList<T> {
    /**
     * Rotates around the circularly linked list by advancing the head
     * and tail by one, setting the head to its next Node and the tail
     * to its next Node.
     */    
    public abstract void rotate();       
}
