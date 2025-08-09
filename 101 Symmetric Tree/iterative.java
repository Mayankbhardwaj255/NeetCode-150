import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class GfG {

    static boolean areMirrors(Node root1, Node root2) {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            Node n1 = q1.poll();
            Node n2 = q2.poll();

            // If both are null, skip
            if (n1 == null && n2 == null) {
                continue;
            }

            // If one is null or values differ → not mirrors
            if (n1 == null || n2 == null || n1.data != n2.data) {
                return false;
            }

            // Enqueue children in opposite order
            q1.add(n1.left);
            q1.add(n1.right);

            q2.add(n2.right);
            q2.add(n2.left);
        }

        return true;
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        root1.right.left = new Node(5);
        root1.right.right = new Node(4);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        System.out.println(areMirrors(root1, root2) ? "true" : "false");
    }
}
