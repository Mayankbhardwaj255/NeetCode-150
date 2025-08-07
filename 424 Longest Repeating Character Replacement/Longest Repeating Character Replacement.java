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
