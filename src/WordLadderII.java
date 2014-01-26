import java.util.*;
public class WordLadderII {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		if (dict == null) dict = new HashSet<String>();
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		Queue<String> q1 = new LinkedList<String>();
		HashSet<String> visit = new HashSet<String>();
		HashMap<String, ArrayList<String>> prev = new HashMap<String, ArrayList<String>>();
		boolean find = false;
		q1.add(start);
		dict.remove(start);
		while (!q1.isEmpty() && !find) {
			Queue<String> q2 = new LinkedList<String>();
			while (!q1.isEmpty()) {
				String word = q1.remove();
				char[] charArray = word.toCharArray();
				for (int i = 0; i < word.length(); i++) {
					for (int j = 'a'; j <= 'z'; j++) {
						char newc = (char)j;
						if (newc == word.charAt(i))
							continue;
						charArray[i] = newc;
						String news = String.valueOf(charArray);
						if (news.equals(end)) {
							find = true;
							if (prev.containsKey(news))
								prev.get(news).add(word);
							else {
								ArrayList<String> tmp = new ArrayList<String>();
								tmp.add(word);
								prev.put(news, tmp);
							}
							continue;
						}
						if (dict.contains(news) && !visit.contains(news)) {
							if (prev.containsKey(news))
								prev.get(news).add(word);
							else {
								ArrayList<String> tmp = new ArrayList<String>();
								tmp.add(word);
								prev.put(news, tmp);
							}
							q2.add(news);
						}
					}
					charArray[i] = word.charAt(i);
				}
			}
			while (!q2.isEmpty()) {
				String s = q2.remove();
				if (visit.contains(s))
					continue;
				visit.add(s);
				q1.add(s);
			}
		}
		if (find) {
			ArrayList<String> cur_res = new ArrayList<String>();
			dfs(result, prev, end, start, cur_res);
		}
		return result;
	}
	
	void dfs(ArrayList<ArrayList<String>> result, HashMap<String, ArrayList<String>> prev, 
			String end, String start, ArrayList<String> cur_res) {
		if (end.equals(start)) {
			cur_res.add(0, start);
			result.add(new ArrayList<String>(cur_res));
			cur_res.remove(0);
			return;
		}
		
		cur_res.add(0, end);
		ArrayList<String> tmp = prev.get(end);
		for (String s : tmp) {
			dfs(result, prev, s, start, cur_res);
		}
		cur_res.remove(0);
	}
}