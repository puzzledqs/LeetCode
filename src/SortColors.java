public class SortColors {
	public void sortColors(int[] A) {
		if (A == null) return;
		int[] buckets = new int[3];
		for (int i = 0; i < A.length; i++) {
			buckets[A[i]]++;
		}
		int p = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < buckets[i]; j++) {
				A[p] = i;
				p++;
			}
		}
	}
}