import LinearDataStructures.*;

import ADTInterfaces.*;
import NonLinearDataStructures.*;

public class TestFunctions {
    
    public static void testLinkedList () {
        System.out.println("Testing Singularly Linked List...\n===============================================\n\n\n");
        System.out.println("Creating linked list...");
        LinkedList<Integer> l = new LinkedList<>();
        System.out.println(l);

        System.out.println("Adding to front when empty...");
        l.addFirst(1);
        System.out.println(l.first() + " " + l.last());
        System.out.println(l);
        l.removeFirst();

        System.out.println("Adding to back when empty...");
        l.addLast(2);
        System.out.println(l.first() + " " + l.last());
        System.out.println(l);

        System.out.println("Adding to front...");
        l.addFirst(3);
        l.addFirst(4);
        l.addFirst(20);
        System.out.println(l);

        System.out.println("Adding to back...");
        l.addLast(-1);
        l.addLast(-2);
        System.out.println(l.first() + " " + l.last());
        System.out.println(l);

        System.out.println("Testing equality for equal lists.");
        LinkedList<Integer> a = new LinkedList<>();
        a.addFirst(1); a.addFirst(2); a.addFirst(3); 
        System.out.println("a: " + a);
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.addFirst(1); l2.addFirst(2); l2.addFirst(3);
        System.out.println("b: " + l2);
        System.out.println(a.equals(l2));

        System.out.println("Testing equality for unequal lists of the same type");
        System.out.println("\t diff length:");
        a = new LinkedList<>();
        a.addFirst(1); a.addFirst(2); a.addFirst(3); 
        System.out.println("a: " + a);
        LinkedList<Integer> b = new LinkedList<>();
        b.addFirst(1); b.addFirst(2);
        System.out.println("b: " + b);
        System.out.println(a.equals(l2));

        System.out.println("same length, unequal:");
        a = new LinkedList<>();
        a.addFirst(1); a.addFirst(2); a.addFirst(3); 
        System.out.println("a: " + a);
        b = new LinkedList<>();
        b.addFirst(1); b.addFirst(2); b.addFirst(1);
        System.out.println("b: " + b);
        System.out.println(a.equals(b));

        System.out.println("Testing equality for unequal lists of different types");
        LinkedList<String> c = new LinkedList<>();
        c.addLast("3"); c.addLast("2"); c.addLast("1");
        System.out.println("a: " + a);
        System.out.println("c: " + c);
        System.out.println(a.equals(c));
        System.out.println(c.equals(a));

        System.out.println("what about an empty list?");
        LinkedList<String> d = new LinkedList<>();
        LinkedList<String> e = new LinkedList<>();
        System.out.println("d: " + d);
        System.out.println("e: " + e);
        System.out.println(d.equals(e));
        System.out.println(e.equals(d));

        System.out.println("Testing iterator...");
        System.out.println(a);
        for (Integer integer : a) {
            System.out.println(integer);
        }
        System.out.println("Iterating over empty list...");
        System.out.println(d);
        for (String s : d) {
            System.out.println(s);
        }
    }

