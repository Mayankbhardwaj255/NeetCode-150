public class EqualSumPartition {

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        // If sum is odd, can't partition
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill DP table
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
        int[] nums = {1, 5, 11, 5};
        if (canPartition(nums)) {
            System.out.println("Can be partitioned into two subsets with equal sum.");
        } else {
            System.out.println("Cannot be partitioned into two subsets with equal sum.");
        }
    }
}
