class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            if(nums[i]>0) break;
            int left = i + 1;
            int right = nums.length - 1;
            int target = -(nums[i]);
            while (left<right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;right--;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
