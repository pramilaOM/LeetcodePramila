class Solution {
    public int removeDuplicates(int[] nums) {
        //Two pointers approach optimistic 
        //TC O(N)
        //SC O(1)

        int write = 1;
        for(int read = 1;read<nums.length;read++){
            if(nums[read] != nums[read-1]){
                nums[write] = nums[read];
                write++;
            }
        }
        for(int n : nums){
            System.out.print(n+" ");
        }
        return write;
    }
}