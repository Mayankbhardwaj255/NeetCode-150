// Iterative approach:- O(n) AND SPACE:- O(1)..

public class SortedCheck {
    // Non-decreasing: a[i] <= a[i+1]
    public static boolean isSortedIterative(int[] a) {

  if(a == null) return false;
  if(a.length<=1) return true;

  for(int i = 1; i < n; i++){
    if(a[i-1] >a[i])
      return false;
  }
      return true;
    }
}
//How it works
/*
Walk once from left to right and compare adjacent pairs.

If any pair violates a[i-1] <= a[i], return false immediately.

If you finish the loop, it’s sorted.

Time: O(n) (one pass)
Space: O(1) (no extra memory)

For strictly increasing, change the check to a[i - 1] >= a[i] → return false.

  */

//Recursive Approach:- 

boolean ifSorted(int[] arr, int n){
  if(n == 0 || n==1) return true;

return (arr[n-1] >=arr[n-2] && ifSorted(arr, n-1);
}

