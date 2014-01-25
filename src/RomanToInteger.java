public class RomanToInteger {
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) return 0;
		
		int start = 0;
		int result = 0;
		String t = "";
		int base = 0;
		while (start < s.length()) {
			switch (s.charAt(start)) {
				case 'I':
				case 'V': t = "IVX"; base = 1; break;
				case 'X': 
				case 'L': t = "XLC"; base = 10; break;
				case 'C':
				case 'D': t = "CDM"; base = 100; break;
				case 'M': t = "M  "; base = 1000; break;
			}
			int end = start;
			while (end < s.length() && t.indexOf(s.charAt(end)) != -1)
				end++;
			result += decode(s.substring(start, end), t, base);
			start = end;
		}
		return result;
	}
	
	int decode(String s, String t, int base) {
		int len = s.length();
		if (s.charAt(len-1) == t.charAt(2))  // IX
			return 9 * base;
		if (s.charAt(0) == t.charAt(1))  // VII
			return (len - 1 + 5) * base;
		if (s.charAt(len-1) == t.charAt(1))  // IV
			return 4 * base;
		return len * base;   // II
	}
}