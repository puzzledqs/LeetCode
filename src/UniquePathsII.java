public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 1;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] sum = new int[n];
        sum[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int j = 1; j < n; j++)
            sum[j] = obstacleGrid[0][j] == 1 ? 0 : sum[j-1];
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                sum[0] = 0;

            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    sum[j] = 0;
                else 
                    sum[j] += sum[j-1];
            }
        }
        return sum[n-1];
    }
}