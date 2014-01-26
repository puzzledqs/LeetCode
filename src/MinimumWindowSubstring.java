public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
    	if (T == null || T.length() == 0) return "";
    	
    	int left = 0, right = 0;
    	int start = -1, end = 2 * S.length();
    	int[] need = new int[256];
    	int[] found = new int[256];
    	
    	int slen = S.length();
    	int tlen = T.length();
    	for (int i = 0; i < T.length(); i++) {
    		char ch = T.charAt(i);
    		need[(int)ch]++;
    	}
    	
    	int cnt = 0;
    	for (; right < slen; right++) {
    		char ch = S.charAt(right);
    		if (need[(int)ch] == 0)
    			continue;
    		if (found[(int)ch] < need[(int)ch])
    			cnt++;
    		found[(int)ch]++;
    		
    		if (cnt == tlen) {
    			while (true) {
    				char c = S.charAt(left);
    				if (need[(int)c] == 0) {
    					left++;
    					continue;
    				}
    				if (found[(int)c] > need[(int)c]) {
    					found[(int)c]--;
    					left++;
    					continue;
    				}
    				break;
    			}
    			if (right - left < end - start) {
    				end = right;
    				start = left;
    			}
    		}
    	}
    	if (start == -1)
    		return "";
    	return S.substring(start, end + 1);
    }
}