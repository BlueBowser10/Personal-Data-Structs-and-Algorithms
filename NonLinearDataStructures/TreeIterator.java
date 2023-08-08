package NonLinearDataStructures;

import ADTInterfaces.Position;
import LinearDataStructures.Queue;

/**
 * This is a class for iterating through the different types of trees.
 * It supports preorder, postorder, inorder, and Euler tours, especially for
 * BinaryTrees. It mainly does this by returning a queue of all the elements of
 * the tree, in the order the elements should be iterated in.
*/
public class TreeIterator<E> {

    /**The tree containing the position */
    private BinaryTree<E> tree;

    /**A queue that will be constructed based on the traversal method.
     * It will hold all the Positions in the subtree iterated by the 
     * iterator method. It will be overwritten with new methods after
     * each method call.
     */
    private Queue<Position<E>> iteratorQue;

    /**
     * Construsts a TreeIterator object with an empty Queue
     * @param tree the main Binary Tree the iterator will be working on.
     */
    public TreeIterator(BinaryTree<E> tree) {
        this.iteratorQue = new Queue<>();
        this.tree = tree;
    }

    /**
     * Returns a preorder transversal. A preorder transversal is one where
     * the parent nodes are acessed before the child nodes.
     * @return a Queue containing the Positions of the Nodes to iterate over.
     */
    public Queue<Position<E>> preorder(Position<E> marker) {
        emptyQueue();
        preorderInt(marker);
        return iteratorQue;
    }

    /**
     * Internal helper method for calling a preorder iterator.
     * @param node the recursive node to iterate on. Will stop 
     */
    private void preorderInt(Position<E> node) {
        iteratorQue.enqueue(node);
        if (tree.children(node).size() > 0) {
            for (Position<E> child : tree.children(node)) {
                preorderInt(child);
            }
        }
    }

    /**
     * Returns a preorder transversal. A preorder transversal is one where
     * the child nodes are acessed before the parent nodes.
     * @param marker the Position to start iterating at
     * @return a Queue containing the Positions of the Nodes to iterate over.
     */
    public Queue<Position<E>> postorder(Position<E> marker) {
        emptyQueue();
        postorderInt(marker);
        return iteratorQue;
    }

    /**
     * Internal method for postorder iteration.
     * @param pos recursive node to iterate over.
     */
    private void postorderInt(Position<E> pos) {
        if (tree.children(pos).size() > 0) {
            for (Position<E> child : tree.children(pos)) {
                postorderInt(child);
            }
        }
        iteratorQue.enqueue(pos);
    }

    /**
     * Returns an inorder transversal. A inorder transversal is one where
     * the left nodes are acessed before the parent nodes, and the parent nodes
     * are accessed before thei right nodes.
     * @param marker the Position to start iterating at
     * @return a Queue containing the Positions of the Nodes to iterate over.
     */
    public Queue<Position<E>> inorder(Position<E> marker) {
        emptyQueue();
        inorderInt(marker);
        return iteratorQue;
    }

    /**
     * Internal method for inorder iteration.
     * @param pos recursive node to iterate over.
     */
    private void inorderInt(Position<E> pos) {
        if (tree.left(pos) != null) {
            inorderInt(tree.left(pos));
        }
        iteratorQue.enqueue(pos);
        if (tree.right(pos) != null) {
            inorderInt(tree.right(pos));
        }
    }

    /**
     * Returns a Euler Tour transversal. A Euler Tour transversal is one where
     * you visit all the nodes in a tree at least once. You will iterate over
     * internal nodes more than once.
     * @param marker the Position to start iterating at
     * @return a Queue containing the Positions of the Nodes to iterate over.
     */
    public Queue<Position<E>> eulerTour(Position<E> marker) {
        emptyQueue();
        eulerTourInt(marker);
        return iteratorQue;
    }

    /**
     * Internal method for Euler Tour iteration.
     * @param pos recursive node to iterate over.
     */
    private void eulerTourInt(Position<E> pos) {
        iteratorQue.enqueue(pos);
        for (Position<E> child : tree.children(pos)) {
            eulerTourInt(child);
            iteratorQue.enqueue(pos);
        }
    }

    /**
     * Returns a breadth first transversal. A breadth first transversal is one where all nodes on the same depth are accessed first befor emoving lower.
     * @param marker the Position to start iterating at
     * @return a Queue containing the Positions of the Nodes to iterate over.
     */
    public Queue<Position<E>> breadthFirst(Position<E> marker) {
        emptyQueue();
        breadthFirstInt(marker);
        return iteratorQue;
    }

    /**
     * Internal method for bredth first iteration.
     * @param pos recursive node to iterate over.
     */
    private void breadthFirstInt(Position<E> pos) {
        Queue<Position<E>> pass = new Queue<>();
        pass.enqueue(pos);
        while(!pass.isEmpty()) {
            Position<E> node = pass.dequeue();
            iteratorQue.enqueue(node);
            if (tree.children(node).size() > 0) {
                for (Position<E> child : tree.children(node)) {
                    pass.enqueue(child);
                }
            }
        }
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
