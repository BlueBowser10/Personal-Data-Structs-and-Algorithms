

import ADTInterfaces.Position;

/**
 * This imterface describes the behavior of a very general Tree with no
 * restrictions on the number of children a node can have. This will be
 * implemented later by a class.
 * @param <T> the type the tree holds
 * @author BlueBowser
 * @see AbstractTree for more info on the other methods.
 */
//TODO: implement AbstractTree first
public class LimitedTree<T> extends AbstractTree<T> {
    /**
     * Adds a child to the node at Position {@code parent}
     * containing the element {@code elem}.
     * @param parent the Position of the node to add a child to
     * @param elem
     * @return the Position of the new child node.
     */
    public Position<T> addChild(Position<T> parent, T elem);
    /**
     * Attatches a tree as a child to to Position {@code p}, making the root of
     * the {@code tree} a chlild of Position {@code p}
     * @param p the Position of a node. Node must be a leaf node.
     * @param tree the tree to attach to the branch
     * @throws IllegalStateException if {@code p} is not a leaf
     */
    public void attach(Position<T> p, AbstractTree<T> tree) throws IllegalStateException;
    /**
     * Removes node Position {@code p} from the tree, and make all of its
     * children the children of the parent node of Position {@code p}
     * @param p the Position of the node to be removed.
     * @return the element of the deleted Node.
     */
    public T hoist(Position<T> p);
}
