package ADTInterfaces;
/**
 * <pre>
 * This is an interface for the concept of a Position. Think of a position as a 
 * certain marker or tab which keeps track of a certain element in the list. 
 * This "marker" will never change, even if the list is updated. This means 
 * that we can have O(1) insertions and deletions around the Position marker. 
 * 
 * Positions also give us a way to access the internal node structure of a 
 * list. We want to follow the principles of encapsulation, so having a 
 * Position interface allows us to technically view the nodes without having to 
 * interact with the objects.
 * </pre>
 * @param <T> the type of element in a Position
 * @author BlueBowser
 */
public interface Position<E> {
    /**
     * Gets the element of the Position.
     */
    public E getElement();
}