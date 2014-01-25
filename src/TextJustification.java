import java.util.*;
public class TextJustification {
	public static void main(String[] args) {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		ArrayList<String> result = new TextJustification().fullJustify(words, 16);
		for (int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}
	
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		if (words == null || words.length == 0) return result;
		
		int i = 0;
		while (i < words.length) {
			int j = i;
			int len = words[j].length();
			while (true) {
				if (j + 1 < words.length && len + 1 + words[j+1].length() <= L) {
					len += 1 + words[j+1].length();
					j++;
				}
				else
					break;
			}
			if (j == i || j + 1 == words.length) {  // left justified...
				String tmp = words[i];
				for (int k = 0; k < j - i; k++)
					tmp += " " + words[i + k + 1];
				for (; len < L; len++)
					tmp += " ";
				result.add(tmp);
			}
			else {
				int[] num_spaces = new int[j - i];
				for (int k = 0; k < j - i; k++)
					num_spaces[k] = 1;
				for (int k = 0; len + k < L; k++)
					num_spaces[k % (j-i)]++;
				String tmp = words[i];
				for (int k = 0; k < j - i; k++) {
					for (int l = 0; l < num_spaces[k]; l++)
						tmp += " ";
					tmp += words[i + k + 1];
				}
				result.add(tmp);
			}
			i = j + 1;
		}
		return result;
	}
	
}