public class IntegerToRoman {
	public String intToRoman(int num) {
		String[] patterns = {"IVX", "XLC", "CDM", "M  "};
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while (num > 0) {
			String tmp = encode(num % 10, patterns[cnt]);
			for (int i = tmp.length() - 1; i >= 0; i--)
				sb.append(tmp.charAt(i));
			num /= 10;
			cnt++;
		}
		return sb.reverse().toString();
	}
	
	String encode(int num, String t) {
		if (num == 0) return "";
		StringBuilder sb = new StringBuilder();
		if (num <= 3) {
			for (int i = 0; i < num; i++)
				sb.append(t.charAt(0));
		} 
		else if (num <= 4) {
			sb.append(t.charAt(0));
			sb.append(t.charAt(1));
		}
		else if (num <= 8) {
			sb.append(t.charAt(1));
			for (int i = 5; i < num; i++)
				sb.append(t.charAt(0));
		}
		else {
			sb.append(t.charAt(0));
			sb.append(t.charAt(2));
		}
		return sb.toString();
	}
}