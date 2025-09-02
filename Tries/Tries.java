class Node {
    Node[] children;
    boolean eow; // end of word

    public Node() {
        children = new Node[26]; // a-z
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        eow = false;
    }
}

public class Trie {
    static Node root = new Node();

    // Insert a word into the Trie
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                // add new node if doesn't exist
                curr.children[idx] = new Node();
            }

            if (i == word.length() - 1) {
                curr.children[idx].eow = true; // mark end of word
            }

            curr = curr.children[idx];
        }
    }

    // Search if a word exists in the Trie
    public static boolean search(String key) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            Node node = curr.children[idx];

            if (node == null) {
                return false; // path does not exist
            }

            if (i == key.length() - 1 && node.eow == false) {
                return false; // reached but not marked as end
            }

            curr = curr.children[idx];
        }
        return true;
    }

    // Driver code
    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any", "thee"};

        // Insert words
        for (String w : words) {
            insert(w);
        }

        // Search words
        System.out.println(search("the"));    // true
        System.out.println(search("these"));  // false
        System.out.println(search("their"));  // true
        System.out.println(search("thor"));   // false
        System.out.println(search("an"));     // false
        System.out.println(search("any"));    // true
    }
}
