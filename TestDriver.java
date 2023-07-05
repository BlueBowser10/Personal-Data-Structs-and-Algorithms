public class TestDriver {
    public static void main(String[] args) {
        //System.out.println("\n\nSingularly Linked List Testing: good!\n\n");
        //System.out.println("\nCircularly Linked List Testing: good!");
        //System.out.println("\nDoubly Linked List Testing: good!");
        //System.out.println("\nStack Testing: good!");
        //System.out.println("\nQueue Testing: good!");
        System.out.println("DEQue Testing: ...");

        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        System.out.println(list);

        LinkedList<String> list2 = new LinkedList<>();
        list2.addFirst("a");
        list2.addFirst("b");
        list2.addFirst("c");
        list2.addFirst("d");
        System.out.println(list2);
        System.out.println(list.equals(list2));
    }
}