public class SetMatrixZeros{
	public void setZeroes(int[][] matrix) {
		if (matrix == null) return;
		if (matrix.length == 0) return;
		
		boolean firstrow = false, firstcol = false;
		for (int i = 0; i < matrix.length; i++)
			if (matrix[i][0] == 0) {
				firstcol = true;
				break;
			}
		for (int j = 0; j < matrix[0].length; j++)
			if (matrix[0][j] == 0) {
				firstrow = true;
				break;
			}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < matrix[i].length; j++)
					matrix[i][j] = 0;
			}
		}
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < matrix.length; i++)
					matrix[i][j] = 0;
			}
		}
		
		if (firstcol)
			for (int i = 0; i < matrix.length; i++)
				matrix[i][0] = 0;
		if (firstrow) 
			for (int j = 0; j < matrix[0].length; j++)
				matrix[0][j] = 0;
	}
}