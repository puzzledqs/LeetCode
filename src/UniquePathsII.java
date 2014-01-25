public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null) return 0;
		int m = obstacleGrid.length;
		if (m == 0) return 0;
		int n = obstacleGrid[0].length;
		if (n == 0) return 0;
		
		int[] paths = new int[n];
		paths[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
		for (int j = 1; j < n; j++)
			paths[j] = obstacleGrid[0][j] == 0 ? paths[j-1] : 0;
		
		for (int i = 1; i < m; i++) {
			paths[0] = obstacleGrid[i][0] == 0 ? paths[0] : 0;
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) 
					paths[j] = 0;
				else 
					paths[j] = paths[j-1] + paths[j];
			}
		}
		return paths[n-1];
	}
}