package ADTInterfaces;

/**
 * An interface describing the operations that can be done by the Tree ADT. It
 * will be implemented later by a class.
 */
public interface TreeInterface<T> implements Iterable<T> {
    /**
     * The size of the tree.
     * @return the number of nodes in the tree
     */
    public int size();

    /**
     * Checks if the tree is empty.
     * @return {@code true} if the tree has no Nodes, {@code false}
     * otherwise.
     */
    public int isEmpty();

    /**
     * Returns the root's Position on the tree, returning null if the
     * tree is empty.
     * @return a Position pointing to the root of the tree
     */
    public Position<T> root();

    /**
     * Reuturns the position of the parent node of {@code p}, returning null
     * if the Position has no parents.
     * @param p the Position of a node
     * @return the parent of a node
     */
    public Position<T> parent(Position<T> p);

    /**
     * Returns an iterable collection of all the children of a node
     * @param p the Position of a node
     * @return an object implementing Iterable that also contains the children
     * of the node at a Posiiton {@code p}
     */
    public Iterable<T> children(Position<T> p);

    /**
     * Returns the number of children at a node.
     * @param p the Position of the node.
     * @return the number of childrena node has
     */
    public int numChilds(Position<T> p);

    /**
     * Checks if a node is internal (that the node has at least one child).
     * @param p a Position of a node
     * @return {@code true} if the node is internal, {@code false} otherwise
     */
    public boolean isInternal(Position<T> p);

    /**
     * Checks whether the node is a leaf/external (that the node has no 
     * children).
     * @param p a Position of a node
     * @return {@code true} if the node is a leaf, {@code false} otherwise
     */
    public boolean isLeaf(Position<T> p);

    /**
     * Checks whether the node is a root node (it has no parent)
     * @param p the Position of a node
     * @return {@code true} if the Node is a root, {@code false} otherwise
     */
    public boolean isRoot(Posiiton<T> p);

    public Iterator<T> iterator();
    public Iterator<Position<T>> positions();

    /**
     * Returns the depth of a Node. The depth is 
     * @param p
     * @return
     */
    public int depth(Position<T> p);
    public int height(Position<T> p);

    public Iterator<T> preorder();
    public Iterator<T> postorder();
    public Iterator<T> breadthFirst();
    public Iterator<T> eulerTour();
}
