public class CountAndSay {
	public String countAndSay(int n) {
		if (n <= 0) return "";
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(1);
		for (int i = 1; i < n; i++) {
			int len = res.size();
			int cnt = 0;
			while (cnt < len) {
				int val = res.remove(0);
				int cnt2 = 1;
				cnt++;
				while (cnt < len && res.get(0) == val) {
					res.remove(0);
					cnt++;
					cnt2++;
				}
				Stack<Integer> stk = new Stack<Integer>();
				while (cnt2 > 0) {
					stk.push(cnt2 % 10);
					cnt2 /= 10;
				}
				while (!stk.isEmpty())
					res.add(stk.pop());
				res.add(val);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Integer i : res)
			sb.append(String.valueOf(i));
		return sb.toString();
	}
}