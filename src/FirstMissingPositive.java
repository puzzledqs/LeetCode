public class FirstMissingPositive{
	public int firstMissingPositive(int[] A) {
		for (int i = 0; i < A.length; i++) {
			int idx = i;
			int tmp = A[idx];
			while (true) {
				int newIdx = tmp - 1;
				if (newIdx < 0 || newIdx >= A.length) break;
				if (newIdx == idx) break;
				tmp = A[newIdx];
				A[newIdx] = newIdx + 1;
				idx = newIdx;
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i+1)
				return i + 1;
		}
		return A.length + 1;
	}
}