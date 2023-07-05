public class TestDriver {
    public static void main(String[] args) {
        //System.out.println("\n\nSingularly Linked List Testing: good!\n\n");
        //System.out.println("\nCircularly Linked List Testing: good!");
        //System.out.println("\nDoubly Linked List Testing: good!");
        //System.out.println("\nStack Testing: good!");
        //System.out.println("\nQueue Testing: good!");
        //System.out.println("DEQue Testing: good!");

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        Stack<Integer> s2 = new Stack<>();
        s2.push(1);
        s2.push(2);
        s2.push(3);

        System.out.print(s.equals(s2));

    }
}