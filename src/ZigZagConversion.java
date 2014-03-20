public class ZigZagConversion {
	public String convert(String s, int nRows) {
        if (s.length() == 0) return "";
        if (nRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int l = 2 * (nRows - 1);
        for (int i = 0; i < nRows; i++) {
            if (i == 0 || i == nRows - 1) {
                for (int j = i; j < s.length(); j += l)
                    sb.append(s.charAt(j));
            }
            else {
                int j = i;
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    j += 2 * (nRows - i - 1);
                    if (j < s.length()) {
                        sb.append(s.charAt(j));
                        j += 2 * i;
                    }
                }
            }
        }
        return sb.toString();
    }
}
