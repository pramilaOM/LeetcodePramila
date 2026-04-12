class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int allowed = Math.min(entry.getValue(), 2);
            for (int k = 0; k < allowed; k++) {
                nums[i] = entry.getKey();
                i++;
            }
        }
        return i;
    }
}