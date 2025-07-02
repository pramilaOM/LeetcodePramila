class Solution {
    public int majorityElement(int[] nums) {
         int n = nums.length/2;
        int ans = nums[0];
        Arrays.sort(nums);
        int count = 1;
        for(int i =1;i<nums.length;i++){
            if(nums[i] ==nums[i-1]){
                count++;
            }else{
                count = 1;
            }

            if(count > n){
                 ans = nums[i];
            }
        }
       return ans;
        
    }
}