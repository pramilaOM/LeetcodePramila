class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        StringBuffer sb = new StringBuffer(magazine);
        for (char ran : ransomNote.toCharArray()) {
            int index = sb.indexOf(String.valueOf(ran));
            if (index == -1) {
                return false;
            }
            sb.deleteCharAt(index);

        }
        return true;
    }
}