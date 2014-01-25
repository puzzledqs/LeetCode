import java.util.*;
public class AddBinary{
	public static void main(String[] args) {
		String a = "111";
		String b = "1";
		String res = new AddBinary().addBinary(a, b);
		System.out.println(res);
		
	}
	
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0) return b;
		if (b == null || b.length() == 0) return a;
		ArrayList<Character> result = new ArrayList<Character>();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int aa = 0;
			int bb = 0;
			if (i >= 0 && a.charAt(i) == '1')
				aa = 1;
			if (j >= 0 && b.charAt(j) == '1')
				bb = 1;
			int tmp = aa + bb + carry;
			int sum = tmp % 2;
			carry = tmp / 2;
			result.add(0, (char)('0' + sum));
			i--; j--;
		}
		if (carry > 0)
			result.add(0, '1');
		StringBuilder sb = new StringBuilder();
		for (Character c : result)
			sb.append(c);
		return sb.toString();
	}
}