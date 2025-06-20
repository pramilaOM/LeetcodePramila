public class Solution {
    private final int[] reverseByte = new int[256];

    // Constructor: fill the reverse lookup table
    public Solution() {
        for (int i = 0; i < 256; i++) {
            reverseByte[i] = reverseByte(i);
        }
    }

    // Reverse the bits in a byte (8-bit)
    private int reverseByte(int b) {
        int res = 0;
        for (int i = 0; i < 8; i++) {
            res |= ((b >> i) & 1) << (7 - i);
        }
        return res;
    }

    public int reverseBits(int n) {
        // Break 32-bit int into 4 bytes and reverse each
        return (reverseByte[n & 0xff] << 24) |
               (reverseByte[(n >>> 8) & 0xff] << 16) |
               (reverseByte[(n >>> 16) & 0xff] << 8) |
               (reverseByte[(n >>> 24) & 0xff]);
    }
}
