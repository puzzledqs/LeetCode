import java.util.*;
public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
    	ArrayList<String> result = new ArrayList<String>();
    	if (words == null || words.length == 0) {
    		result.add("");
    		return result;
    	}
    	
    	int start = 0;
    	while (start < words.length) {
    		int len = words[start].length();
    		int j = start + 1;
    		while (j < words.length) {
    		    if (len + 1 + words[j].length() > L)
    		        break;
    		    len += 1 + words[j].length();
    		    j++;
    		}
    		StringBuilder sb = new StringBuilder();
    		if (j == start + 1 || j == words.length) {
    			while (start < j - 1) {
    				sb.append(words[start] + " ");
    				start++;
    			}
    			sb.append(words[start]);
    			start++;
    			int spaces = L - len;
    			for (int l = 0; l < spaces; l++)
    				sb.append(" ");
    		}
    		else {
    			
    			int N = j - start;
    			int spaces = L - len;
    			int m = spaces / (N - 1);
    			int k = spaces % (N - 1);
    			while (start < j - 1) {
    				sb.append(words[start] + " ");
    				for (int l = 0; l < m; l++)
    					sb.append(" ");
    				if (k > 0) {
    					sb.append(" ");
    					k--;
    				}
    				start++;
    			}
    			sb.append(words[start]);
    			start++;
    		}
    		result.add(sb.toString());
    	}
    	return result;
    }
}