
// Leetcode Link: https://leetcode.com/problems/generate-parentheses/
**************** Java Solution ***********************


class Solution {
    public List<String> generateParenthesis(int n) {

       List<String> ans = new ArrayList();
       backtrack(ans, new StringBuilder(), 0,0,n);
       return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if(cur.length()==max*2){
            ans.add(cur.toString());
            return;
        }

        if(open<max){ // maximum opening can be only upto n
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length()-1); // to remove the last added character because we are exploring other options.
        }
        if(close<open){  // closing brackets can only be added if there are more opening brackets.
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length()-1); // to remove the last added character because we are exploring other options.
        }
    }
}
