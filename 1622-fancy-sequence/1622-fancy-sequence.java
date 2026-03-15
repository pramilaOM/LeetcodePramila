class Fancy {

    static final long MOD = 1000000007;
    List<Long> arr;
    long mul, add;

    public Fancy() {
        arr = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    long modPow(long a, long b) {
        long res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;

            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }

    long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    public void append(int val) {
        long stored = ((val - add + MOD) % MOD * modInverse(mul)) % MOD;
        arr.add(stored);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= arr.size()) return -1;
        return (int)((arr.get(idx) * mul + add) % MOD);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */