import java.util.*;
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
    	if (num == null || num.length == 0) return 0;
    	
    	int max = 0;
    	Set<Integer> set = new HashSet<Integer>();
    	for (int i = 0; i < num.length; i++)
    		set.add(num[i]);
    	for (int i = 0; i < num.length; i++) {
    		if (!set.contains(num[i]))
    			continue;
    		int right = num[i] + 1;
    		int left = num[i] - 1;
    		while (set.contains(right)) {
    			set.remove(right);
    			right++;
    		}
    		while (set.contains(left)) {
    			set.remove(left);
    			left--;
    		}
    		int tmp = right - left - 1;
    		if (tmp > max)
    			max = tmp;
    	}
    	return max;
    }
}