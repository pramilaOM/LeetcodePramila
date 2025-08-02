class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        Set<Integer> set = new HashSet<>();
        for (int val : arr1) {
            while (!set.contains(val) && val > 0) {
                set.add(val);
                val /= 10;
            }
        }

        int result = 0;
        for (int num : arr2) {
            while (!set.contains(num) && num > 0) {
                num /= 10;
            }
            if (num > 0) {
                result = Math.max(result, (int) (Math.log10(num) + 1));

            }

        }
        return result;

    }
}