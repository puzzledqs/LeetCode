import java.util.*;
public class SubstringwithConcatenationofAllWords {
	
	public static void main(String args[]) {
		String S = "a";
		String[] L = {"a"};
		ArrayList<Integer> result 
			= new SubstringwithConcatenationofAllWords().findSubstring(S, L);
		System.out.println(result.get(0));
		
	}
	
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (S == null || L == null) return result;
		if (S.length() == 0 || L.length == 0) return result;
		int len = L[0].length();
		int total = len * L.length;
		
		Map<String, Integer> counter = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			int cnt = counter.containsKey(L[i]) ? counter.get(L[i]) + 1 : 1;
			counter.put(L[i], cnt);
		}
		
		for (int offset = 0; offset < len; offset++) {
			int start = offset;
			int j = 0;
			Map<String, Integer> counter2 = new HashMap<String, Integer>(counter);
			while (start + total <= S.length() && j < L.length) {
				String tmp = S.substring(start + j*len, start + (j+1) * len);
				if (!counter2.containsKey(tmp)) {
					start += (j + 1) * len;
					j = 0;
					counter2 = new HashMap<String, Integer>(counter);
					continue;
				}
				int cnt = counter2.get(tmp) - 1;
				if (cnt < 0) {
					int k = 0;
					while (!S.substring(start + k*len, start + (k+1) * len).equals(tmp))
						k++;
					start += (k + 1) * len;
					j = 0;
					counter2 = new HashMap<String, Integer>(counter);
					continue;
				}
				counter2.put(tmp, cnt);
				j++;
				
				if (j == L.length) {
					result.add(start);
					j--;
					counter2.put(S.substring(start, start+len), 1);
					start += len;
				}
			}
		}
		return result;
		
	}
}