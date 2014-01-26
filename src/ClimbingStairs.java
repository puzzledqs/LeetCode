public class ClimbingStairs {
	public int climbStairs(int n) {
        if (n <= 1) return 1;
        int[] sum = new int[n + 1];
        sum[0] = 1;
        sum[1] = 1;
        for (int i = 2; i <= n; i++)
            sum[i] = sum[i-1] + sum[i-2];
        return sum[n];
    }
}