public class UniquePaths {
	public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 1;
        int[] sum = new int[n];
        Arrays.fill(sum, 1);
        for (int i = 1; i < m; i++) {
            sum[0] = 1;
            for (int j = 1; j < n; j++)
                sum[j] += sum[j-1];
        }
        return sum[n-1];
    }
}