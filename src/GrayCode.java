import java.util.*;
public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (n < 1) {
			result.add(0);
			return result;
		}
		
		result.add(0);
		result.add(1);
		int base = 1;
		for (int i = 1; i < n; i++) {
			base *= 2;
			Stack<Integer> stk = new Stack<Integer>();
			Iterator<Integer> iter = result.iterator();
			while (iter.hasNext()) {
				stk.push(iter.next() + base);
			}
			while (!stk.isEmpty())
				result.add(stk.pop());
		}
		return result;
	}
}