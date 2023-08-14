package LinearDataStructures;
import ADTInterfaces.Entry;
import ADTInterfaces.Map;
import ADTInterfaces.Position;


/**
 * This implements an Unsorted Map implemented using a list. This Map is
 * by far the easiest to use, although it requires O(n) time to find an elment.
 * Due to this issue, I use something called the move-to-front heuristic,
 * where after the element is accessed, it is moved to the front of the list.
 * Theoretically, this makes sense, as more important elements are moved
 * to the front, saving time.
 * @param <K> the key of an entry. Must be Comparable.
 * @param <V> the value of an entry.
 * @author BlueBowser
 */
public class UnsortedListMap<K extends Comparable, V> implements Map<K,V> {

    /**
     * The list that holds the entries of the Map.
     */
    private PositionalList<Entry<K,V>> list;

    public UnsortedListMap() {
        list = new PositionalList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public V get(K key) {
        checkIfNull(key);
        if (list.isEmpty()) {
            return null;
        }
        Position<Entry<K,V>> pos = list.first();
        while (pos != null) {
            K k = pos.getElement().getKey();
            if (k.equals(key)) {
                list.addFirst(list.remove(pos));
                return pos.getElement().getVal();
            }
        }
        return null;
    }

    @Override
    public void put(K key, V val) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }

    @Override
    public Iterable<K> keys() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keys'");
    }

    @Override
    public Iterable<V> values() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'values'");
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entrySet'");
    }
    
    private void checkIfNull(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("the argument is null!");
        }
    }

    @Override
    public V remove(K key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
}
