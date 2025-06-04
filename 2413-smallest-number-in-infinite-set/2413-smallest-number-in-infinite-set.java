class SmallestInfiniteSet {

    private int currSmallest;
    private TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        currSmallest = 1;
    }

    public int popSmallest() {
        int result;

        if (!set.isEmpty()) {
            result = set.first();
            set.remove(result);
        } else {
            result = currSmallest;
            currSmallest++;
        }
        return result;

    }

    public void addBack(int num) {
        if (num >= currSmallest || set.contains(num)) {
            return;
        }
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */