//Backtracking approach:_ 
import java.util.*;

public class SumOfSubsets {
    
    public static void findSubsets(int[] nums, int target, int index, List<Integer> current) {
        if (target == 0) {
            System.out.println(current);
            return;
        }
        
        if (index == nums.length || target < 0) {
            return;
        }
        
        // Include current element
        current.add(nums[index]);
        findSubsets(nums, target - nums[index], index + 1, current);
        
        // Backtrack: remove the last element
        current.remove(current.size() - 1);
        
        // Exclude current element
        findSubsets(nums, target, index + 1, current);
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;
        
        System.out.println("Subsets with sum " + target + ":");
        findSubsets(nums, target, 0, new ArrayList<>());
    }
}

//Dynamic Programming approach:- 
import java.util.*;

public class SubsetSumDP {

    static boolean subsetSum(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;

        if (subsetSum(nums, target)) {
            System.out.println("Subset with given sum exists.");
        } else {
            System.out.println("No subset with given sum.");
        }
    }
}
