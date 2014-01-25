public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null) return false;
		if (matrix.length == 0 || matrix[0].length == 0) return false;
		int row = matrix.length;
		int col = matrix[0].length;
		
		int left = 0, right = row - 1;
		int mid;
		int idx;
		if (target < matrix[0][0]) idx = -1;
		else if (target >= matrix[row-1][0]) idx = row-1;
		else {
			while (left < right-1) {
				mid = left + (right - left) / 2;
				if (target < matrix[mid][0])
					right = mid;
				else
					left = mid;
			}
			idx = left;	
		}
		if (idx == -1) return false;
		left = 0; right = col - 1;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (target == matrix[idx][mid]) return true;
			if (target < matrix[idx][mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return false;
		
			
	}
}	