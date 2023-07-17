package ADTInterfaces;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class implements a Binary Tree ADT. This is a more specific
 * type of tree where a Node can have at most two children. They are
 * very useful for holding and sorting data.
 * @param <T> the type the Binary Tree holds
 * @author BlueBowser
 */
public class BinaryTree<T> {
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
        /**The left node. */
        Node<T> left;
        /**The right node. */
        Node<T> right;

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
            this.right = null;
            this.left = null;
            this.parent = null;
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
            this.element = elem;
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

        /**Gets the left node.
         * @returns the left node.
         */
        public Node<T> getLeft() {
            return left;
        }

        /**
         * Sets the left node.
         * @param left the new left node
         */
        public void setLeft(Node<T> left) {
            this.left = left;
        }

        /**
         * Gets the right node
         * @return the right node
         */
        public Node<T> getRight() {
            return right;
        }

        /**
         * Sets the right node.
         * @param right the new right node.
         */
        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

    public BinaryTree() {
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
        return this.validate(p).parent();
    }

    /**
     * Returns an ArrayList holding the Position of all the children of the node
     * located at Position p
     * @param p the Position of a node
     * @return an ArrayList of all the children of a Node
     */
    public ArrayList<Position<T>> children(Position<T> p) {
        Node<T> n = this.validate(p);
        ArrayList<Position<T>> arr = new ArrayList<>();
        if (n.getLeft() != null) {
            arr.add(this.position(n.getLeft()));
        }
        if (n.getRight() != null) {
            arr.add(this.position(n.getRight()));
        }
        return arr;
    }

    /**
     * Checks if a node is internal (that the node has at least one child).
     * @param p a Position of a node
     * @return {@code true} if the node is internal, {@code false} otherwise
     */
    public boolean isInternal(Position<T> p) {
        Node<T> n = this.validate(p);
        if ((n.getLeft() != null) || (n.getRight() != null)) {
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
     * Returns the left child of the node at Position {@code p}
     * @param p the Position of the Node
     * @return the left node's Position
     */
    public Position<T> left(Position<T> p) {
        return this.validate(p).getLeft();
    }

    /**
     * Returns the right child of the node at Position {@code p}
     * @param p the Position of the Node
     * @return the right node's Position
     */
    public Position<T> right(Position<T> p) {
        return this.validate(p).getRight();
    }

    /**
     * Returns the sibling of a node at Positon {@code p}, returning 
     * {@code null} if p has no siblings
     * @param p the Position of the Node
     * @return the sibling of the node at Position p
     */
    public Position<T> sibling(Position<T> pos) {
        Node<T> n = this.validate(pos);
        Node<T> p = n.parent();
        if (p.getRight() == n) {
            return p.getLeft();
        } else if (p.getLeft() == n) {
            return p.getRight();
        } else {
            return null;
        }
    }

    /**
     * Checks whether the node is a root node (it has no parent)
     * @param p the Position of a node
     * @return {@code true} if the Node is a root, {@code false} otherwise
     */
    public boolean isRoot(Position<T> p) {
        return this.validate(p).parent() == null;
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
     * Returns the height of the subtree rooted at Position {@code p}.
     * The height of a tree is the maximum depth of the tree. THe height of 
     * a leaf is zero, but the height of a node is one plus the height of its 
     * parent.
     * @param p the Position of the Node
     * @return the height of the tree
     */
    public int height(Position<T> p) {
        int height = 0;
        for (Position<T> c : children(p)) {
            height = Math.max(height, 1 + height(c));
        }
        return height;
    }

    /**
     * Adds a root Node to an empty tree. It returns an error if the tree is not
     * empty.
     * @param elem the element to be added at the root
     * @throws IllegalStateException if the tree is not empty
     * @throws IllegalArgumentException if elem is null
     */
    public Position<T> addRoot(T elem) throws IllegalStateException {
        if (!this.isEmpty()) {
            throw new IllegalStateException("Tree is not empty!");
        }
        if (elem == null) {
            throw new IllegalArgumentException("elem must not be null!");
        }
        this.head = new Node<>(elem);
        return this.head;
    }
    /**
     * Sets the element located at Position {@code p} to {@code elem}
     * @param p Position of a certain node
     * @param elem the new element to store at the node. Must not be null.
     * @return the last element stored at that Posiiton
     */
    public T set(Position<T> p, T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("element must not be null!");
        }
        Node<T> n = this.validate(p);
        T lastElem = n.getElement();
        n.setElement(elem);
        return lastElem;
    }
    /**
     * Discards a node Position {@code p} from the tree, including all its
     * descendants.
     * @param p the Position of a certain node
     * @return the element of the deleted node.
     */
    public T delete(Position<T> p) {
        if (children(p).size() > 1) {
            throw new IllegalStateException("p has two children, it must have only one to be inserted into the list.");
        }
        T lastElem = p.getElement();
        Node<T> node = validate(p);

        if (node.parent().getLeft() == node) {
            node.parent().setLeft(null);
        } else if (node.parent().getRight() == node) {
            node.parent().setRight(null);
        }
        node.setParent(node);
        return lastElem;
    }

    /**
     * Adds a left child to Position p.
     * @param p a Position of a certain node
     * @param elem the element to add as a child.
     * @throws IllegalStateException if p already has a left child
     * @throws IllegalArgumentException if elem is null
     */
    public Position<T> addLeft(Position<T> p, T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("elem cannot be null!");
        }
        Node<T> n = validate(p);
        if (n.getLeft() != null) {
            throw new IllegalStateException("p already has a left child.");
        }
        Node<T> newNode = new Node<>(elem);
        n.setLeft(newNode);
        newNode.setParent(n);
        return newNode;
    }

    /**
     * Adds a right child to Position p.
     * @param p a Position of a certain node
     * @param elem the element to add as a child.
     * @throws IllegalStateException if p already has a right child
     * @throws IllegalArgumentException if elem is null
     */
    public Position<T> addRight(Position<T> p, T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("elem cannot be null!");
        }
        Node<T> n = validate(p);
        if (n.getRight() != null) {
            throw new IllegalStateException("p already has a left child.");
        }
        Node<T> newNode = new Node<>(elem);
        n.setRight(newNode);
        newNode.setParent(n);
        return newNode;
    }

    /**
     * Attaches two subtrees rooted at {@code l} and {@code r} to
     * a leaf node rooted at {@code pos}.
     * @param 
     * @param
     * @param
     * @throws
     */
    public void attach(Position<T> pos, Position<T> l, Position<T> r) {
        if (!isLeaf(pos)) {
            throw new IllegalStateException("the Position is not a leaf!");
        } else {
            Node<T> node = validate(pos);
            Node<T> left = validate(l);
            Node<T> right = validate(r);
            
            node.setLeft(left);
            node.setRight(right);
            left.setParent(node);
            right.setParent(node);
        }
    }
}
