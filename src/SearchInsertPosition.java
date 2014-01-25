public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) return 0;
		
		int left = 0;
		int right = A.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) return mid;
			if (target > A[mid])
				left = mid + 1;
			else
				right = mid - 1;
		}
		return left;
	}
}