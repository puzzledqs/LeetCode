public class PalindromePartitioningII {
	public int minCut(String s) {
		if (s == null || s.length() == 0) return 0;
		
		int slen = s.length();
		boolean[][] table = new boolean[slen][slen + 1];
		for (int i = 0; i < slen; i++) {
			table[i][i+1] = true;
			table[i][i] = true;
		}
		for (int l = 2; l <= slen; l++) {
			for (int i = 0; i + l <= slen; i++) {
				int start = i + 1;
				int end = i + l - 1;
				if (table[start][end] && s.charAt(i) == s.charAt(i + l - 1))
					table[i][i + l] = true;
			}
		}
		
		int[] cut = new int[slen + 1];
		cut[0] = 0;
		for (int i = 1; i < cut.length; i++)
				cut[i] = Integer.MAX_VALUE;
		for (int i = 1; i <= slen; i++) {
			for (int j = 0; j < i; j++) {
				if (table[j][i]) {
					if (cut[j] + 1 < cut[i])
						cut[i] = cut[j] + 1;
				}
			}
		}
		return cut[slen] - 1;
	}
}