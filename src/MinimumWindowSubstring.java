public class MinimumWindowSubstring {
	
	public static void main(String[] args) {
		String S = "aabaabaaab";
		String T = "bb";
		String result = new MinimumWindowSubstring().minWindow(S, T);
		System.out.println(result);
	}
	
	public String minWindow(String S, String T) {
		if (S == null || S.length() == 0) return "";
		if (T == null || T.length() == 0) return "";
		
		int[] need = new int[256];
		int[] found = new int[256];
		for (int i = 0; i < T.length(); i++) {
			char tmp = T.charAt(i);
			need[(int)tmp]++;
		}
		
		int left = 0, right = 0;
		int cnt = 0;
		boolean isfind = false;
		String result = S;
		while (left < S.length() && right < S.length()) {
			while (left < S.length()) {
				char c = S.charAt(left);
				if (need[(int)c] > 0) {
					if (found[(int)c] > need[(int)c])
						found[(int)c]--;
					else {
						if (found[(int)c] < need[(int)c] && found[(int)c] == 0) {
							found[(int)c]++;
							cnt++;
						}
						break;
					}
				}
				left++;
			}
			if (right == 0) right = left + 1;
			while (cnt < T.length() && right < S.length()) {
				char c = S.charAt(right);
				if (need[(int)c] > 0) {
					found[(int)c]++;
					if (found[(int)c] > need[(int)c]) {
						if (c == S.charAt(left)) {
							right++;
							break;
						}
					}
					else cnt++;
				}
				right++;
			}
			if (cnt == T.length()) {
				isfind = true;
				if (right - left < result.length())
					result = S.substring(left, right);
				found[(int)(S.charAt(left))]--;
				cnt--;
				left++;
			}
		}
		return isfind ? result : "";
	}
}