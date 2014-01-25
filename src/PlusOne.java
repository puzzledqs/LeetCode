import java.util.*;
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = 1;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = digits.length - 1; i >= 0; i--) {
			int tmp = carry + digits[i];
			carry = tmp / 10;
			result.add(0, tmp % 10);
		}
		if (carry > 0)
			result.add(0, carry);
		int[] res = new int[result.size()];
		int pos = 0;
		for (Integer d:result) {
			res[pos] = d;
			pos++;
		}
		return res;
	}
}