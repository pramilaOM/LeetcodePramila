class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int m = pushed.length;
        int i = 0;
        int j = 0;

        while (i < m && j < m) {
            stack.push(pushed[i]);

            while (!stack.isEmpty() && j < m && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
            i++;

        }
        return stack.empty();
    }
}