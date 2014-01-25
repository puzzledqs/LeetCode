public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		int sign = 1;
		if (dividend < 0) sign = -sign;
		if (divisor < 0) sign = -sign;
		
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		long c = 1;
		while (a >= b) {
		    b = b << 1;
		    c = c << 1;
		}
		b = b >> 1; c = c >> 1;
		long res = 0;
		while (c > 0) {
		    if (a >= b) {
		        res += c;
		        a -= b;
		    }
		    c = c >> 1;
		    b = b >> 1;
		}
		return (int)(sign * res);
	}
}