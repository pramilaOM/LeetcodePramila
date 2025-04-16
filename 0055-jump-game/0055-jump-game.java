class Solution {
    public boolean canJump(int[] nums) {

        int lastPosition = nums.length-1;
        for(int i = nums.length-2;i>=0;i--){
            if(i+nums[i] >= lastPosition){
                lastPosition=i;
            }
        }
        return lastPosition ==0;
    }
}