    public static void testCircularlyLinkedList() {
        System.out.println("Testing Circularly Singularly Linked List...\n===============================================\n\n\n");
        
        System.out.println("Creating circularly linked list...");
        CircularlyLinkedList<Integer> a = new CircularlyLinkedList<>();
        System.out.println(a);

        System.out.println("Adding to front when empty...");
        a.addFirst(1);
        System.out.println(a.first() + " " + a.last());
        System.out.println(a);
        a.removeFirst();
        
        System.out.println("Adding to front...");
        a.addFirst(1); a.addFirst(2); a.addFirst(3);
        System.out.println(a.first() + " " + a.last());
        System.out.println(a);

        System.out.println("Adding to back when empty...");
        a = new CircularlyLinkedList<>();
        a.addLast(5);
        System.out.println(a);
        System.out.println(a.first() + " " + a.last());


        System.out.println("Adding to back...");
        a.addLast(6); a.addLast(7); a.addLast(8);
        System.out.println(a);
        System.out.println(a.first() + " " + a.last());

        System.out.println("Removing front from nonempty...");
        System.out.println("before: " + a);
        System.out.println(a.removeFirst());
        System.out.println("after: " + a);

        System.out.println("Rotating...");
        a.rotate();
        System.out.println(a);

        System.out.println("Testing nonempty iterator...");
        System.out.println(a);
        for (Integer integer : a) {
            System.out.println(integer);
        }
        System.out.println("Testing empty iterator....");
        CircularlyLinkedList<Integer> b = new CircularlyLinkedList<>();
        System.out.println(b);
        for (Integer integer : b) {
            System.out.println(integer);
        }

        System.out.println("Testing equals: euqal list, equal type");
        CircularlyLinkedList<Integer> c = new CircularlyLinkedList<>();
        CircularlyLinkedList<Integer> d = new CircularlyLinkedList<>();

        c.addFirst(1); c.addFirst(2);
        d.addFirst(1); d.addFirst(2);

        System.out.println("c: " + c);
        System.out.println("d: " + d);

        System.out.println(c.equals(d));

        System.out.println("Testing inequality: same type, diff content");
        CircularlyLinkedList<Integer> f = new CircularlyLinkedList<>();
        f.addFirst(3); f.addFirst(1);
        System.out.println("c: " + c);
        System.out.println("f: " + f);

        System.out.println(c.equals(f));

        System.out.println("Testing inequality: dff type, diff list");
        CircularlyLinkedList<String> e = new CircularlyLinkedList<>();
        e.addFirst("abba"); e.addFirst("Frederick");
        System.out.println("c: " + c);
        System.out.println("e: " + e);

        System.out.println(c.equals(e));
        System.out.println("Testing equality: empty lists...");
        System.out.println((new CircularlyLinkedList<Integer>()).equals(new CircularlyLinkedList<Integer>()));
    }

    public static void testDoublyLinkedList() {
        System.out.println("Testing Doubly Linked List...\n===============================================\n\n\n");

        System.out.println("Creating Doubly Linked List...");
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        System.out.println(a);

        System.out.println("Adding 3 to front when empty...");
        a.addFirst(3);
        System.out.println(a);
        System.out.println(a.first() + " " + a.last());
        a.removeFirst();

        System.out.println("Adding 5 to back when empty...");
        a.addLast(5);
        System.out.println(a);
        System.out.println(a.first() + " " + a.last());
        a.removeFirst();

        System.out.println("Removing first when empty (should throw an error)...");
        System.out.println(a);
        try {
            System.out.println(a.removeFirst());
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\nerror caught!");
        }

        System.out.println("Removing last when empty (should throw an error)...");
        try {
            System.out.println(a.removeLast());
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\nerror caught!");
        }
        System.out.println("Remove from empty...");
        try {
            System.out.println(a.remove(2));
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\nerror caught!");
        }

        System.out.println("Test empty iterator...");
        System.out.println(a);
        for (Integer integer : a ) {
            System.out.println(integer);
        }

        System.out.println("Adding 2 to front...");
        System.out.println("before: " + a);
        a.addFirst(2);
        System.out.println("after: " + a);
        System.out.println(a.first() + " " + a.last());


        System.out.println("Adding 8 to back...");
        System.out.println("before: " + a);
        a.addLast(8);
        System.out.println("after: " + a);
        System.out.println(a.first() + " " + a.last());

        System.out.println("Adding, 15, 14, 5 to front");
        a.addFirst(5); a.addFirst(14); a.addFirst(15);

        System.out.println("Removing first from nonempty...");
        System.out.println("before: " + a);
        System.out.println(a.removeFirst());
        System.out.println("after: " + a);

        System.out.println("Removing last from nonempty...");
        System.out.println("before: " + a);
        System.out.println(a.removeLast());
        System.out.println("after: " + a);

        System.out.println("Insert -1 at beginning");
        System.out.println("before: " + a);
        a.insert(-1, 0);
        System.out.println("after: " + a);

        System.out.println("Insert 0 at i=2, middle");
        System.out.println("before: " + a);
        a.insert(0, 2);
        System.out.println("after: " + a);

        System.out.println("Insert 1 at end");
        System.out.println("before: " + a);
        a.insert(1, a.size());
        System.out.println("after: " + a);

        System.out.println("Removing index 2...");
        System.out.println("before: " + a);
        System.out.println(a.remove(2));
        System.out.println("after: " + a);

        System.out.println("Get element at i=2...");
        System.out.println("list: " + a);
        System.out.println(a.get(2));

        a.addLast(7); a.addLast(9); a.addLast(27); a.addFirst(90);

        System.out.println("Test nonempty iterator...");
        System.out.println("list: " + a);
        for (Integer integer : a) {
            System.out.println(integer);
        }

        System.out.println("Test setting 1000 at i=1...");
        System.out.println("list: " + a);
        a.set(1000, 1);
        System.out.println("new list: " + a);
        
        System.out.println("Test equality: equal");
        DoublyLinkedList<Integer> b = new DoublyLinkedList<>();
        b.addFirst(1); b.addFirst(2);

        DoublyLinkedList<Integer> c = new DoublyLinkedList<>();
        c.addFirst(1); c.addFirst(2);

        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println(b.equals(c));

        System.out.println("Test inequality: samw type, diff content");
        c.set(3, 1);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println(b.equals(c));

        System.out.println("Test inequality: diff type, diff content");
        DoublyLinkedList<String> d = new DoublyLinkedList<>();
        d.addFirst("abba"); d.addFirst("diedrah");
        
        System.out.println("b: " + b);
        System.out.println("d: " + d);
        System.out.println(b.equals(d));
    }

