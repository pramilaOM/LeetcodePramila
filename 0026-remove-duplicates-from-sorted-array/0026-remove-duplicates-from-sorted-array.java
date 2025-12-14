class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int digit =0;
        for(int i =0;i<n;i++){
            if(i < n-1 && nums[i+1] == nums[i]){
                continue;
            }else{
                nums[digit] = nums[i];
                digit++;
            }
        }
       
        return digit;
    }
}