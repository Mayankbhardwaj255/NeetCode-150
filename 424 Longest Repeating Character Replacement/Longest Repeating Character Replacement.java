// Java program to find the maximum consecutive
// repeating character in given string
class GfG {

    // Function to find out the maximum repeating
    // character in given string
    static char maxRepeating(String s) {
        int n = s.length();
        int maxCnt = 0;
        char res = s.charAt(0);

        // Find the maximum repeating character
        // starting from s[i]
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(i) != s.charAt(j))
                    break;
                cnt++;
            }

            // Update result if required
            if (cnt > maxCnt) {
                maxCnt = cnt;
                res = s.charAt(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "aaaabbaaccde";
        System.out.println(maxRepeating(s));
    }
}



//O(N) AND O(1):-

// Java program to find the maximum consecutive
// repeating character in given string
class GFG {

    // Function to find out the maximum repeating
    // character in given string
    static char maxRepeating(String s) {
        int n = s.length();
        int maxCnt = 0;
        char res = s.charAt(0);
        int cnt = 1;

        for (int i = 1; i < n; i++) {

            // If current char matches with
            // previous, increment cnt
            if (s.charAt(i) == s.charAt(i - 1)) {
                cnt++;
            } 
            else {

                // Reset cnt
                cnt = 1;
            }

            // Update result if required
            if (cnt > maxCnt) {
                maxCnt = cnt;
                res = s.charAt(i - 1);
            }
        }

        return res;
    }

    // Driver Code
    public static void main(String[] args) {
        String s = "aaaabbaaccde";
        System.out.println(maxRepeating(s));
    }
}
    
