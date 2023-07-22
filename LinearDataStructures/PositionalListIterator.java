package LinearDataStructures;
import java.util.Iterator;
import ADTInterfaces.Position;

/**
 * An Iterator for iterating through the Positions of a PositionalList.
 * @param <T> the type the Iterator holds
 * @author BlueBowser
 * @see PositionalList
 */
public class PositionalListIterator<T> implements Iterator<T> {
    PositionalList<T> list;
    Position<T> pointer;
    public PositionalListIterator(PositionalList<T> list) {
        this.list = list;
        pointer = this.list.first();
    }
    @Override
    public boolean hasNext() {
        if (list.after(pointer) == null) {
            return false;
        }
        return true;
    }
    @Override
    public T next() {
        if (pointer == null) {
            throw new IllegalStateException("No more positions to iterate over.");
        }
        T lastElem = pointer.getElement();
        pointer = list.after(pointer);
        return lastElem;
    }
}