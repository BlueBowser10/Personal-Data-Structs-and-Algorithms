public class TestDriver {
    public static void main(String[] args) {
        //System.out.println("\n\nSingularly Linked List Testing: good!\n\n");
        //System.out.println("\nCircularly Linked List Testing: good!");
        //System.out.println("\nDoubly Linked List Testing: good!");
        //System.out.println("\nStack Testing: good!");
        //System.out.println("\nQueue Testing: good!");
        System.out.println("DEQue Testing: ...");

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        
        for (Integer i : list) {
            System.out.println(i);
        }

    }
}