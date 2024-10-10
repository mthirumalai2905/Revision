class Solution {
    private static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;  
        long oddCount = n / 2;         
        
        long evenProduct = modPow(5, evenCount, MOD);
        long oddProduct = modPow(4, oddCount, MOD);
        
        return (int) ((evenProduct * oddProduct) % MOD);
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
