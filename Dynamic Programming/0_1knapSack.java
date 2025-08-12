//Backtracking approach

public class KnapsackBacktracking {
    static int knapSack(int W, int[] wt, int[] val, int n) {
        // Base case: no items or no capacity
        if (n == 0 || W == 0) return 0;

        // If weight is more than capacity, skip this item
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);

        // Choice: include or exclude
        int include = val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1);
        int exclude = knapSack(W, wt, val, n - 1);

        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println("Max value: " + knapSack(W, wt, val, n));
    }
}


//Memoization (Top-Down DP):_
import java.util.Arrays;

public class KnapsackMemoization {
    static int[][] dp;

    static int knapSack(int W, int[] wt, int[] val, int n) {
        if (n == 0 || W == 0) return 0;

        if (dp[n][W] != -1) return dp[n][W];

        if (wt[n - 1] > W)
            return dp[n][W] = knapSack(W, wt, val, n - 1);

        int include = val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1);
        int exclude = knapSack(W, wt, val, n - 1);

        return dp[n][W] = Math.max(include, exclude);
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int n = val.length;

        dp = new int[n + 1][W + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println("Max value: " + knapSack(W, wt, val, n));
    }
}



//Tabulation (Bottom-Up DP):-
  public class KnapsackTabulation {
    static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    int include = val[i - 1] + dp[i - 1][w - wt[i - 1]];
                    int exclude = dp[i - 1][w];
                    dp[i][w] = Math.max(include, exclude);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int n = val.length;

        System.out.println("Max value: " + knapSack(W, wt, val, n));
    }
}