    public static void testStack() {
        System.out.println("Testing Stack...\n===============================================\n\n\n");
        System.out.println("(relies on LinkedLis tTest, so as long as Stack implemented right, fewer things to check)");
        System.out.println("Creating new stack...");
        Stack<Integer> a = new Stack<>();
        System.out.println(a);

        System.out.println("Top of empty stack is null");
        System.out.println(a);
        System.out.println(a.top());

        System.out.println("Push elems to stack");
        System.out.println("before: " + a);
        a.push(3); a.push(5); a.push(18);
        System.out.println(a);

        System.out.println("Top of stack");
        System.out.println(a);
        System.out.println(a.top());

        System.out.println("Pop from nonempty stack");
        System.out.println("before: " + a);
        System.out.println(a.pop());
        System.out.println("after: " + a);

        System.out.println("Pop from empty stack (should throw error)");
        a = new Stack<>();
        try {
            System.out.println(a.pop());
        } catch (Exception e) {
            System.out.println(e + "\nerror caught!");
        }
    }

    public static void testQueue() {
        System.out.println("Testing Queue...\n===============================================\n\n\n");
        System.out.println("(relies on LinkedList Test, so as long as Stack implemented right, fewer things to check)");
        System.out.println("Creating queue");
        Queue<Integer> a = new Queue<>();
        System.out.println(a);

        System.out.println("Dequeueing from empty (should throw an error)");
        try {
            System.out.println(a.dequeue());
        } catch (Exception e) {
            System.out.println(e + "\nerror caught!");
        }

        System.out.println("First elem of empty queue (should be null)");
        System.out.println(a);
        System.out.println(a.first());

        System.out.println("Enqueing...");
        System.out.println("before: " + a);
        a.enqueue(1); a.enqueue(2); a.enqueue(3);
        System.out.println("after: " + a);

        System.out.println("Dequeueing from nonempty...");
        System.out.println("before: " + a);
        System.out.println(a.dequeue());
        System.out.println("after: " + a);

        System.out.println("First element of a nonempty queue.");
        System.out.println(a);
        System.out.println(a.first());
        
    }

