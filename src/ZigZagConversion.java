public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if (s == null || s.length() == 0) return s;
		if (nRows <= 1) return s;
		
		int K = 2 * (nRows - 1);
		int slen = s.length();
		StringBuilder[] sbs = new StringBuilder[nRows];
		String res = "";
		for (int i = 0; i < nRows; i++) {
			sbs[i] = new StringBuilder();
			if (i == 0 || i == nRows - 1) {
				for (int j = i; j < slen; j += K)
					sbs[i].append(s.charAt(j));
			}
			else {
				for (int j = 0; j < slen; j += K) {
					if (j + i < slen)
						sbs[i].append(s.charAt(j + i));
					if (j + (K - i) < slen)
						sbs[i].append(s.charAt(j + (K - i)));
				}
			}
			res += sbs[i].toString();
		}
		return res;
	}
}