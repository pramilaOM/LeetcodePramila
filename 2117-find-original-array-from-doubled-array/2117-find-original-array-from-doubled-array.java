class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0];
        }
        Arrays.sort(changed);
        Map<Integer, Integer> data = new HashMap<>();
        for (int n : changed) {
            data.put(n, data.getOrDefault(n, 0) + 1);
        }

        int[] res = new int[changed.length / 2];
        int idx = 0;
        for (int n : changed) {
            if (data.get(n) == 0)
                continue;
            if (n == 0) {
                if (data.get(n) < 2)
                    return new int[0];
                data.put(n, data.get(n) - 2);
                res[idx++] = 0;
            } else {
                if (data.getOrDefault(n * 2, 0) == 0)
                    return new int[0];
                data.put(n, data.get(n) - 1);
                data.put(n * 2, data.get(n * 2) - 1);
                res[idx++] = n;
            }
        }
        return res;

    }
}