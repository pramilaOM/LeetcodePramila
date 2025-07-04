class RandomizedSet {
    Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }

    // O(1)
    public boolean insert(int val) {
        return set.add(val); // returns false if already present
    }

    // O(1)
    public boolean remove(int val) {
        return set.remove(val); // returns false if not present
    }

    // ❌ O(n)
    public int getRandom() {
        // Convert set to array to allow random index access
        Integer[] array = set.toArray(new Integer[0]);
        Random rand = new Random();
        return array[rand.nextInt(array.length)];
    }
}
