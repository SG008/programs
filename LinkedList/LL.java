package LinkedList;

public class LL {

    private static Node head = null;
    private static Node tail = null;

    private static int size;

    public LL () {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        Node(int value, Node node) {
            this.value = value;
            this.next = node;
        }

        Node(int value) {
            this.value = value;
        }
    }

    public void insertAtFirst(int value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
            tail = node;
            tail.next = null;
            return;
        }
        node.next = head;
        head = node;

        size++;
    }
    public void insertAtLast(int value) {
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAtIndex(int index, int value) {
        Node node = new Node(value);
        Node n = giveNode(index);
        node.next = n.next;
        n.next = node;
        size++;
    }

    public void deleteFirst() {
        int value = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        System.out.println("deleted value: " + value);
        size--;
    }

    public void atNodeIndex(int value) {
        Node tmp = head;
        int i = 0;

        while (tmp != null) {
            if (tmp.value == value) {
                System.out.println("\nvalue found at index: " + (i + 1));
                return;
            }
            i++;
            tmp = tmp.next;
        }
        System.out.println("No value found");
    }

    public void deleteAtIndex(int index) {

        if (index == size) {
            deleteLast();
            return;
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        Node n = giveNode(index);
        Node deletedNode = n.next;
        n.next = n.next.next;
        System.out.println("Value deleted: " + deletedNode.value);
    }

    public void deleteLast() {
        int val = tail.value;

        tail = giveNode(size);
        tail.next = null;

        System.out.println("deleted value: " + val);
    }

    public Node giveNode(int index) {
        Node tmp = head;

        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
    }
}