    public static void testDeque() {
        System.out.println("Testing Queue...\n===============================================\n\n\n");
        System.out.println("(relies on LinkedList Test, so as long as Stack implemented right, fewer things to check)");
        System.out.println("Creating queue...");
        Deque<Integer> a = new Deque<>();
        System.out.println(a);

        System.out.println("push to front");
        System.out.println("before: " + a);
        a.pushFront(1); a.pushFront(2); a.pushFront(3);
        System.out.println("after: " + a);
        System.out.println(a.first() + " " + a.last());


        System.out.println("push to back");
        System.out.println("before: " + a);
        a.pushBack(6); a.pushBack(5); a.pushBack(4);
        System.out.println("after: " + a);
        System.out.println(a.first() + " " + a.last());

        System.out.println("pop from front");
        System.out.println("before: " + a);
        System.out.println(a.popFront());
        System.out.println("after: " + a);

        System.out.println("pop from back");
        System.out.println("before: " + a);
        System.out.println(a.first() + " " + a.last());
        System.out.println(a.popBack());
        System.out.println("after: " + a);
        System.out.println(a.first() + " " + a.last());


        a = new Deque<>();

        System.out.println("pop from front when empty (should throw error)");
        try {
            a.popFront();
        } catch (Exception e) {
            System.out.println(e + "\nerror caught");
        }
        System.out.println("pop from back when empty (should throw error)");
        try {
            a.popFront();
        } catch (Exception e) {
            System.out.println(e + "\nerror caught");
        }
    }
    
    public static void testItemList() {
        System.out.println("Testing List...\n===========================================================");
        System.out.println("(dep on DoublyLinkedList)\n\n\n");
        print("creating item list");
        ItemList<Integer> a = new ItemList<>();

        print("Testing empty iterator...");
        print(a);
        for (Integer integer : a) {
            print(integer);
        }

        print("default add last");
        print("before: " + a);
        a.add(1);
        print("after: " + a);

        print("add -1 at atart");
        print("before: " + a);
        a.add(0, -1);
        print("after: " + a);

        print("add 5 at i=1 (middle)");
        print("before: " + a);
        a.add(1, 5);
        print("after: " + a);

        print("add 8 at end");
        print("before: " + a);
        a.add(a.size() - 1, 8);
        print("after: " + a);

        print("get item at i=3");
        print("list: " + a);
        print(a.get(3));

        print("remove item at i=2");
        print("before: " + a);
        print(a.remove(2));
        print("after: " + a);

        a.add(23);
        a.add(47);
        a.add(89);
        
        print("testing nonempty iterator...");
        print("list: " + a);
        for (Integer integer : a) {
            print(integer);
        }
        
    }

    public static void testPositionalList() {
        print("Testing Posiitonal List...\n=============================================");
        print("creating positional list...");
        PositionalList<Integer> a = new PositionalList<>();

        System.out.println(a);
        print("add 1 to front...");
        print("before: " + a);
        print(a.addFirst(1));
        print("after: " + a);
        print(a.first() + " " + a.last());

        print("add 2 to back...");
        print("before: " + a);
        print(a.addLast(2));
        print("after: " + a);
        print(a.first() + " " + a.last());

        print("add a few more...");
        print("before: " + a);
        a.addLast(3); a.addFirst(10); a.addLast(30);
        print("after: " + a);
        
        print("get position");
        Position<Integer> pos = a.first();
        print("first: " + pos);

        print("advance pos to test...");
        pos = a.after(pos);
        print("pos is now: " + pos);

        print("position navigation:");
        print("before pos is: " + a.before(pos));
        print("after pos is " + a.after(pos));

        print("add 18 before position with element " + pos.getElement());
        print("before: " + a);
        a.addBefore(pos, 18);
        print("after: " + a);

        
        print("add 26 after position with element " + pos.getElement());
        print("before: " + a);
        a.addAfter(pos, 26);
        print("after: " + a);

        print("remove position and try to add (should throw error)");
        print("before: " + a);
        print(a.remove(pos));
        print("removed position: " + pos);
        print("after: " + a);
        try {
            a.addAfter(pos, 45);
        } catch (Exception e) {
            print(e + "\nerror caught!");
        }

        print("test nonempty iterator...");
        print(a);
        for (Integer integer : a) {
            print(integer);
        }
        
        print("test empty iterator...");
        a = new PositionalList<>();
        print(a);
        for (Integer integer : a) {
            print(integer);
        }
    }

