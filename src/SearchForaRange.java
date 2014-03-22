public class SearchForaRange {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        if (left == A.length || A[left] != target) {
            Arrays.fill(result, -1);
            return result;
        }
        result[0] = left;
        right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        result[1] = right;
        return result;
    }
}
