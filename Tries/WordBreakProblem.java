class Trie {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false; // end of word

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static Node root = new Node();

    // Insert word into Trie
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // Search word in Trie
    public static boolean search(String key) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    // Word Break Problem
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);

            if (search(firstPart) && wordBreak(secondPart)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Dictionary words
        String words[] = {"i", "like", "sam", "samsung", "mobile"};

        // Insert into Trie
        for (String word : words) {
            insert(word);
        }

        // Test Word Break
        String key1 = "ilikesamsung";
        String key2 = "ilikeapple";

        System.out.println(wordBreak(key1)); // true
        System.out.println(wordBreak(key2)); // false
    }
}
