class Solution {
    public String convert(String s, int numRows) {

        String[] arr = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = "";
        }

        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++) {
                arr[i] += s.charAt(index++);
            }

            for (int i = numRows - 2; i > 0 && index < s.length(); i--) {
                arr[i] += s.charAt(index++);
            }

        }

        String ans = "";
        for(String a : arr){
            ans+=a;
        }

        return ans;

    }
}