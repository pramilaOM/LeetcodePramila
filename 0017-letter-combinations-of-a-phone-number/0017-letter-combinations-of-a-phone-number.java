class Solution {

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return result;
        Map<Character, String> mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

        StringBuilder temp = new StringBuilder();
        solve(0, digits, temp, mp);

        return result;

    }

    void solve(int idx, String digits, StringBuilder temp, Map<Character, String> mp) {
        if (idx == digits.length()) {
            result.add(temp.toString());
            return;
        }
        char ch = digits.charAt(idx);
        String str = mp.get(ch);
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            solve(idx + 1, digits, temp, mp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}