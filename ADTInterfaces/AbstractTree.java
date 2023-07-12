package ADTInterfaces;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * An abstract class describing the operations that can be done by the Tree
 * ADT. It will be implemented later by a class. This abstract base class
 * describes common behavior and structure of all Trees.
 * @param <T> the type that the tree holds
 * @author BlueBowser.
 */

 //TODO: finish implementing AbstractTree and test it
 //TODO: add methods that return Iterables so the user can iterate through the tree in any method they choose
public abstract class AbstractTree<T> {
    protected Node<T> head;
    protected int size;
    /**
     * Internal node class which represents a node on the tree.
     * @param <T> the type the node holds.
     * @author BlueBowser
     */
    protected static class Node<T> implements Position<T> {
        /**The element the Node holds */
        T element;
        /**The parent of the Node */
        Node<T> parent;
        /**The children of the Node, as an ArrayList that has 
         * Iterable<Node<T>>. */
        ArrayList<Node<T>> childs;

        /**
         * Creates a new tree Node holding an element
         * @param elem the element the Node will hold. Must not be null.
         * @throws IllegalArgumentException if the element passed is null.
         */
        public Node(T elem) throws IllegalArgumentException {
            if (elem == null) {
                throw new IllegalArgumentException("node cannot hold a null value!");
            }
            this.element = elem;
            this.childs = new ArrayList<Node<T>>();
        }

        /**
         * @return the element stored by the Node.
         */
        public T getElement() {
            return this.element;
        }

        /**
         * Sets Node to hold a new element {@code elem}.
         * @param elem the new element to store in the Node. Must not be null.
         * @throws IllegalArgumentException if the elemenet passed is null.
         */
        public void setElement(T elem) throws IllegalArgumentException {
            if (elem == null) {
                throw new IllegalArgumentException("element cannot be null!");
            }
        }

        /**
         * @return the parent of the Node.
         */
        public Node<T> parent() {
            return this.parent;
        }

        /**
         * @param newParent the new parent to set to the Node.
         */
        public void setParent(Node<T> newParent) {
            this.parent = newParent;
        }

        /**
         * This method returns an ArrayList of all the children of the current
         * Node. Using ArrayList funcitonality you can edit the ArrayList
         * inside (like by using this.children.add(3) to add Integer(3) as a
         * child.)
         * @return an ArrayList of all the children of the current Node.
         */
        public ArrayList<Node<T>> children() {
            return this.childs;
        }
    }

    public AbstractTree() {
        this.head = null;
        this.size = 0;
    }
    /**
     * The size of the tree.
     * @return the number of nodes in the tree
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the tree is empty.
     * @return {@code true} if the tree has no Nodes, {@code false}
     * otherwise.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the root's Position on the tree, returning null if the
     * tree is empty.
     * @return a Position pointing to the root of the tree, or {@code null}
     * if the tree is empty.
     */
    public Position<T> root() {
        return this.position(this.head);
    }

    /**
     * Turns a Node into a Position, returning null only in the case that the
     * tree is empty.
     * @param node the Node to turn into a Position
     * @return a Position representing the Node.
     */
    protected Position<T> position(Node<T> node) {
        return node;
    }

    /**
     * Internal function used to validate a Position and turn it into a Node.
     * A Position is invalid when its parent points back to the node.
     * @param p Position to validate
     * @return the Node that the Position was pointing to
     * @throws IllegalArgumentException if p is invalid
     */
    protected Node<T> validate(Position<T> p) {
        if (p == null) {
            throw new IllegalArgumentException("The tree is empty!");
        }
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid Position p!");
        }
        Node<T> node = (Node<T>) p;
        if (node.parent() == node) {
            throw new IllegalArgumentException("p is not in the tree anymore!");
        }
        return node;
    }

    /**
     * Reuturns the position of the parent node of {@code p}, returning null
     * if the Position has no parents.
     * @param p the Position of a node
     * @return the parent of a node
     */
    public Position<T> parent(Position<T> p) {
        return this.position(this.validate(p).parent());
    }

    /**
     * Returns an iterable collection of all the children of a node.
     * @param p the Position of a node
     * @return an object implementing Iterable that also contains the children
     * of the node at a Posiiton {@code p}
     */
    public Iterable children(Position<T> p) {
        return this.validate(p).children();
    }

    /**
     * Returns the number of children at a node.
     * @param p the Position of the node.
     * @return the number of childrena node has
     */
    public int numChilds(Position<T> p) {
        return this.validate(p).children().size();
    }

    /**
     * Checks if a node is internal (that the node has at least one child).
     * @param p a Position of a node
     * @return {@code true} if the node is internal, {@code false} otherwise
     */
    public boolean isInternal(Position<T> p) {
        if (this.numChilds(p) > 0) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the node is a leaf/external (that the node has no 
     * children).
     * @param p a Position of a node
     * @return {@code true} if the node is a leaf, {@code false} otherwise
     */
    public boolean isLeaf(Position<T> p) {
        return !isInternal(p);
    }

    /**
     * Checks whether the node is a root node (it has no parent)
     * @param p the Position of a node
     * @return {@code true} if the Node is a root, {@code false} otherwise
     */
    public boolean isRoot(Position<T> p) {
        return this.validate(p).paretn() == null;
    }

    /**
     * Returns the depth of a Node. The depth is how far the Node is from the
     * root node (how many ancestors does the node have). The depth of the 
     * root node is 0, and increases the more parents you have to get through
     * to reach the root node
     * @param p the position of the Node
     * @return the depth of the node in the tree
     */
    public int depth(Position<T> p) {
        if (this.isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }

    /**
     * Returns the height of the tree. The height of a tree is the maximum depth
     * of the tree. THe height of a leaf is zero, but the height of a node is
     * one plus the height of its parent.
     * @param p the Position of the Node
     * @return the height of the tree
     */
    public int height() {}

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
     * Sets the element located at Position {@code p} to {@code elem}
     * @param p Position of a certain node
     * @param elem the new element to store at the node
     * @return the last element stored at that Posiiton
     */
    public T set(Position<T> p, T elem);
    /**
     * Discards a node Position {@code p} from the tree, including all its
     * descendants.
     * @param p the Position of a certain node
     * @return the element of the deleted node.
     */
    public T delete(Position<T> p);
}
