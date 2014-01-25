public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
		if (A == null) return 0;
		int p1 = 0;
		int p2 = 0;
		
		while (p1 < A.length) {
			A[p2] = A[p1];
			p2++;
			int curVal = A[p1];
			while (p1 < A.length && A[p1] == curVal)
				p1++;
		}
		return p2;
	}
}