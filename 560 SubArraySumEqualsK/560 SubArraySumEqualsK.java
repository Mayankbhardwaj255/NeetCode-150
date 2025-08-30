//Brute Force:- O(n2):-
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j<n; j++){
                sum+=nums[j];
                if(sum == k)
                  count++;

            }
        }
        return count;
    }
}


//Optimal Approach: O(n) space and O(n) time:- 

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int[] prefSum = new int[n];
        Map<Integer, Integer> mpp = new HashMap<>();
        
        // build prefix sum array
        prefSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefSum[i] = prefSum[i - 1] + nums[i];
        }

        for (int j = 0; j < n; j++) {
            // case 1: subarray from index 0..j
            if (prefSum[j] == k) count++;

            // case 2: subarray from i..j (i > 0)
            int val = prefSum[j] - k;
            if (mpp.containsKey(val)) {
                count += mpp.get(val);
            }

            // update frequency of current prefix sum
            mpp.put(prefSum[j], mpp.getOrDefault(prefSum[j], 0) + 1);
        }
        return count;
    }
}

//This code solves the Subarray Sum Equals K problem using prefix sums and a hashmap. It first calculates the running prefix sum for each index and checks whether the current prefix sum itself equals k (which means the subarray starts from index 0). Then, it looks for any previous prefix sum such that currentPrefixSum - previousPrefixSum = k, which indicates a valid subarray ending at the current index. The hashmap (mpp) keeps track of how many times each prefix sum has appeared so far, allowing quick lookup of such previous sums. Each time a valid match is found, the count is incremented. Finally, the hashmap is updated with the current prefix sum. This ensures all possible subarrays are considered efficiently in O(n) time.
