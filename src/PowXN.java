public class PowXN {
	public double pow(double x, int n) {
		if (x == 0) return 0;
		
		boolean neg = n < 0;
		n = Math.abs(n);
		double result = 1;
		while (n > 0) {
			if ((n & 1) > 0)
				result *= x;
			x = x * x;
			n >>= 1;
		}
		if (neg)
			result = 1 / result;
		return result;
	}
}