package ADTInterfaces;

    /**
     * This describes an entry, which consists of a
     * non-null key {@code K} and non null entry {@code V}. {@code K} must
     * be comparable to itself. Entries are used in structures like Maps
     * and Priority Queues, when certain values are associated with other
     * values.
     * @param <K> the value of the key used to acces the Entry. It must
     * be Comparable.
     * @param <V> the value stored in the entry
     * @author BlueBowser
     */
    public class Entry<K extends Comparable, V> {
        /**the priority of the entry. Must not be null. */
        K key;
        /**the key of the entry. Must not be null. */
        V val;

        /**
         * Constructs an Entry.
         * @param key the priority of the entry. Must not be null.
         * @param val the content of the entry. Must not be null.
         * @throws IllegalArgumentException If either of the entries are null
         */
        public Entry(K key, V val) throws IllegalArgumentException {
            checkIfNull(key);
            checkIfNull(val);
            this.key = key;
            this.val = val;
        }

        /**
         * Gets the priority of the entry.
         * @return the priority of the entry
         */
        public K getKey() {
            return key;
        }

        /**
         * since the priority of the entry to a new key.
         * @param key The new priority. Must not be null.
         * @throws IllegalArgumentException If the key is null
         */
        public void setKey(K key) throws IllegalArgumentException {
            checkIfNull(key);
            this.key = key;
        }

        /**
         * Gets the content of the entry.
         * @return The content of the entry
         */
        public V getVal() {
            return val;
        }
        /**
         * set the new value of the entry.
         * @param val The new value. Must not be null
         * @throws IllegalArgumentException if the value is null.
         */
        public void setVal(V val) throws IllegalArgumentException {
            checkIfNull(val);
            this.val = val;
        }
        
        @Override
        public String toString() {
            return "Entry " + key.toString() + ":\t" + val.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(this instanceof Entry)) {
                return false;
            }
            Entry<K, V> other;
            try {
                other = (Entry<K, V>) o;
            } catch (ClassCastException e) {
                System.out.println("whoops, entry key or value types not compatible...");
                return false;
            }

            if (this.key.equals(other.key) && this.val.equals(other.val)) {
                return true;
            }
            return false;
        }

        /**
         * Internal function to check if an argument is null.
         * @param o the argument to check
         * @throws IllegalArgumentException if the argument is null.
         */
        private void checkIfNull(Object o) throws IllegalArgumentException {
            if (o == null) {
                throw new IllegalArgumentException("argument is null!");
            }
        }
    }
