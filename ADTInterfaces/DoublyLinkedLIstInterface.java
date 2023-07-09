package ADTInterfaces;

import java.util.NoSuchElementException;

/**
 * This is the interface for a DoublyLinkedList.
 * @param <T> the type the list holds
 * @author BlueBowser
 * @see SinglyLinkedList for more methods that are inherited with a LinkedList
 */
public interface DoublyLinkedLIstInterface<T> extends SinglyLinkedList<T> {
    /**
     * Reemoves the the item at the end of the list, if any exist
     * @return the last time that was removed from the beginning.
     * @throws NoSuchElementException when the list is empty
     */
    public abstract T removeLast() throws NoSuchElementException;

}