    public static void testBinaryTree() {
        print("Testing Binary Tree...\n==================================================");
        print("(this is a lot but worth it)");
        print("creating binary tree...");
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        print(tree.root());

        print();
        print("accessing empty root (should be null)");
        print(tree.root());

        print();
        print("try adding a root 1 to an empty tree");
        tree.addRoot(1);
        print(tree);
        Position<Integer> root = tree.root();
        print("root position: " + root);

        print();
        print("add left 2 and right 3, empty and nonempty");
        Position<Integer> l = tree.addLeft(root, 2);
        Position<Integer> r = tree.addRight(root, 3);

        print("tree: " + tree);
        print("root: " + root);
        print("left: " + l);
        print("right: " + r);

        print();
        print("try to add to root's left and right (should throw error)");
        try {
            tree.addLeft(root, 4);
        } catch (Exception e) {
            print(e + "\ncannot add left, error caught!");
        }

        try {
            tree.addRight(root, 5);
        } catch (Exception e) {
            print(e + "\ncannot add right, error caught!");
        }

        print();
        print("test navigation...");
        print("parent of left (should be root): " + tree.parent(l));
        print("children of root: " + tree.children(root));
        print("left of root:" + tree.left(root));
        print("right of root: " + tree.right(root));

        print();
        print("set a new value on left to 55");
        print("before, left was: " + l);
        print("last val was " + tree.set(l, 55));
        print("new val: " + l);

        print();
        print("remove positions and test for invalid positions");
        print("removing root...(should throw an error)");
        try {
            tree.remove(root);
        } catch (Exception e) {
            print(e + "\nerror caught");
        }

        print();
        print("adding 5 to left branch...");
        Position<Integer> deleted = tree.addLeft(l, 5);

        print();
        print("removing...");
        print("before: " + l);
        tree.remove(deleted);
        print("after: " + l);

        print();
        print("removing point root");
        BinaryTree<Integer> pointRoot = new BinaryTree<>();
        Position<Integer> point = pointRoot.addRoot(5);
        print("tree: " + pointRoot);
        print("before: " + point);
        pointRoot.remove(point);
        print("after: " + point);
        print("after tree: " + pointRoot);

        point = pointRoot.addRoot(5);
        Position<Integer> point2 = pointRoot.addRight(point, 10);

        print();
        print("now removing from a binary linked list...");
        print("tree: " + pointRoot);
        print("before: " + point);
        pointRoot.remove(point);
        print("after: " + point);
        print("after tree: " + pointRoot);
        print("after root: " + pointRoot.root());

        print();
        print("testing for invalid positions...");
        try {
            pointRoot.addLeft(point, 20);
        } catch (Exception e) {
            print(e + "\nerror caught!");
        }

        print();
        print("test the depth and height functions for empty, unbalanced, and full trees...");
        /*
         * I will do this tree
         * a 
         *     c            d
         *  e      g        |
         *                  h
         *              i      k
         */
        BinaryTree<Integer> dTree = new BinaryTree<>();
        root = dTree.addRoot(1);
        dTree.addLeft(dTree.root(), 1);
        dTree.addRight(dTree.root(), 1);

        dTree.addLeft(dTree.left(dTree.root()), 1);
        dTree.addRight(dTree.left(dTree.root()), 1);

        Position<Integer> internal = dTree.addRight(dTree.right(dTree.root()), 1);

        dTree.addRight(dTree.right(dTree.right(dTree.root())), 1);
        Position<Integer> leaf = dTree.addLeft(dTree.right(dTree.right(dTree.root())), 1);

        print("depth of root: " +dTree.depth(root));
        print("depth of internal node h: " +dTree.depth(internal));
        print("depth of leaf node i: " +dTree.depth(leaf));

        print("height of tree: " + dTree.height(root));
        print("height of tree at an internal node h: " + dTree.height(internal));
        print("height of tree at a leaf: " + dTree.height(leaf));

        print();
        print("create two new binary trees and try to attach their roots...");
        print("tree1: " + tree);
        BinaryTree<Integer> tree2 = new BinaryTree<Integer>();
        tree2.addRoot(4);
        tree2.addLeft(tree2.root(), 5);
        tree2.addRight(tree2.root(), 6);
        print("tree2: " + tree);

        BinaryTree<Integer> linker = new BinaryTree<Integer>();
        print("linker tree: " + linker);
        linker.addRoot(1);
        linker.attach(linker.root(), tree, tree2);
        print("new tree (should have 7 nodes...): " + linker);

        Queue<Position<Integer>> q = new Queue<>();
        q.enqueue(linker.root());
        while (!q.isEmpty()) {
            Position<Integer> p = q.dequeue();
            print(p.getElement());
            if (linker.children(p).size() > 0) {
                for (Position<Integer> child : linker.children(p)) {
                    q.enqueue(child);
                }
            }
        }
    }

