package LinearDataStructures;
import java.util.NoSuchElementException;

import ADTInterfaces.StackInterface;

/**
 * This class implements a dynamic Stack ADT using a LinkedList. 
 * @param <T> the element the stack holds
 * @author BlueBowser
*/
public class Stack<T> implements StackInterface<T> {
    /** The LinkedList that will hold the Stack data. */
    private LinkedList<T> pile;

    /** Default consturctor which creates an empty Stack. */
    public Stack() {
        pile = new LinkedList<>();
    }

    @Override
    public int size() {
        return this.pile.size();
    }

    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    @Override
    public void push(T elem) throws IllegalArgumentException {
        if (elem == null) {
            throw new IllegalArgumentException("cannot push null value to stack!");
        }
        this.pile.addFirst(elem);
    }

    @Override
    public T pop() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("the stack is empty!");
        }
        return this.pile.removeFirst();
    }

    @Override
    public T top() {
        if (this.isEmpty()) {
            return null;
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