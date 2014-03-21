public class PowXN {
    public double pow(double x, int n) {
        if (x == 0.0) return 0;
        boolean neg = n < 0;
        long nn = Math.abs(n);
        
        double res = 1;
        while (nn > 0) {
            if ((nn & 1) == 1)
                res *= x;
            nn >>= 1;
            x *= x;
        }
        if (neg)
            res = 1 / res;
        return res;
    }
}
