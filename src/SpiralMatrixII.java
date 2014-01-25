public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		if (n < 0) return null;
		int[][] matrix = new int[n][n];
		int num = 1;
		int loop = 1;
		int l = (n + 1) / 2;
		while (loop <= l) {
			int left = loop - 1, top = loop - 1;
			int right = n - loop, bottom = n - loop;
			if (left == right) {
				matrix[top][left] = num;
				break;
			}
			for (int i = left; i < right; i++)
				matrix[top][i] = num++;
			for (int i = top; i < bottom; i++)
				matrix[i][right] = num++;
			for (int i = right; i > left; i--)
				matrix[bottom][i] = num++;
			for (int i = bottom; i > top; i--)
				matrix[i][left] = num++;
			loop++;
		}
		return matrix;
	}
}