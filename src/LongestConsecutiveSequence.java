import java.util.*;
public class LongestConsecutiveSequence {
	
	public static void main(String[] args) {
		int[] test = {100, 4, 200, 1, 3, 2};
		int len = new LongestConsecutiveSequence().longestConsecutive(test);
		System.out.println(len);
	
	}
	
	public int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++)
			set.add(num[i]);
		
		int maxlen = 0;
		while (set.iterator().hasNext()) {
			int seed = set.iterator().next();
			set.remove(seed);
			int len = 1;
			int left = seed - 1;
			int right = seed + 1;
			while (set.contains(left) || set.contains(right)) {
				if (set.contains(left)) {
					set.remove(left);
					len++;
					left--;
				}
				if (set.contains(right)) {
					set.remove(right);
					len++;
					right++;
				}
			}
			if (len > maxlen)
				maxlen = len;
		}
		return maxlen;
	}
}