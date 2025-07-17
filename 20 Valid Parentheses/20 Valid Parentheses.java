//LeetCode Link: https://leetcode.com/problems/valid-parentheses/
//1st Approach:- we use a stack to check if the parentheses are valid or not.if we ncounter an open bracket we push it onto the stack and if we encounter a closing bracket we check if the TOS contains the corresponding open bracket. If it does we pop the TOS and continue. if it doesnt match we return false. if the stack is empty , we return true;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for( char s1: s.toCharArray()){
            if(s1=='(')
            st.push(')');
            else if(s1=='{')
            st.push('}');
            else if(s1=='[')
               st.push(']');

               else if(st.isEmpty()|| st.pop()!=s1)
               return false;
                    }
                    return st.isEmpty();
    }
}

/// --------------------------------------------------------------------------------------------------------------------------

// 2nd approach: - here we use a HashMap to store the mapping of closing bracket to opening bracket. we then iterate through the string and check if the character is a opening bracket. If it is, we push onto the stack. if it is closing bracket, we cjeck if the stack is empty or if the TOS does not match the corresponding opening bracket. If it doesnot match , we return false. If it matches, we pop the Tos. at last we check if stack is empty or not. if it is empty we return true, else we return false;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();        
    }
}