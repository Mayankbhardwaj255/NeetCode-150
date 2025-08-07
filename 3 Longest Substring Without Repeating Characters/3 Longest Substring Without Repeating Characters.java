//LeetCode Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length()==0){
            return 0;
        }
        
        if(s.length() == 1){
            return 1;
        }
        
        int left = 0;
        int right = 0;
        int ans = 0;
        
        HashSet<Character> set = new HashSet<>();
        
        while(right < s.length()){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            ans = Math.max(ans, right-left + 1);
            right++;
        }
        
        return ans;
    }
}




 // O(N) AND O(1):-// USING SLIDING WINDOW:-

class GfG {
    
    static int longestUniqueSubstr(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s.length();

        int res = 0;
        boolean[] vis = new boolean[26];

        // left and right pointer of sliding window
        int left = 0, right = 0;
        while (right < s.length()) {

            // If character is repeated, move left pointer marking
            // visited characters as false until the repeating 
            // character is no longer part of the current window
            while (vis[s.charAt(right) - 'a'] == true) {
                vis[s.charAt(left) - 'a'] = false;
                left++;
            }

            vis[s.charAt(right) - 'a'] = true;

            // The length of the current window (right - left + 1)
            // is calculated and answer is updated accordingly.
            res = Math.max(res, (right - left + 1));
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstr(s));
    }
}
