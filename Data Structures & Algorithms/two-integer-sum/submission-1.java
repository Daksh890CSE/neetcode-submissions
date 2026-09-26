class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0;
        int j=1;
        for(i=0;i<nums.length;i++){
            for(j=1;j<nums.length;j++){
                if(j==i){
                    continue;
                }
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{i,j};
    }
}
