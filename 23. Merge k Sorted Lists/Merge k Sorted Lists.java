// Java program to merge K sorted linked lists
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {

    // Function to merge K sorted linked lists
    static Node mergeKLists(List<Node> arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Insert the head nodes of k lists 
        for (Node head : arr) {
            if (head != null) pq.add(head);
        }

        // Initialize a dummy head 
        Node dummy = new Node(-1);
        Node tail = dummy;

        while (!pq.isEmpty()) {

            // Pop the min node 
            Node top = pq.poll();

            // Append the node into list 
            tail.next = top;
            tail = top;

            // If top node has next node,
            // add it to the heap.
            if (top.next != null) {
                pq.add(top.next);
            }
        }

        return dummy.next;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int k = 3;

        List<Node> arr = new ArrayList<>();

        arr.add(new Node(1));
        arr.get(0).next = new Node(3);
        arr.get(0).next.next = new Node(5);
        arr.get(0).next.next.next = new Node(7);

        arr.add(new Node(2));
        arr.get(1).next = new Node(4);
        arr.get(1).next.next = new Node(6);
        arr.get(1).next.next.next = new Node(8);

        arr.add(new Node(0));
        arr.get(2).next = new Node(9);
        arr.get(2).next.next = new Node(10);
        arr.get(2).next.next.next = new Node(11);

        Node head = mergeKLists(arr);

        printList(head);
    }
}
