public class PalindromePartitioningII {
	public int minCut(String s) {
		if (s.length() <= 1) return 0;
		
		int slen = s.length();
		boolean[][] isPalin = new boolean[slen][slen];
		isPalin[slen - 1][slen - 1] = true;
		for (int mid = 0; mid < s.length() - 1; mid++) {
		    expand(s, mid, mid, isPalin);
		    expand(s, mid, mid + 1, isPalin);
		}
		
		int[] cut = new int[slen + 1];
		cut[0] = -1;
		for (int i = 1; i <= slen; i++) {
		    cut[i] = i - 1;
		    for (int j = 0; j < i; j++) {
		        if (isPalin[j][i - 1])
		            cut[i] = Math.min(cut[i], cut[j] + 1);
		    }
		}
		return cut[slen];
	}
	
	public void expand(String s, int left, int right, boolean[][] isPalin) {
	    while (left >= 0 && right < s.length()) {
	        if (s.charAt(left) == s.charAt(right)) {
	            isPalin[left][right] = true;
	            left--; right++;
	        }
	        else
	            break;
	    }
	}
}
