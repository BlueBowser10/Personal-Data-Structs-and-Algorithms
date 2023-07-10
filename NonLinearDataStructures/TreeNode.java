//TODO -- implement Tree Node
import java.util.ArrayList;
/**
 * This is a node of a generic Tree ADT. It holds the element an element, as
 *  well as the children of a node.
 * @param <T>
 * @author BlueBowser
 */
public class TreeNode<T> {
    /**The element the node holds */
    T element;

    /**The parent of the node. */
    TreeNode<T> parent;

    /**The children of the node. */
    ArrayList<TreeNode<T>> children;

    public TreeNode(T elem) {}
    public TreeNode() {}

    public T getElement() {}
    public void setElement() {}
    public TreeNode<T> parent() {}
    public ArrayList<TreeNode<T>> children() {}
    public int numChild() {}

    //tree methods
    public boolean isRoot() {}
    public boolean isLeaf() {}
    public boolean isInternal() {}
    public boolean isEmpty() {}
    public int depth(TreNode<T> node) {}
    public int height(TreNode<T> node) {}
    public TreeNode<T> root() {}
}