class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        String prefix = "";

        for (char ch : searchWord.toCharArray()) {
            prefix += ch;
            int start = binarySearch(products, prefix);
            List<String> suggestions = new ArrayList<>();

            for (int i = start; i < products.length && suggestions.size() < 3; i++) {
                if (products[i].startsWith(prefix)) {

                    suggestions.add(products[i]);
                } else {
                    break;
                }
            }
            result.add(suggestions);
        }
        return result;
    }

    int binarySearch(String[] products, String prefix) {
        int low = 0, high = products.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (products[mid].compareTo(prefix) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}