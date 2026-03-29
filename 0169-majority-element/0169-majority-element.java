class Solution {
    public int majorityElement(int[] nums) {
         Arrays.sort(nums);

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int count = nums.length / 2;
        int element = 0;
        for (int num : freq.keySet()) {
            if (freq.get(num) > count) {
                element = num;
            }
        }
        return element;
        
    }
}  