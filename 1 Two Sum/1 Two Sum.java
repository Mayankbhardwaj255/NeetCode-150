// Leetcode link: https://leetcode.com/problems/two-sum/

//Approach:- we will use a HashMap to store the numbers and their indices. For each number we will check if the complement (target - currentIndex) exists in the map. if yes, we return the indices of curren Number and its complement.
//if not, we cadd current Number with its index to Map.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
         Map<Integer, Integer> mpp = new HashMap<>();

         for(int i =0; i<n; i++){
            int complement = target - nums[i];
            if(mpp.containsKey(complement)){
                return new int[] {mpp.get(complement), i};
            }
            mpp.put(nums[i], i);
         }
         return new int[] {};
    }
}