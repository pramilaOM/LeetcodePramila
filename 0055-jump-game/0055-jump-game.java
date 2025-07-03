class Solution {
    public boolean canJump(int[] nums) {
        //top down
        int len = nums.length;
        boolean[] top = new boolean[len];
        top[0]= true;
        for(int i = 1;i<len;i++){
            for(int j = i-1;j>=0;j--){
                if(top[j] == true && j+nums[j] >= i){
                    top[i] = true;
                    break;
                }
            }
        }
        return top[len-1];
        
    }
}