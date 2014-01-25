public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		if (S == null || T == null) return 0;
		int[] num = new int[T.length()+1];
		num[0] = 1;
		for (int i = 0; i < S.length(); i++) {
			for (int j = T.length(); j >= 1; j--) {
				if (S.charAt(i) == T.charAt(j-1))
					num[j] += num[j-1];
			}
		}
		return num[T.length()];
	}
}