public class CountOfSubsetSum {
    static int countSubsets(int[] arr, int n, int sum) {
        // Base cases
        if (sum == 0) return 1; // Empty subset is also valid
        if (n == 0) return 0;

        // If current element > sum, skip it
        if (arr[n - 1] > sum) {
            return countSubsets(arr, n - 1, sum);
        }

        // Include + Exclude current element
        return countSubsets(arr, n - 1, sum - arr[n - 1]) // Include
             + countSubsets(arr, n - 1, sum);             // Exclude
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println("Count of subsets: " + countSubsets(arr, arr.length, sum));
    }
}

//Approach 2: Memoization (Top-down DP):-
  import java.util.Arrays;

public class CountOfSubsetSumMemo {
    static int[][] dp;

    static int countSubsets(int[] arr, int n, int sum) {
        if (sum == 0) return 1;
        if (n == 0) return 0;

        if (dp[n][sum] != -1) return dp[n][sum];

        if (arr[n - 1] > sum) {
            return dp[n][sum] = countSubsets(arr, n - 1, sum);
        }

        return dp[n][sum] = countSubsets(arr, n - 1, sum - arr[n - 1])
                          + countSubsets(arr, n - 1, sum);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        dp = new int[arr.length + 1][sum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println("Count of subsets: " + countSubsets(arr, arr.length, sum));
    }
}

//Approach 3: Tabulation (Bottom-up DP) :-

public class CountOfSubsetSumTab {
    static int countSubsets(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        // Base case: when sum = 0 → 1 way (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println("Count of subsets: " + countSubsets(arr, arr.length, sum));
    }
}
