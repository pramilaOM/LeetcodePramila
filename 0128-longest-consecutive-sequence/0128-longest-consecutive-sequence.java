class Solution {
    public int longestConsecutive(int[] nums) {
        //https://www.youtube.com/watch?v=M-0Hv4p0UUE

        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, false);
        }

        for (int key : map.keySet()) {
            if (map.containsKey(key - 1) == false) {
                map.put(key, true);
            }
        }

        int max = 0;
        for (int key : map.keySet()) {
            int k = 1;
            if (map.get(key) == true) {
                while (map.containsKey(key + k) == true) {
                    k++;
                }
            }
            max = Math.max(max, k);
        }
        return max;
    }
}