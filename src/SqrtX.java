public class SqrtX{
	public static void main(String[] args) {
		int x = 2147395599;
		int res = new SqrtX().sqrt(x);
		System.out.println(res);
		
	}
	public int sqrt(int x) {
		if (x == 0) return 0;
		int upperBound = 1;
		int xx = x;
		while (xx > 0) {
			upperBound *= 10;
			xx /= 100;
		}
		int left = upperBound / 10, right = upperBound;
		while (left < right - 1) {
			int mid = (left + right) / 2;
			if (x / mid < mid)
				right = mid;
			else
				left = mid;
		}
		return left;
	}
}