public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int end = m + n - 1;
		int end1 = m - 1;
		int end2 = n - 1;
		while (end2 >= 0 && end1 >= 0) {
			if (B[end2] > A[end1]) {
				A[end] = B[end2];
				end2--;
			} else {
				A[end] = A[end1];
				end1--;
			}
			end--;
		}
		
		if  (end2 >= 0)
		while (end2 >= 0) {
			A[end] = B[end2];
			end--;
			end2--;
		}
	}
}