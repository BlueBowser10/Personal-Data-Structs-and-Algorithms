package LinearDataStructures;
import java.util.Iterator;
import ADTInterfaces.Position;

public class PositionalListIterator<T> implements Iterator<T> {
    PositionalList<T> list;
    Position<T> pointer;
    public PositionalListIterator(PositionalList<T> list) {
        this.list = list;
        pointer = this.list.first();
    }
    public boolean hasNext() {
        if (list.after(pointer) == null) {
            return false;
        }
        return true;
    }
    public T next() {
        T lastElem = pointer.getElement();
        pointer = list.after(pointer);
        return lastElem;
    }
}