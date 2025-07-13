class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //do not use below just for learning purpose
        Map<Integer, Integer> data = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int remaining = target - numbers[i];
            if (data.containsKey(remaining)) {
                return new int[] {data.get(remaining)+1,i+1};

            }
            data.put(numbers[i], i);
        }
        return new int[] {};

    }
}