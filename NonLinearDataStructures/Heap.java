package NonLinearDataStructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

import ADTInterfaces.Entry;
import ADTInterfaces.HeapInterface;
import ADTInterfaces.Position;

/**
 * This implements a minimum oriented heap. This type of heap is a special binary tree where the root node has the smallest element, smaller than its children. In this heap, it uses both the array-based implementation of a tree
 * and the linked node representation of a tree. I use both because it
 * is easier to take advantage of the BigO(1) time insertion and
 * deletions of an array-based implementation, while also not having
 * to reprogram an entire class for a binary tree.
 * @author BlueBowser
 * 
 */
public class Heap<K extends Comparable, V> implements HeapInterface<K, V> {

    /**
     * The binary tree that will hold the structure of the heap.
     */
    BinaryTree<Entry<K,V>> pile;

    /**The Comparator to use when comparing the elements. If no Comparator
     * is given in the constructor, it defaults to a minimum oriented comparator.
     */
    Comparator<K> comp;
    /**
     * The list that will hold the binary tree in array representation.
     * The array representaion is based on a function n(p) which maps
     * a node {@code p} to a nonnegative integar {@code n(p)} in the range
     * [0, size()-1];
     */
    ArrayList<Position<Entry<K,V>>> heapList;

    /**
     * The minimum oriented default Comparator. You can make it
     * maximum oriented by multiplying the result by negative one.
     */
    public class DefaultComparator<K> implements Comparator<K> {
        public int compare(K a, K b) throws ClassCastException {
            return ((Comparable) a).compareTo(b);
        }
    }


    public Heap() {
        this.pile = new BinaryTree<>();
        this.comp = new DefaultComparator<>();
        this.heapList = new ArrayList<>();
    }

    public Heap(Comparator<K> comp) {
        if (comp == null) {
            throw new IllegalArgumentException("parameter is null!");
        }
        this.comp = comp;
        pile = new BinaryTree<>();
        this.heapList = new ArrayList<>();
    }

    @Override
    public Entry<K, V> top() {
        if (pile.isEmpty()) {
            return null;
        }
        return pile.root().getElement();
    }

    @Override
    public void insert(K key, V val) throws IllegalArgumentException {
        checkIfNull(key); checkIfNull(val);
        Entry<K,V> entry = new Entry<K,V>(key, val);
        if (pile.size() == 0) {
            heapList.add(pile.addRoot(entry));
        } else {
            //create the node at the last index of the list
            Position<Entry<K,V>> parent = getParent(heapList.size());
            if (pile.isLeaf(parent)) {
                heapList.add(pile.addLeft(parent, entry));
            } else if (pile.left(parent) != null ) {
                heapList.add(pile.addRight(parent, entry));
            }
            //update and balance the tree
            upHeapBubble(heapList.get(heapList.size() - 1));
        }
    }

    @Override
    public Entry<K, V> removeTop() throws NoSuchElementException {
        if (pile.size() == 0) {
            throw new NoSuchElementException("the heap is empty!!!");
        }
        if (pile.size() == 1) {
            heapList.remove(heapList.size()-1);
            return pile.remove(pile.root());
        } else {
            Entry<K,V> rootEntry = pile.root().getElement();
            pile.set(pile.root(), heapList.get(heapList.size()-1).getElement());
            pile.remove(heapList.get(heapList.size()-1));
            heapList.remove(heapList.size()-1);
            downHeapBubble();
            return rootEntry;
        }
    }

    @Override
    public int size() {
        return pile.size();
    }

    @Override
    public boolean isEmpty() {
        return pile.isEmpty();
    }
    
    /**
     * Preforms an up heap bubble which rebalances the heap after
     * an insertion. An upheap bubble takes the previously inserted
     * element and compares it to its parent. If the tree is not balanced,
     * the parent and child are swapped, and the swapping happens until the
     * order is restored you reach the root.
     * @param pos it takes the leaf 
     */
    private void upHeapBubble(Position<Entry<K,V>> pos) {
        Position<Entry<K,V>> p = pos;
        while (p != pile.root()) {
            Position<Entry<K,V>> parent = pile.parent(p);
            if (comp.compare(p.getElement().getKey(), parent.getElement().getKey()) < 0) {
                swap(parent, p);
                p = parent;
            } else {
                break;
            }
        }
    }

    /**
     * Preforms a down heap bubble which restores the order of the
     * heap. It starts at the root and swaps the root node with the
     * child if the parent's key is not balanced, and continues down
     * until the tree is balanced again.
     */
    private void downHeapBubble() {
        Position<Entry<K,V>> pos = pile.root();
        Position<Entry<K,V>> child;
        while (!pile.isLeaf(pos)) {
            if (pile.right(pos) == null) {
                child = pile.left(pos);
            } else {
                //get child with the smaller key
                child = (comp.compare(pile.right(pos).getElement().getKey(), pile.left(pos).getElement().getKey())  > 0 ? pile.left(pos) : pile.right(pos));
            }

            if (comp.compare(pos.getElement().getKey(), child.getElement().getKey()) > 0) {
                swap(pos, child);
                pos = child;
            } else {
                break;
            }
        }
    }

    /**
     * Checks if an argument is null and throws an exception if it is.
     * @param elem Object to chefck to see if it is null.
     * @throws IllegalArgumentException if the argument is null
     */
    private void checkIfNull(Object elem) throws IllegalArgumentException {
        if (elem == null) {
            throw new IllegalArgumentException("an arguemnt is null!");
        }
    }

    /**
     * Gets the parent of the node located at index i in the list
     * @param i index of the child
     * @return a position of the parent of the child at the index,
     * or the root node if i is 0
     */
    private Position<Entry<K,V>> getParent(int i) {
        if (i == 0) {
            return heapList.get(0);
        } else {
            int parenti = i % 2;
            if (parenti == 0) {
                return heapList.get((i / 2) - 1);
            } else {
                return heapList.get((i / 2));
            }
        }
    }

    /**
     * Swaps the values of the positions.
     * @param p1 the first Position's value to be swapped
     * @param p2 the second Position's value to be swapped
     */
    private void swap(Position<Entry<K,V>> p1, Position<Entry<K,V>> p2) {
        Entry<K,V> child = p1.getElement();
        Entry<K,V> parent = p2.getElement();
        pile.set(p1, parent);
        pile.set(p2, child);
    }

    @Override
    public String toString() {
        return "Heap Priority Queue (" + size() + "):\t " + top();
    }
}
