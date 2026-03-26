class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //https://www.youtube.com/watch?v=_cBWWebTVpI
        //n1+n2+n3 =0 will give n2+n3 = -n1 (two sum problem)
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i + 1, result, -nums[i]);
        }
        return result;

    }

    void twoSum(int[] nums, int i, List<List<Integer>> result, int target){

        int start = i, end = nums.length-1;
        while(start < end){
            if((nums[start] + nums[end]) > target){
                end--;
            }else if((nums[start] + nums[end]) < target){
                start++;
            }else{
                result.add(Arrays.asList(-target,nums[start],nums[end]));
                while(start <end && nums[start] == nums[start+1]){
                    start++;
                }
                while(start<end && nums[end] == nums[end-1]){
                    end--;
                }
                start++;
                end--;
            }
        }

    }
}