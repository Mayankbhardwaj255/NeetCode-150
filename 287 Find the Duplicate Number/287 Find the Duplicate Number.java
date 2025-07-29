
// Leetcode Link: https://leetcode.com/problems/find-the-duplicate-number/


**************** Java Solution ***********************
public class Solution {
    public int findDuplicate(int[] nums) {
        // Initialize the slow and fast pointers
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        // Find the intersection point of the two runners
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        // Find the "entrance" to the cycle
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
