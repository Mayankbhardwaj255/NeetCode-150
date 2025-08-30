class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        return FindPermute(nums, 0, res);
    }
    
    public List<List<Integer>> FindPermute(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int n : nums)
                perm.add(n);
            res.add(perm);  // ✅ Add one complete permutation
            return res;
        }

        for (int i = index; i < nums.length; i++) {
            Swap(nums, index, i); // ✅ Choose
            FindPermute(nums, index + 1, res); // ✅ Explore
            Swap(nums, index, i); // ✅ Unchoose (backtrack)
        }
        return res;
    }

    private void Swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
