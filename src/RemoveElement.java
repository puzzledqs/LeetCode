public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int p = 0;
		int q = 0;
		for (; p < A.length; p++) {
			if (A[p] != elem) {
				A[q] = A[p];
				q++;
			}
		}
		return q;
	}
}