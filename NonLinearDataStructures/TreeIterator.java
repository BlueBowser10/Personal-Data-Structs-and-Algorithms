package NonLinearDataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ADTInterfaces.Position;
import LinearDataStructures.Deque;
import LinearDataStructures.Queue;

/**
 * This is a class for iterating through the different types of trees.
 * It supports preorder, postorder, inorder, and Euler tours, especially for
 * BinaryTrees. It mainly does this by returning a queue of all the elements of
 * the tree, in the order the elements should be iterated in.
*/
public class TreeIterator<E> {

    /**Where to start iterating from in tree. */
    private Position<E> marker;
    
    /**
     * Gets the position where the Tree is going to start iterating.
     */
    public Position<E> getMarker() {
        return marker;
    }

    /**
     * Sets the position that the tree will start iterating at.
     * @param marker
     */
    public void setMarker(Position<E> marker) {
        this.marker = marker;
    }


    /**The tree containing the position */
    private BinaryTree<E> tree;

    /**A queue that will be constructed based on traversal called.
     * It will initially be empty.
     */
    private Queue<E> iteratorQue;

    /**
     * Construsts a TreeIterator object with an empty Queue
     * @param marker
     * @param tree
     * @param mode
     */
    public TreeIterator(Position<E> marker, BinaryTree<E> tree, TreeIteratorEnum mode) {
        iteratorQue = new Queue<>();
        this.marker = marker;
        this.tree = tree;
    }

    public Queue<E> preorder() {
        emptyQueue();
        preorder(marker);
        return iteratorQue;
    }

    /**
     * Internal helper method for calling a preorder iterator.
     * @param node the recursive node to iterate on. Will stop 
     */
    private void preorder(Position<E> node) {
        iteratorQue.enqueue(node.getElement());
        if (tree.children(node).size() > 0) {
            for (Position<E> child : tree.children(node)) {
                preorder(child);
            }
        }
    }

    public Queue<E> postorder() {
        postorder(marker);
        return iteratorQue;
    }

    private void postorder(Position<E> pos) {
        if (tree.children(pos).size() > 0) {
            for (Position<E> child : tree.children(pos)) {
                preorder(child);
            }
        }
        iteratorQue.enqueue(pos.getElement());
    }

    public Queue<E> inorder() {
        emptyQueue();
        inorder(marker);
        return iteratorQue;
    }

    private void inorder(Position<E> pos) {
        if (tree.left(pos) != null) {
            inorder(tree.left(pos));
        }
        iteratorQue.enqueue(pos.getElement());
        if (tree.right(pos) != null) {
            inorder(tree.right(pos));
        }
    }

    public Queue<E> eulerTour() {
        emptyQueue();
        eulerTour(marker);
        return iteratorQue;
    }

    private void eulerTour(Position<E> pos) {
        
    }


    /**
     * Before an iteration, the queue must be empty to work properly. If it
     * is not empty, empty it.
     */
    private void emptyQueue() {
        if (!iteratorQue.isEmpty()) {
            iteratorQue = new Queue<>();
        }
    }
}
