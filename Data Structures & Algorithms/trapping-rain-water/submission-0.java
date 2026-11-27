class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int total = 0;
        int rightmax = 0;
        int leftmax = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (leftmax > height[left]) {
                    total += leftmax - height[left];
                } else {
                    leftmax = height[left];
                }
                left++;
            } else {
                if (rightmax > height[right]) {
                    total += rightmax - height[right];
                } else {
                    rightmax = height[right];
                }
                right--;
            }
        }
        return total;
    }
}
