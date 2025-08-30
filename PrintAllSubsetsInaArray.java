import java.util.*;

public class SubsetsBacktracking {
    // Backtracking method
    public static void generateSubsets(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: Include arr[index]
        current.add(arr[index]);
        generateSubsets(arr, index + 1, current, result);
        current.remove(current.size() - 1);  // backtrack

        // Choice 2: Exclude arr[index]
        generateSubsets(arr, index + 1, current, result);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(arr, 0, new ArrayList<>(), result);

        System.out.println("All subsets (Include first, then Exclude):");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}


/*
📌 Execution (arr = [1,2,3])

Recursive exploration:
Start → []

Include 1 → [1]
   Include 2 → [1,2]
       Include 3 → [1,2,3]
       Exclude 3 → [1,2]
   Exclude 2 → [1]
       Include 3 → [1,3]
       Exclude 3 → [1]

Exclude 1 → []
   Include 2 → [2]
       Include 3 → [2,3]
       Exclude 3 → [2]
   Exclude 2 → []
       Include 3 → [3]
       Exclude 3 → []

  Output order:- 

  [1, 2, 3]
[1, 2]
[1, 3]
[1]
[2, 3]
[2]
[3]
[]
