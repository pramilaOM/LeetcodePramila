class Solution {
    public int removeDuplicates(int[] nums) {
        //BF
        // Time Complexity O(n)
        // Space Complexity O(n)
        // iterate through nums, adding unique values to a temporary array arr.
        int[] arr = new int[nums.length];
        int k = 0;
        for (int num : nums) {
            if (k == 0) {
                arr[k] = num;
                k++;
            } else {
                if (num != arr[k - 1]) {
                    arr[k] = num;
                    k++;
                }
            }
        }
        // Copy back the unique values (arr[0 to k-1]) into the start of nums
        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }
        for (int n : nums) {
            System.out.print(n + " ");
        }
        return k;
        
    }
}