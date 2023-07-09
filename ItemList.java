import ATDInterfaces.ListInterface;

/**
 * This is an implementation of the List ADT. It uses a doubly linked
 * list that can insert nodes at specific positions as its backbone.
 * @param <T> the type that the list holds
 * @author BlueBowser
 */
public class ItemList<T> implements ListInterface<T> {
    /**The doubly linked list that is the backbone of the list.*/
    private DoublyLinkedList<T> list;

    /**
     * Default constructor which creates an empty ItemList.
     */
    public ItemList() {
        list = new DoublyLinkedList<>();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public T get(int i) throws IndexOutOfBoundsException {
        return this.list.get(i);
    }

    @Override
    public void set(int i, T elem) throws IllegalArgumentException, IndexOutOfBoundsException {
        this.list.set(elem, i);
    }

    @Override
    public void add(int i, T elem) throws IllegalArgumentException, IndexOutOfBoundsException {
        this.list.insert(elem, i);
    }

    @Override
    public void add(T elem) throws IllegalArgumentException, IndexOutOfBoundsException {
        this.list.addLast(elem);
    }

    @Override
    public T remove(int i) throws IndexOutOfBoundsException {
        return this.list.remove(i);
    }

    @Override
    public String toString() {
        return "List " + this.list.toString().substring(19);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ItemList)) {
            return false;
        }
        ItemList other = (ItemList) o;
        return this.list.equals(other.list);
    }
    
}