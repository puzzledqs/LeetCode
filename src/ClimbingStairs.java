public class ClimbingStairs {
	public int climbStairs(int n) {		
		int[] num = new int[n+1];
		num[0] = 1;
		for (int i = 1; i <= n; i++) {
			num[i] = num[i - 1];
			if (i > 1)
				num[i] += num[i - 2];
		}
		return num[n];
	}
}