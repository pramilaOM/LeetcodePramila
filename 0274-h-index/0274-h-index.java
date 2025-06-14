class Solution {
    public int hIndex(int[] citations) {
        int hindex = 0;
        Arrays.sort(citations);
        List<Integer> list = new ArrayList<>();
        for (int n : citations) {
            list.add(n);
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= i + 1) {
                hindex++;
            } else {
                break;
            }

        }

        return hindex;

    }
}