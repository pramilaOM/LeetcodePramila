class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1)
            set1.add(num);
        for (int num : nums2)
            set2.add(num);

        List<Integer> onlyInN1 = new ArrayList<>();
        List<Integer> onlyInN2 = new ArrayList<>();

        for (int num : set1) {
            if (!set2.contains(num)) {
                onlyInN1.add(num);
            }
        }
        for (int num : set2) {
            if (!set1.contains(num)) {
                onlyInN2.add(num);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(onlyInN1);
        result.add(onlyInN2);

        return result;
    }

}