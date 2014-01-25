public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length <= 1) return;
		
		int L = matrix.length / 2;
		for (int level = 1; level <= L; level++) {
			int left = level - 1;
			int top = level - 1;
			int right = matrix.length - level;
			int bottom = matrix.length - level;
			int l = matrix.length - (2*level) + 1;
			for (int j = 0; j < l; j++) {
				int tmp = matrix[top][left + j];
				matrix[top][left + j] = matrix[bottom - j][left];
				matrix[bottom - j][left] = matrix[bottom][right - j];
				matrix[bottom][right - j] = matrix[top+j][right];
				matrix[top+j][right] = tmp;
			}
		}
	}
}