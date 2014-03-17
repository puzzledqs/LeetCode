public class WildcardMatching {
	public boolean isMatch(String s, String p) {
    	int i = 0, j = 0;
    	int pos_i = -1, pos_j = -1;
    	while (i < s.length()) {
    	    if (j != p.length()) {
    	        if (p.charAt(j) == '*') {
    	            pos_i = i + 1;
    	            pos_j = j + 1;
    	            j++;
    	            continue;
    	        }
    	        if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
    	            i++; j++;
    	            continue;
    	        }
    	    }
    	    if (pos_i < 0) return false;
    	    i = pos_i++;
    	    j = pos_j;
    	}
    	while (j < p.length() && p.charAt(j) == '*')
    	    j++;
    	return j == p.length();
    }
}
