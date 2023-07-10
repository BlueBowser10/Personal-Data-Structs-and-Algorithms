package ADTInterfaces;

/**
 * This interface describes the operations of a Positional List ADT. it will
 * be implemented later with a class.
 */
public interface PositionalListInterface<T> {
    /**
     * Returns the Position of the first element in the list.
     * @return the Position of the first element in the list, or {@code null} if
     * it does not exist.
     */
    public Position<T> first();

    /**
     * Returns the Position of the last element in the list, or {@code null} if\
     * it does not exist.
     * @return the Position of the last element
     */
    public Position<T> last();

    /**
     * Returns the Position of the element right before {@code p}.
     * @param p the Position of an element
     * @return the Position of the previous element, or {@code null} if there is
     * no previous node. 
     */
    public Position<T> before(Position<T> p);

    /**
     * Returns the Position of the element right after {@code p}.
     * @param p the Position of an element
     * @return the Position of the next element, or {@code null} if there is
     * no previous node. 
     */
    public Position<T> after(Position<T> p);

    /**
     * Checks if the list is empty.
     * @return {@code true} if the list is empty and false otherwise.
     */
    public boolean isEmpty();

    /**
     * The size of the List.
     * @return the size of the list.
     */
    public int size();

    /**
     * Adds an element to the beginning of the list.
     * @param elem the element to be added
     * @return the Position of the element just added.
     */
    public Position<T> addFirst(T elem);

    /**
     * Adds an element to the end of the list.
     * @param elem the element to be added
     * @return the Position of the element just added.
     */
    public Position<T> addLast(T elem);

    /**
     * Adds an element right before the Position {@code p}.
     * @param p the Poistion of an element
     * @param elem the element to be added
     * @return the Position of the element just added.
     */
    public Position<T> addBefore(Position<T> p, T elem);

    /**
     * Adds an element right before the Position {@code p}.
     * @param p the Poistion of an element
     * @param elem the element to be added
     * @return the Position of the element just added.
     */
    public Position<T> addAfter(Position<T> p, T elem);

    /**
     * Changes the element at Position {@code p} to a new element
     * @param p the Position of a certain element
     * @param elem the new element to be written to the Position
     * @return the previous element at p
     */
    public T set(Position<T> p, T elem);

    /**
     * Removes the Node at the Position from the list
     * @param p the Position of a certain element
     * @return the element previously at that Position
     */
    public T remove(Position<T> p);
}