class Solution {
    public int maxSum(int[] nums) {
         int[] mp = new int[101];
        Arrays.fill(mp, -1); // initialize to -1
        
        int sum = 0;
        int maxNeg = Integer.MIN_VALUE;
        
        for(int num : nums) {
            if(num <= 0) {
                maxNeg = Math.max(maxNeg, num);
            } else if(mp[num] == -1) {
                sum += num;
                mp[num] = 1; 
            }
        }

        return sum > 0 ? sum : maxNeg;
    }
}