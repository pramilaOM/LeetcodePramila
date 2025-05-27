class Solution {
    public int findValueOfPartition(int[] nums) {
         int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0;i< nums.length-1;i++){
           result =  Math.min(result,nums[i+1]-nums[i]);
           }
        
        return result;
    }
}