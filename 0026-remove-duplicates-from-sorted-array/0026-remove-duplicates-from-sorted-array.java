class Solution {
    public int removeDuplicates(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int i =0;
        for(int j =0;j<nums.length;j++){
            if(!map.containsKey(nums[j])){
                map.put(nums[j],1);
                nums[i] = nums[j];
                i++;

            }
        }
        return i;
    }
}