class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int num : basket1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            min = Math.min(min, num);
        }

        for (int num : basket2) {
            map.put(num, map.getOrDefault(num, 0) - 1);
            min = Math.min(min, num);
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value % 2 != 0)
                return -1;
            for (int i = 0; i < Math.abs(value) / 2; i++) {
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        long ans = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            ans += Math.min(list.get(i), min * 2);
        }
        return ans;

    }
}