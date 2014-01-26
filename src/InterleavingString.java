public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
    	if (s1 == null) s1 = "";
    	if (s2 == null) s2 = "";
    	if (s3 == null) s3 = "";
    	
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 + len2 != s3.length()) return false;
        
        boolean[] match = new boolean[len2 + 1];
        match[0] = true;
        for (int j = 1; j <= len2; j++)
            match[j] = match[j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        
        for (int i = 1; i <= len1; i++) {
            match[0] = match[0] && s1.charAt(i-1) == s3.charAt(i-1);
            for (int j = 1; j <= len2; j++)
                match[j] = (match[j-1] && s2.charAt(j-1) == s3.charAt(i + j - 1))
                            || (match[j] && s1.charAt(i-1) == s3.charAt(i + j -1));
        }
        return match[len2];
    }
}