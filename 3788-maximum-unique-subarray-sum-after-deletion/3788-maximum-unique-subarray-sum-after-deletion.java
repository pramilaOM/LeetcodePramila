class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        int sum = 0;
        int maxNeg = Integer.MIN_VALUE;
        
        for(int num : nums) {
            if(num <= 0) {
                maxNeg = Math.max(maxNeg, num); 
            } else if(!set.contains(num)) {
                sum += num;
                set.add(num);
            }
        }
        
        return sum == 0 ? maxNeg : sum;
    }
}