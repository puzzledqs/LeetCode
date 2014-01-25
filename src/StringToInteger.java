public class StringToInteger {
	public int atoi(String str) {
		int res = 0;
		int sign = 1;
		int i;
		for (i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ')
				break;
		}
		if (i == str.length()) return 0;
		if (str.charAt(i) == '-') {sign = -1; i++;}
		else if (str.charAt(i) == '+') {sign = 1; i++;}
		if (str.charAt(i) < '0' || str.charAt(i) > '9')
			return 0;
		for (; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') break;
			if (sign == 1 && res > Integer.MAX_VALUE / 10) return Integer.MAX_VALUE;
			if (sign == 1 && res == Integer.MAX_VALUE / 10 && str.charAt(i) >= '7') return Integer.MAX_VALUE;
			if (sign == -1 && res > -(Integer.MIN_VALUE / 10)) return Integer.MIN_VALUE;
			if (sign == -1 && res == -(Integer.MIN_VALUE / 10) && str.charAt(i) >= '8') return Integer.MIN_VALUE;
			res = res * 10 + (str.charAt(i) - '0');
		}
		return sign * res;
	}
}