// problem link :-  https://leetcode.com/problems/longest-consecutive-sequence/
 
 
 // 1st approach:- using sorting and using variables lc and current. it takes:-O(nlogn) time complexity and O(1) space complexity.
 class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(nums.length == 0)
        return 0;
        Arrays.sort(nums);
        int lcs = 1, current = 1;

        for(int i = 1; i<n; i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] - nums[i-1] == 1){
                current+=1;
            }
            else{
                lcs = Math.max(lcs,current);
                current = 1;
            }
        }
        return Math.max(lcs,current); // when the thee is no break in the sequence and sequence lasts till the end.
    }
}

//------------------------------------------------------------------------------------------------------------------------



//2nd approach:-
class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length ==0){
            return 0;
        }
        
        HashSet<Integer> numSet = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            numSet.add(nums[i]);
        }
        
        int longestSub = 1;
        
        for(int num:numSet){
            if(numSet.contains(num-1)){
                continue;
            }
            else{
                int currentNum = num;
                int currentSub = 1;
                while(numSet.contains(currentNum+1)){
                    currentNum++;
                    currentSub++;
                }
                
                longestSub = Math.max(longestSub, currentSub);
            }
            
            
        }
        return longestSub;
        
    }
}

//test
