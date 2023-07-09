package ADTInterfaces;

/**
 * This is the interface for a DoublyLinkedList.
 */
public interface DoublyLinkedLIstInterface<T> extends SinglyLinkedList<T> {
    public abstract void addLast(T eleme) throws IllegalArgumentException;
    
}
