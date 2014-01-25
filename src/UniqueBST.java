public class UniqueBST {
	public int numTrees(int n) {
		if (n < 1) return 0;
		int[] num = new int[n+1];
		num[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				num[i] += num[j] * num[i - j - 1];
			}
		}
		return num[n];
	}
}