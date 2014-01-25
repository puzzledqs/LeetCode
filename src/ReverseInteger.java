public class ReverseInteger {
	public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }
}