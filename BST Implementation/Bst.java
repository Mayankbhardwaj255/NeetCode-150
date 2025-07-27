class BST {
    // Node structure
    class Node {
        int key;
        Node left, right;

        Node(int value) {
            key = value;
            left = right = null;
        }
    }

    Node root;

    // Insert a key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Search a key
    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        if (root == null) return false;
        if (key == root.key) return true;
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // Delete a key
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) return null;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // Node with one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get inorder successor (min in right subtree)
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private int minValue(Node root) {
        int min = root.key;
        while (root.left != null) {
            root = root.left;
            min = root.key;
        }
        return min;
    }

    // Inorder traversal
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Main for testing
    public static void main(String[] args) {
        BST tree = new BST();

        // Insert
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Inorder traversal: ");
        tree.inorder(); // 20 30 40 50 60 70 80

        // Search
        System.out.println("Search 40: " + tree.search(40)); // true
        System.out.println("Search 90: " + tree.search(90)); // false

        // Delete
        tree.delete(20);
        System.out.print("After deleting 20: ");
        tree.inorder(); // 30 40 50 60 70 80

        tree.delete(30);
        System.out.print("After deleting 30: ");
        tree.inorder(); // 40 50 60 70 80

        tree.delete(50);
        System.out.print("After deleting 50: ");
        tree.inorder(); // 40 60 70 80
    }
}
