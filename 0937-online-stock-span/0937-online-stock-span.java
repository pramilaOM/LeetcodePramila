class StockSpanner {

    public StockSpanner() {
        stack = new Stack<>();

    }

    class Pair {
        int span;
        int price;

        Pair(int span, int price) {
            this.span = span;
            this.price = price;
        }

    }

    Stack<Pair> stack;

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }
        stack.push(new Pair(span, price));
        return span;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */