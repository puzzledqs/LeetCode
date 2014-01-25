public class DecodeWays {
	public static void main(String args[]) {
		String s = "12";
		int result = new DecodeWays().numDecodings(s);
		System.out.println(result);
			
	}
	
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) return 0;
		
		int[] num = new int[s.length() + 1];
		num[0] = 1;
		for (int i = 1; i <= s.length(); i++) {
			if (s.charAt(i-1) != '0')
				num[i] += num[i - 1];
			if (i > 1) {
				String tmp = s.substring(i-2, i);
				if (Integer.valueOf(tmp) <= 26 && Integer.valueOf(tmp) >= 10)
					num[i] += num[i - 2];
			}
		}
		return num[s.length()];
	}
	
	
	int total;
	public int numDecodings1(String s) {
		if (s == null || s.length() == 0) return 0;
		dfs(s, 0);
		return total;
	}
	
	void dfs(String s, int start) {
		if (start == s.length()) {
			total++;
			return;
		}
		if (s.charAt(start) == '0') return;
		dfs(s, start + 1);
		if ((s.charAt(start) == '1' || s.charAt(start) == '2') && start < s.length()-1) {
			String tmp = s.substring(start, start+2);
			if (Integer.valueOf(tmp) <= 26)
				dfs(s, start + 2);
		}
	}
}