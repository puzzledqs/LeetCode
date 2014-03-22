public class RotateImage {
    public void rotate(int[][] matrix) {
        int l = 0;
        while (l < matrix.length / 2) {
            int left = l, right = matrix.length - 1 - l;
            int top = l, bottom = right;
            for (int i = 0; i < right - left; i++) {
                int tmp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = tmp;
            }
            l++;
        }
    }
}
