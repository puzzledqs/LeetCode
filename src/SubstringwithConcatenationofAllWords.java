import java.util.*;
public class SubstringwithConcatenationofAllWords {
	public ArrayList<Integer> findSubstring(String s, String[] L) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0) return result;
		if (L == null || L.length == 0) return result;
		
		int N = L.length;
		int len = L[0].length();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			if (!map.containsKey(L[i]))
				map.put(L[i], 1);
	    	else
				map.put(L[i], map.get(L[i]) + 1);
		}
		
		for (int i = 0; i + len * N <= s.length(); i++) {
			HashMap<String, Integer> tmp = new HashMap<String, Integer>(map);
			int j = 0;
			for (; j < N; j++) {
				int start = i + j * len;
				int end = start + len;
				String str = s.substring(start, end);
				if (!tmp.containsKey(str)) break;
				int cnt = tmp.get(str);
				cnt--;
				tmp.put(str, cnt);
				if (cnt == 0)
					tmp.remove(str);
			}
			if (j == N)
				result.add(i);
		}
		return result;
    }
}