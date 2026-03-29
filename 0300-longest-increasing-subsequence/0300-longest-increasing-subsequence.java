class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] t = new int[n];
        Arrays.fill(t,1);

        int max = 1;

        for(int i =1;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                    t[i] = Math.max(t[i],t[j]+1);
                    max = Math.max(max,t[i]);
                }
            }
        }
        return max;
        
    }
}