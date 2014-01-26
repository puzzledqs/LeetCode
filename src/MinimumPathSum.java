public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int M = grid.length;
        int N = grid[0].length;
        int[] sum = new int[N];
        sum[0] = grid[0][0];
        for (int j = 1; j < N; j++)
            sum[j] = sum[j-1] + grid[0][j];
        for (int i = 1; i < M; i++) {
            sum[0] += grid[i][0];
            for (int j = 1; j < N; j++) {
                int tmp = sum[j-1] < sum[j] ? sum[j-1] : sum[j];
                sum[j] = tmp + grid[i][j];
            }
        }
        return sum[N-1];
    }
}