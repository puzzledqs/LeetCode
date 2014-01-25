public class SearchForaRange {
	public int[] searchRange(int[] A, int target) {
		int[] result = new int[2];
		result[0] = -1; result[1] = -1;
		if (A == null || A.length == 0) return result;
		
		int left, right;
		left = 0; right = A.length - 1;
		boolean found = false;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) found = true;
			if (target <= A[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		if (!found)
			return result;
		result[0] = left;
		left = 0; right = A.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target < A[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		result[1] = right;
		return result;
	}
}