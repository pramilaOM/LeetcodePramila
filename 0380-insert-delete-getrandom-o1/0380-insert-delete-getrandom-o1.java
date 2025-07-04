
class RandomizedSet {

    // List to store unique values
    Set<Integer> list;

    /** Constructor: initializes the data structure */
    public RandomizedSet() {
        list = new HashSet<>();
    }

    /**
     * Inserts a value if not already present.
     *
     * Time Complexity: O(n) – contains() takes O(n) time in a list
     * Space Complexity: O(n) – for storing n elements
     */
    public boolean insert(int val) {
        return list.add(val);
    }

    /**
     * Removes a value if present.
     *
     * Time Complexity: O(n) – contains() and remove() are O(n) in a list
     * Space Complexity: O(n)
     *
     * Note: We use Integer.valueOf(val) to ensure that we call
     * remove(Object o), not remove(int index).
     * list.remove(val) would incorrectly remove by index if val is treated as int.
     */
    public boolean remove(int val) {
        return list.remove(val);
    }

    /**
     * Returns a random element from the current list.
     *
     * Time Complexity: O(1) – list.get(index) is constant time
     * Space Complexity: O(1)
     */
    public int getRandom() {
        Integer[] arr = list.toArray(new Integer[0]);
        Random rand = new Random();
        return arr[rand.nextInt(arr.length)];
    }
}
