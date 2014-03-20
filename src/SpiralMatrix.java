public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) return result;
        
        int m = matrix.length, n = matrix[0].length;
        int level = -1;
        while (true) {
            level++;
            int left = level, top = level;
            int right = n - 1 - level, bottom = m - 1 - level;
            if (left > right || top > bottom) break;
            if (left == right) {
                for (int i = top; i <= bottom; i++)
                    result.add(matrix[i][left]);
                continue;
            }
            if (top == bottom) {
                for (int j = left; j <= right; j++)
                    result.add(matrix[top][j]);
                continue;
            }
            for (int j = left; j < right; j++)
                result.add(matrix[top][j]);
            for (int i = top; i < bottom; i++)
                result.add(matrix[i][right]);
            for (int j = right; j > left; j--)
                result.add(matrix[bottom][j]);
            for (int i = bottom; i > top; i--)
                result.add(matrix[i][left]);
        }
        return result;
    }
}
