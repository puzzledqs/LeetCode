public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
    	if (T == null || T.length() == 0) return 1;
    	if (S == null || S.length() ==0) return 0;
    	
    	int tlen = T.length();
    	int slen = S.length();
    	int[] num = new int[tlen + 1];
    	num[0] = 1;
    	for (int i = 1; i <= slen; i++) {
    	    for (int j = tlen; j > 0; j--) {
    	        if (T.charAt(j - 1) == S.charAt(i - 1))
    	            num[j] += num[j - 1];
    	    }
    	}
    	return num[tlen];
    }
}