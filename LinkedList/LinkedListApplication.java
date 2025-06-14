package LinkedList;

public class LinkedListApplication {
    public static void main(String[] args) {
        LL list = new LL();

        list.insertAtFirst(1);
        list.insertAtFirst(2);
        list.insertAtFirst(3);
        list.insertAtLast(4);
        list.insertAtLast(5);
        list.insertAtLast(6);
        list.insertAtIndex(3,7);
        list.printList();
        System.out.println();
        list.deleteFirst();
        list.deleteLast();
        list.printList();
        list.atNodeIndex(2);
        list.deleteAtIndex(2);
        list.printList();
    }
}
