
class RandomizedSet {

    // List to store unique values
    List<Integer> list;

    /** Constructor: initializes the data structure */
    public RandomizedSet() {
        list = new ArrayList<>();
    }

    /**
     * Inserts a value if not already present.
     *
     * Time Complexity: O(n) – contains() takes O(n) time in a list
     * Space Complexity: O(n) – for storing n elements
     */
    public boolean insert(int val) {
        if (!list.contains(val)) {
            list.add(val); // O(1) to add at end
            return true;
        } else {
            return false; // Already present
        }
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
        if (list.contains(val)) {
            list.remove(Integer.valueOf(val)); // Remove the actual object 'val'
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a random element from the current list.
     *
     * Time Complexity: O(1) – list.get(index) is constant time
     * Space Complexity: O(1)
     */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(list.size()); // Generates a random index from 0 to size-1
        return list.get(index); // Return element at that index
    }
}
