class Solution {
    private static final int MOD = 1000000007;

    public int numFactoredBinaryTrees(int[] arr) {

        int n = arr.length;
        Arrays.sort(arr);

        Map<Integer, Long> map = new HashMap<>();
        map.put(arr[0], 1L);

        for (int i = 1; i < n; i++) {
            long count = 1;
            for (int j = 0; j < i; j++) {
                int v = arr[j];
                if (arr[i] % v == 0 && map.containsKey(arr[i] / v)) {
                    count += (map.get(v) * map.get(arr[i] / v)) % MOD;
                    count %= MOD;
                }
            }
            map.put(arr[i], count);

        }

        int result = 0;
        for (long val : map.values()) {
            result = (int) ((result + val) % MOD);
        }
        return result;
    }
}