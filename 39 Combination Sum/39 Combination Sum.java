//Here we do three choices.. 1) include single, 2). include multiple, 3). include multiple.

// in single:- index changes
//in multiple:- index remains same
//in not include:- indec changes
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] arr, int index, int target, List<Integer> current, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(current)); // add copy
            return;
        }
        if (target < 0 || index == arr.length) return;

        //Option 1: include current element (stay on same index, can reuse element)
        current.add(arr[index]);
        backtrack(arr, index, target - arr[index], current, res);
        current.remove(current.size() - 1);

        //Option 2: skip current element
        backtrack(arr, index + 1, target, current, res);
    }
}
