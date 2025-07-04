class RandomizedSet {
    List<Integer> list;

    public RandomizedSet() {
        //initialise the object
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!list.contains(val)) {
            list.add(val);
            return true;
        } else {
            return false;
        }

    }

    public boolean remove(int val) {
        if (list.contains(val)) {
            list.remove(Integer.valueOf(val));
            return true;
        } else {
            return false;
        }

    }

    public int getRandom() {
        Random ran = new Random();
        int index = ran.nextInt(list.size());
        return list.get(index);

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */