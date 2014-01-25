public class SearchinRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		if (A == null) return false;
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) return true;
			
			if (A[left] < A[mid] || A[mid] > A[right]) {
				if (A[left] <= target && target <= A[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}
			else if (A[left] > A[mid] || A[mid] < A[right]) {
				if (A[mid] <= target && target <= A[right])
					left = mid + 1;
				else
					right = mid - 1;
			}
			else {
				left = left + 1;
				right = right - 1;
			}
		}
		return false;
	}
}