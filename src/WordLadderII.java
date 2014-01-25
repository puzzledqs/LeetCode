import java.util.*;
public class WordLadderII {
	
	public static void main(String args[]) {
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
		ArrayList<ArrayList<String>> res = new WordLadderII().findLadders(start, end, dict);
		System.out.println(res.size());
	}
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		Map<String, ArrayList<String>> prevWord = new HashMap<String, ArrayList<String>>();
		Queue<String> q = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		
		q.add(start); visited.add(start);
		boolean reach = false;
		while (!q.isEmpty()) {   // BFS to build back pointers
			Queue<String> tmp = new LinkedList<String>();
			while (!q.isEmpty()) {
				String s = q.remove();
				for (int i = 0; i < s.length(); i++) {
					char[] charArray = s.toCharArray();
					for (int j = 'a'; j <= 'z'; j++) {
						char newchar = (char)j;
						if (s.charAt(i) == newchar)
							continue;					
						charArray[i] = newchar;
						String newstring = String.valueOf(charArray);
						if (newstring.equals(end)) {
							reach = true;
							if (prevWord.containsKey(newstring))
								prevWord.get(newstring).add(s);
							else {
								ArrayList<String> tmpArray = new ArrayList<String>();
								tmpArray.add(s);
								prevWord.put(newstring, tmpArray);
							}
							break;
						}
						if (!visited.contains(newstring) && dict.contains(newstring)) {
							if (prevWord.containsKey(newstring))
								prevWord.get(newstring).add(s);
							else {
								ArrayList<String> tmpArray = new ArrayList<String>();
								tmpArray.add(s);
								prevWord.put(newstring, tmpArray);
							}
							tmp.add(newstring);
						}
					}
				}
			}
			if (reach) 
				break;
			while (!tmp.isEmpty()) {
				String s = tmp.remove();
				if (!visited.contains(s))
					q.add(s);
				visited.add(s);
			}
		}
		
		// back track
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> cur_res = new ArrayList<String>();
		if (reach) {
			dfs(start, end, result, prevWord, cur_res);
		}
		return result;
	}
	
	void dfs(String start, String s_cur, ArrayList<ArrayList<String>> result,
				 Map<String, ArrayList<String>> prevWord, ArrayList<String> cur_res) {
		if (s_cur.equals(start)) {
			cur_res.add(0, s_cur);
			result.add(new ArrayList<String>(cur_res));
			cur_res.remove(0);
			return;
		}
		ArrayList<String> array = prevWord.get(s_cur);
		Iterator<String> iter = array.iterator();
		while (iter.hasNext()) {
			String s_prev = iter.next();
			cur_res.add(0, s_cur);
			dfs(start, s_prev, result, prevWord, cur_res);
			cur_res.remove(0);
		}
	}
}