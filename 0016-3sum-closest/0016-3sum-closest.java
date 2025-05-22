class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentElementSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(currentElementSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentElementSum;
                } else if (currentElementSum == target) {
                    return currentElementSum;
                }
                if (currentElementSum < target) {
                    left++;
                } else {
                    right--;
                }

            }
        }

        return closestSum;
        
    }
}