class FindSumPairs {
    private List<Integer> nums1;
    private List<Integer> nums2;
    private Map<Integer, Integer> freq;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = new ArrayList<>();
        for (int num : nums1) {
            this.nums1.add(num);
        }

        this.nums2 = new ArrayList<>();
        for (int num : nums2) {
            this.nums2.add(num);
        }
        freq = new HashMap<>();
        for (int num : nums2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int old = nums2.get(index);
        freq.put(old, freq.get(old) - 1);
        if (freq.get(old) == 0) {
            freq.remove(old);
        }
        int newVal = old + val;
        nums2.set(index, newVal);
        freq.put(newVal, freq.getOrDefault(newVal, 0) + 1);

    }

    public int count(int tot) {
        int count = 0;
        for (int num : nums1) {
            int com = tot - num;
            count += freq.getOrDefault(com, 0);
        }
        return count;

    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */