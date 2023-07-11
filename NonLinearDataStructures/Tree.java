import java.util.Iterator;

import ADTInterfaces.Position;
import ADTInterfaces.TreeInterface;

/**
 * This implements a Tree ADT. A tree is a linked node structure where there is
 * a root node, and the root node branches out into other nodes. This is a
 * very general tree, with no restrictions on the number of children a node can
 * have.
 * 
 * @param <T> the type the tree holds
 * @author BlueBowser
 * @see TreeInterface
 */
public class Tree<T> implements TreeInterface<T> {
    /**
     * Internal node class which represents a node on the tree.
     * @param <T> the type the node holds.
     */
    private class Node<T> implements Position<T> {
        T element;
        Node<T> parent;
        ArrayList<Node<T>> childs;

        pubilc Node(T elem) {}

        public T getElement() {}
        public T setElement() {}

        public Node<T> parent() {}
        public void setParent(Node<T> newParent) {}

        public ArrayList<Node<T>> children() {}
        public void addChild(Node<T> node) {}
        public Node<T> removeChild(Node<T> node) {}
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public int isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public Position<T> root() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'root'");
    }

    @Override
    public Position<T> parent(Position<T> p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parent'");
    }

    @Override
    public Iterable<T> children(Position<T> p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'children'");
    }

    @Override
    public int numChilds(Position<T> p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'numChilds'");
    }

    @Override
    public boolean isInternal(Position<T> p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isInternal'");
    }

    @Override
    public boolean isLeaf(Position<T> p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isLeaf'");
    }

    @Override
    public boolean isRoot(Position<T> p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isRoot'");
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Iterator<Position<T>> positions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'positions'");
    }

    @Override
    public int depth(Position<T> p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depth'");
    }

    @Override
    public int height() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'height'");
    }

    @Override
    public Iterator<T> preorder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'preorder'");
    }

    @Override
    public Iterator<T> postorder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postorder'");
    }

    @Override
    public Iterator<T> breadthFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'breadthFirst'");
    }

    @Override
    public Iterator<T> eulerTour() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eulerTour'");
    }

    @Override
    public Position<T> addRoot(T elem) throws IllegalStateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addRoot'");
    }

    @Override
    public Position<T> addChild(Position<T> parent, T elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addChild'");
    }

    @Override
    public T set(Position<T> p, T elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void attach(Position<T> p, TreeInterface<T> tree) throws IllegalStateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attach'");
    }

    @Override
    public T hoist(Position<T> p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hoist'");
    }

    @Override
    public T delete(Position<T> p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
