package ADTInterfaces;
import java.util.Iterator;

/**
 * An interface describing the operations that can be done by the Tree ADT. It
 * will be implemented later by a class.
 */
public interface TreeInterface<T> extends Iterable<T> {
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
    public boolean isRoot(Position<T> p);

    public Iterator<T> iterator();
    public Iterator<Position<T>> positions();

    /**
     * Returns the depth of a Node. The depth is how far the Node is from the
     * root node (how many ancestors does the node have?). The depth of the 
     * root node is 0, and increases the more parents you have to get through
     * to reach the root node
     * @param p the position of the Node
     * @return the depth of the node in the tree
     */
    public int depth(Position<T> p);

    /**
     * Returns the height of the tree. The height of a tree is the maximum depth
     * of the tree. THe height of a leaf is zero, but the height of a node is
     * one plus the height of its parent.
     * @param p the Position of the Node
     * @return the height of the tree
     */
    public int height();

    /**
     * Returns an Iterator that iterates over the nodes in a preorder traversal,
     * using node Positions.
     * Preorder traversal is where you traverse a tree starting with a node,
     * doing an action to it, and then visiting each of tis children.
     * @return an Iterator iterating over the tree in a preorder fashion
     */
    public Iterator<T> preorder();

    /**
     * Returns an Iterator that iterates over the nodes in a post traversal,
     * using node Positions.
     * Postorder traversal is where you traverse a tree starting with a node,
     * visit its children first, and then do something with the children,
     * before you do something with the parent node.
     * Top down, going deeper when necessary and moving onto the next node.
     * @return an Iterator iterating over the tree in a preorder fashion
     */
    public Iterator<T> postorder();

    /**
     * Returns an Iterator that iterates over the nodes in a bredth-first
     *  traversal, using node Positions.
     * Breadth-first traversal is where you do something to all nodes of the
     * same depth, before moving a level lower and doing those nodes.
     * Bottom up, going higher when necessary and moving upwards towards the
     * next level.
     * @return an Iterator iterating over the tree in a preorder fashion
     */
    public Iterator<T> breadthFirst();

    /**
     * Returns an Iterator that iterates over the nodefs in a Euler Tour
     * traversal, using node Positions.
     * A Euler tour is where you start at the root node, and dig down and visit
     * every node, often times hitting internal nodes multiple times.
     * Top down, going deep as possible and hitting every node until you stop
     * at root.
     * @return
     */
    public Iterator<T> eulerTour();

    /**
     * Adds a root Node to an empty tree. It returns an error if the tree is not
     * empty.
     * @param elem the element to be added at the root
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<T> addRoot(T elem) throws IllegalStateException;

    /**
     * Adds a child to the node at Position {@code parent}
     * containing the element {@code elem}.
     * @param parent the Position of the node to add a child to
     * @param elem
     * @return the Position of the new child node.
     */
    public Position<T> addChild(Position<T> parent, T elem);
    /**
     * Sets the element located at Position {@code p} to {@code elem}
     * @param p Position of a certain node
     * @param elem the new element to store at the node
     * @return the last element stored at that Posiiton
     */
    public T set(Position<T> p, T elem);

    /**
     * Attatches a tree as a child to to Position {@code p}, making the root of
     * the {@code tree} a chlild of Position {@code p}
     * @param p the Position of a node. Node must be a leaf node.
     * @param tree the tree to attach to the branch
     * @throws IllegalStateException if {@code p} is not a leaf
     */
    public void attach(Position<T> p, TreeInterface<T> tree) throws IllegalStateException;
    /**
     * Removes node Position {@code p} from the tree, and make all of its
     * children the children of the parent node of Position {@code p}
     * @param p
     * @return the element of the deleted Node.
     */
    public T hoist(Position<T> p);

    /**
     * Discards a node Position {@code p} from the tree, including all its
     * descendants.
     * @param p the Position of a certain node
     * @return the element of the deleted node.
     */
    public T delete(Position<T> p);
}
