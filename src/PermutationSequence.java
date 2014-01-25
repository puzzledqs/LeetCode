public class PermutationSequence {
	
	public static void main(String[] args) {
		String result = new PermutationSequence().getPermutation(3, 6);
		System.out.println(result);
		
	}
	
	public String getPermutation(int n, int k) {
		boolean[] use = new boolean[n];
		char[] perm = new char[n];
		k = (k - 1) % factor(n);
		
		for (int i = 0; i < n; i++) {
			int tmp = factor(n - i - 1);
			int l = k / tmp;
			k = k % tmp;
			for (int j = 0; j < use.length; j++) {
				if (!use[j]) {
					if (l == 0) {
						perm[i] = (char)('0' + j + 1);
						use[j] = true;
						break;
					}
					else
						l--;	
				}
			}
		}
		return new String(perm);
	}
	
	int factor(int k) {
		int prod = 1;
		for (int i = 1; i <= k; i++)
			prod *= i;
		return prod;
	}
}