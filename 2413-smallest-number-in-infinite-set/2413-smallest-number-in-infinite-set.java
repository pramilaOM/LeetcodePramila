class SmallestInfiniteSet {

    private int currSmallest;
    private Set<Integer> set;
    private PriorityQueue<Integer> minHeap;


    public SmallestInfiniteSet() {
        currSmallest = 1;
        set = new HashSet<>();
        minHeap = new PriorityQueue<>();
    }

    public int popSmallest() {
        int result;

        if(!minHeap.isEmpty()){
            result = minHeap.poll();
            set.remove(result);
        }else{
            result = currSmallest;
            currSmallest++;
        }
        return result;

    }

    public void addBack(int num) {
        if(num >= currSmallest || set.contains(num)){
            return;
        }
        set.add(num);
        minHeap.offer(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */