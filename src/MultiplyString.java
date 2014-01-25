public class MultiplyString {
	public String multiply(String num1, String num2) {
		if (num1 == null || num1.length() == 0) return "";
		if (num2 == null || num2.length() == 0) return "";
		
		int len1 = num1.length();
		int len2 = num2.length();
		int len3 = len1 + len2;
		int[] prod = new int[len3];
		for (int i = 0; i < len2; i++) {
		    int a = num2.charAt(len2 - 1 - i) - '0';
		    for (int j = 0; j < len1; j++) {
		        int b = num1.charAt(len1 - 1 - j) - '0';
		        int tmp = a * b;
		        prod[i + j] += tmp;
		        if (j == 0 || i == len2 - 1) {
		            prod[i + j + 1] += prod[i + j] / 10;
		            prod[i + j] %= 10;
		        }  
		    }
		}
		int i;
		for (i = len3 - 1; i >= 0; i--)
		    if (prod[i] != 0)
		        break;
		
		if (i < 0)
		    return "0";
		StringBuilder sb = new StringBuilder();
		for (; i >= 0; i--)
		    sb.append(prod[i]);
		return sb.toString();
	}
}