package ADTInterfaces;

/**
 * A map is a type of associative array. Maps map key-value pairs, and when you
 * input a key into the map, it returns its associated value. THere are many
 * ways to implement maps, ranging form simple Lists to Trees to hast tables.
 * This is an interface meant to outline the specific methods.
 * @param <K> the key of the entry. Must be comparable to itself.
 * @parm <V> the value of the entry.
 * @author BlueBOwser
 */
public interface Map<K extends Comparable, V> {
    /**
     * Returns the number of entries in the map.
     * @return the number of entries in the map.
     */
    public int size();

    /**
     * Deternimes whetehr the mpa is empty
     * @return {@code true} if the Map is empty, {@code false} if it is not
     */
    public boolean isEmpty();

    /**
     * Gets the associated value of the key, if it exists, or {@code null} if
     * the entry does not exist.
     * @param key the key of the entry to look for.
     * @return the value associated with the entry.
     */
    public V get(K key);

    /**
     * Inserts the associated key-val pair into the Map.
     * @param key the key. Must not be null.
     * @param val the value. must not be null.
     * @throws IllegalArgumentException if either of the argumetns are null
     */
    public void put(K key, V val) throws IllegalArgumentException;

    /**
     * Removes an entry from the Map whose entry matches the given key, and
     * returns its value
     * @param key they key we are looking for
     * @return the values associated with the key, or {@code null} if the
     * key is not in the dictionary.
     */
    public V remove(K key);

    /**
     * Gives a list of all the keys in the list.
     * @return an Iterable containing all the keys in the list.
     */
    public Iterable<K> keys();

    /**
     * GIves a list of all the values in the list.
     * @return
     */
    public Iterable<V> values();

    /**
     * Gives an Iterable of all the entries in the Map.
     * @return
     */
    public Iterable<Entry<K,V>> entrySet();
}