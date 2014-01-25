public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix == null) return result;
		if (matrix.length == 0 || matrix[0].length == 0) return result;
		
		int m = matrix.length;
		int n = matrix[0].length;
		int l = m < n ? m : n;
		l = (l + 1) / 2;
		for (int loop = 1; loop <= l; loop++)
			result.addAll(getOneLoop(matrix, loop));
		return result;
	}
	
	ArrayList<Integer> getOneLoop(int[][] matrix, int loop) {
		int m = matrix.length;
		int n = matrix[0].length;
		int left = loop - 1;
		int top = loop - 1;
		int right = n - loop;
		int bottom = m - loop;
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (top == bottom) {
			for (int i = left; i <= right; i++)
				result.add(matrix[top][i]);
			return result;
		}
		if (left == right) {
			for (int i = top; i <= bottom; i++)
				result.add(matrix[i][left]);
			return result;
		}
		for (int i = left; i < right; i++)
			result.add(matrix[top][i]);
		for (int i = top; i < bottom; i++)
			result.add(matrix[i][right]);
		for (int i = right; i > left; i--)
			result.add(matrix[bottom][i]);
		for (int i = bottom; i > top; i--)
			result.add(matrix[i][left]);
		return result;			
	}
}