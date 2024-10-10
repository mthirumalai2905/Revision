class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        if(n == Integer.MIN_VALUE){
            x *= x;
            n = (Integer.MIN_VALUE)/2;
        }
        if(n < 0){
           x = 1/x;
           n = -n;
        }
        while(n > 0){
            if(n % 2 != 0){
                res *= x;
            }

            x*=x;
            n >>=1;
        }
        return res;
    }
}
