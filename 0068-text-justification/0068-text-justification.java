class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index =0;
        while( index < n){
            int totalChars = words[index].length();
            int last = index+1;
            while (last < n) {
                if(totalChars+1+words[last].length() > maxWidth) break;
                totalChars+= 1+ words[last].length();
                last++;
            }
            StringBuilder sb = new StringBuilder();
            int diff = last-index-1;
            if(last ==n || diff ==0){
                for(int i = index;i<last;i++){
                    sb.append(words[i]);
                    if(i < last-1){
                        sb.append(" ");
                    }
                }
                int remainingSpaces = maxWidth - sb.length();
                appendSpaces(sb,remainingSpaces);
            } else{
                int spaces = (maxWidth-totalChars)/diff;
                int extraSpaces = (maxWidth-totalChars)%diff;
                for(int i = index;i<last;i++){
                    sb.append(words[i]);
                    if(i < last-1){
                        int spacesToApply = spaces+(i - index < extraSpaces ? 1:0);
                        appendSpaces(sb,spacesToApply+1);
                    }
                }
            }
            result.add(sb.toString());
            index = last;

        }
        System.out.println(result);
        return result;
    }
    public static void appendSpaces(StringBuilder sb, int count){
        for(int i =0;i<count ;i++){
            sb.append(" ");
        }
	}
        
 }