    public static void testTreeIterator() {
        print("Testing Tree Iteration...\n==================\n");
        BinaryTree<Integer> tree = new BinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        tree.addLeft(root, 2);
        tree.addRight(root, 3);
        tree.addLeft(tree.left(root), 4);
        tree.addRight(tree.left(root), 5);
        tree.addRight(tree.right(root), 6);

        print("Tree structure:");
        print("\t\t\t1");
        print("\t\t2\t\t3");
        print("\t4\t5\t\t\t6\t");
        print();
        print("Testing breadth-first iteration: ");
        print("Order should be: \n1 2 3 4 5 6");
        TreeIterator<Integer> iter = new TreeIterator<>(tree);
        Queue<Position<Integer>> iterQue = iter.breadthFirst(root);
        String order = "";
        while (!iterQue.isEmpty()) {
            order += iterQue.dequeue().getElement() + " ";
        }
        print(order);
        print();

       print("Testing preorder iteration: ");
        print("Order should be: \n1 2 4 5 3 6");
        iter = new TreeIterator<>(tree);
        iterQue = iter.preorder(root);
        order = "";
        while (!iterQue.isEmpty()) {
            order += iterQue.dequeue().getElement() + " ";
        }
        print(order);
        print();

        print("Testing postorder iteration: ");
        print("Order should be: \n4 5 2 6 3 1");
        iter = new TreeIterator<>(tree);
        iterQue = iter.postorder(root);
        order = "";
        while (!iterQue.isEmpty()) {
            order += iterQue.dequeue().getElement() + " ";
        }
        print(order);
        print();

        print("Testing inorder iteration: ");
        print("Order should be: \n4 2 5 1 3 6");
        iter = new TreeIterator<>(tree);
        iterQue = iter.inorder(root);
        order = "";
        while (!iterQue.isEmpty()) {
            order += iterQue.dequeue().getElement() + " ";
        }
        print(order);
        print();

        print("Testing euler tour iteration: ");
        print("Order should be: \n1 2 4 2 5 2 1 3 6 3 1");
        iter = new TreeIterator<>(tree);
        iterQue = iter.eulerTour(root);
        order = "";
        while (!iterQue.isEmpty()) {
            order += iterQue.dequeue().getElement() + " ";
        }
        print(order);
        print();
    }

    public static void testLinearPriorityQueue() {
        print("Testing linear priority queue...");
        print("==========================================");
        print();

        print("creating new priority queue");
        LinearPriorityQueue<Integer, String> pq = new LinearPriorityQueue<>();
        print(pq);

        print("\nInserting into empty...");
        print("before: " + pq);
        pq.insert(5, "first item!");
        print("after: " + pq);

        print("\nInserting greater priority item...");
        print("before: " + pq);
        pq.insert(2, "even more important item!");
        print("after: " + pq);

        print("\nTesting insert a lesser priority item...");
        pq.removeMostImportant();
        print("before: " + pq);
        pq.insert(7, "even more important item!");
        print("after: " + pq);
        int i = 1;
        while (!pq.isEmpty()) {
            print(i + " " + pq.removeMostImportant());
            i++;
        }

        print("\nclearing queue and testing adding a equal priority item...");
        pq = new LinearPriorityQueue<>();
        pq.insert(5, "important item");
        print("before: " + pq);
        pq.insert(5, "hey, me impo too!");
        print("after: " + pq);
        i = 1;
        while (!pq.isEmpty()) {
            print(i + " " + pq.removeMostImportant());
            i++;
        }

        print("\nadding more elements...");
        pq.insert(2, "duck");
        pq.insert(20, "not impo");
        print("queue now: " + pq);

        print("most important item: " + pq.mostImportant());
        print("removing most important item...");
        print("before: " + pq);
        Object entry = pq.removeMostImportant();
        print("removed item: " + entry);
        print("after: " + pq);

    }

    public static void print(Object s) {
        System.out.println(s);
    }

    public static void print() {
        System.out.println();
    }
}