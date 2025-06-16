class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);

        }
        int operatorCount = 0;
        for (int n : nums) {
            int target = k - n;
            if (map.getOrDefault(n, 0) > 0 && map.getOrDefault(target, 0) > 0) {
                if (n == target) {
                    if (map.get(n) >= 2) {
                        map.put(n, map.get(n) - 2);
                        operatorCount++;
                    }

                } else {
                    map.put(n, map.get(n) - 1);
                    map.put(target, map.get(target) - 1);
                    operatorCount++;
                }
            }
        }
        return operatorCount;

    }
}