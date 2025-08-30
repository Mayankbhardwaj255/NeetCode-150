import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // ✅ sort first
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        return FindSubset(nums, 0, current, res);
    }

    public List<List<Integer>> FindSubset(int[] nums, int index, List<Integer> current, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(current));
            return res;
        }

        // ✅ Include current element
        current.add(nums[index]);
        FindSubset(nums, index + 1, current, res);
        current.remove(current.size() - 1); // backtrack

        // ✅ Skip all duplicates of nums[index]
        int idx = index + 1;
        while (idx < nums.length && nums[idx] == nums[index]) {
            idx++;
        }

        // ✅ Exclude nums[index] and jump to next distinct element
        FindSubset(nums, idx, current, res);

        return res;
    }
}
