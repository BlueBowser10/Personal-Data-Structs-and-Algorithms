public class TestDriver {
    public static void main(String[] args) {
        //System.out.println("\n\nSingularly Linked List Testing: good!\n\n");
        //System.out.println("\nCircularly Linked List Testing: good!");
        //System.out.println("\nDoubly Linked List Testing: good!");
        //System.out.println("\nStack Testing: good!");
        //System.out.println("\nQueue Testing: good!");
        //System.out.println("DEQue Testing: good!");

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);
        list.insert(100, 4);
        list.insert(0, 0);

        System.out.println(list.remove(3));
    }
}