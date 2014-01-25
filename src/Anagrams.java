public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		if (strs == null) return result;
		
		HashMap<String, Integer> str2idx = new HashMap<String, Integer>();
		for (int i = 0; i < strs.length; i++) {
			char[] charArray = strs[i].toCharArray();
			Arrays.sort(charArray);
			String sortedStr = String.valueOf(charArray);
			if (str2idx.containsKey(sortedStr)) {
				if (str2idx.get(sortedStr) != -1) {
					result.add(strs[str2idx.get(sortedStr)]);
					str2idx.put(sortedStr, -1);
				}
				result.add(strs[i]);	
			}
			else {
				str2idx.put(sortedStr, i);
			}
		}
		return result;
	}
}