public class DecodeWays {
	public int numDecodings(String s) {
    	if (s == null || s.length() == 0) return 0;
    	
    	int len = s.length();
    	int[] num = new int[len + 1];
    	num[0] = 1;
    	if (s.charAt(0) != '0')
    		num[1] = 1;
    	for (int i = 2; i <= len; i++) {
    		if (s.charAt(i - 1) != '0')
    			num[i] += num[i - 1];
    		if (s.charAt(i - 2) == '1' ||
    			s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')
    			num[i] += num[i - 2];
    	}
    	return num[len];
    }
}