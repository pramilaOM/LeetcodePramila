class Solution {
    public String[] divideString(String s, int k, char fill) {

        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int end = Math.min(i + k, s.length());
            String group = s.substring(i, end);
            if (group.length() < k) {
                StringBuilder sb = new StringBuilder(group);
                while (sb.length() < k) {
                    sb.append(fill);
                }
                group = sb.toString();
            }
            result.add(group);
            i += k;
        }
        return result.toArray(new String[0]);

    }
}