class BinarySearchRecursive {
    // Recursive function to search key in array
    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high) {
            return -1; // base case: not found
        }

        int mid = low + (high - low) / 2; // avoid overflow

        if (arr[mid] == key) {
            return mid; // found
        }
        else if (key < arr[mid]) {
            return binarySearch(arr, low, mid - 1, key); // search left half
        }
        else {
            return binarySearch(arr, mid + 1, high, key); // search right half
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14};
        int key = 10;

        int index = binarySearch(arr, 0, arr.length - 1, key);

        if (index != -1)
            System.out.println("Element found at index " + index);
        else
            System.out.println("Element not found");
    }
}


/*
📌 Recursive Tree (Example: searching for 10 in [2,4,6,8,10,12,14])
  binarySearch(0,6) → mid=3 → arr[3]=8
    key=10 > 8 → search right half

    binarySearch(4,6) → mid=5 → arr[5]=12
        key=10 < 12 → search left half

        binarySearch(4,4) → mid=4 → arr[4]=10 ✅ found


📌 Complexity Analysis

Time Complexity:
Each recursive call cuts the array size in half.
So number of steps ≈ log₂(n) → O(log n).

Space Complexity:

Iterative version: O(1) (no extra stack).

Recursive version: O(log n) because recursion stack depth = height of the recursion tree = log₂(n)

  */
