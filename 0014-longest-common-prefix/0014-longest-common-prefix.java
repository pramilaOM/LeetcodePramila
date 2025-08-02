class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);
        int len = strs.length-1;

        char[] first = strs[0].toCharArray();
        char[] last = strs[len].toCharArray();

        for(int i =0;i<first.length;i++){
            if(first[i] != last[i]){
                break;
            }
            result.append(first[i]);
        }
        return result.toString();
    }
}