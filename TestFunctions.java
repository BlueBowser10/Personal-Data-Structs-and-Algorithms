import LinearDataStructures.*;

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
        //TODO: fix error bug when printin out a circularly linked list of size 1
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
}