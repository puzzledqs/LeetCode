public class PalindromePartitioningII {
	public int minCut(String s) {
		boolean[][] isPalin = new boolean[s.length()][s.length()+1];
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j <= s.length()-i; j++) {
				if (i == 1) {
					isPalin[j][j] = true;
					isPalin[j][j+1] = true; // [j:j+1)
				}
				else {
					if (isPalin[j+1][j+i-1] == true && s.charAt(j) == s.charAt(j+i-1))
						isPalin[j][j+i] = true;
				}
			}
		}
		
		int[] minCount = new int[s.length()+1]; // minCount[pos] --> cut for [0:pos)
		minCount[0] = -1;
		for (int i = 1; i <= s.length(); i++) {
			int tmp = s.length();
			for (int j = 0; j < i; j++) {
				if (isPalin[j][i]) {
					if (minCount[j] + 1 < tmp)
						tmp = minCount[j] + 1;
				}
			}
			minCount[i] = tmp;
		}
		return minCount[s.length()];
	}

}