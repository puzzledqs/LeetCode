public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null) return 0;
		if (grid.length == 0 || grid[0].length == 0) return 0;
		
		int[] pathSum = new int[grid[0].length];
		for (int j = 0; j < grid[0].length; j++) {
			if (j == 0) pathSum[j] = grid[0][0];
			else
				pathSum[j] = pathSum[j-1] + grid[0][j];
		}
		for (int i = 1; i < grid.length; i++) {
			pathSum[0] = pathSum[0] + grid[i][0];
			for (int j = 1; j < grid[0].length; j++) {
				int tmp = pathSum[j-1] < pathSum[j] ? pathSum[j-1] : pathSum[j];
				pathSum[j] = tmp + grid[i][j];
			}
		}
		return pathSum[grid[0].length - 1];
	}
	
	public int minPathSum2(int[][] grid) {
		if (grid == null) return 0;
		if (grid.length == 0 || grid[0].length == 0) return 0;
		
		int[][] pathSum = new int[grid.length][grid[0].length];
		pathSum[0][0] = grid[0][0];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0 && j == 0) continue;
				
				int tmp = Integer.MAX_VALUE;
				if (j > 0)
					tmp = pathSum[i][j-1];
				if (i > 0 && pathSum[i-1][j] < tmp)
					tmp = pathSum[i-1][j];
				
				pathSum[i][j] = tmp + grid[i][j];
			}
		}
		return pathSum[grid.length - 1][grid[0].length - 1];
	}
}