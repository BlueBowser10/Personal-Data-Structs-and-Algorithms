import java.util.NoSuchElementException;

/**
 * This class implements a dynamic Stack ADT using a LinkedList. 
 * @param <T> the element the stack holds
 * @author BlueBowser
*/
public class Stack<T> {
    /** The LinkedList that will hold the Stack data. */
    private LinkedList<T> pile;

    /** Default consturctor which creates an empty Stack. */
    public Stack() {
        pile = new LinkedList<>();
    }

    /**
     * Returns the number of elements in the Stack.
     * @return the number of elements in the stack.
     */
    public int size() {
        return this.pile.size();
    }

    /**
     * Checks whether the stack is empty or not.
     * @return a boolean: {@code true} if the list is empty and {@code false}
     * otherwise.
     */
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    /**
     * Places an element on the top of a Stack.
     * @param elem the element to be pushed to the stack. Must not be null.
     * @throws IllegalArgumentException when the element passed is null
     */
    public void push(T elem) throws IllegalArgumentException {
        if (elem == null) {
            throw new IllegalArgumentException("cannot push null value to stack!");
        }
        this.pile.addFirst(elem);
    }

    /**
     * Removes the top element on the Stack.
     * @return the elemement on top of the stack.
     * @throws NoSuchElementException if the list is empty
     */
    public T pop() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the stack is empty!");
        }
        return this.pile.removeFirst();
    }

    /**
     * Looks at the top element on the stack.
     * @return the top element on the stack
     * @throws NoSuchElementException if the list is empty
     */
    public T top() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the stack is empty!");
        }
        return this.pile.first();
    }

    @Override
    public String toString() {
        //kind of hacky, need to fix toString
        return "Stack" + pile.toString().substring(12);
    }

    /**
     * Determines if two Stacks are equal. Two stacks are equals if they have
     * the same elements of the same type in the same order.
     * @param o object to be checked
     * @return a boolean: {@code true} if the objects are equal
     *  and {@code false} otherwise.
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Stack)) {
            return false;
        }
        Stack other = (Stack) o;
        return this.pile.equals(other.pile);
    }
}