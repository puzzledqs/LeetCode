import java.util.*;
public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		if (dict == null) dict = new HashSet<String>();
		
		Queue<String> q1 = new LinkedList<String>();
		HashSet<String> visit = new HashSet<String>();
		int len = 1;
		q1.add(start);
		visit.add(start);
		while (!q1.isEmpty()) {
			Queue<String> q2 = new LinkedList<String>();
			len++;
			while (!q1.isEmpty()) {
				String word = q1.remove();
				for (int i = 0; i < word.length(); i++) {
					char[] charArray = word.toCharArray();
					for (int j = 'a'; j <= 'z'; j++) {
						char newc = (char) j;
						if (newc == word.charAt(i))
							continue;
						charArray[i] = newc;
						String s = String.valueOf(charArray);
						if (s.equals(end))
							return len;
						if (dict.contains(s) && !visit.contains(s)) {
							visit.add(s);
							q2.add(s);
						}
					}
				}
			}
			q1 = q2;
		}
		return 0;
	}
}