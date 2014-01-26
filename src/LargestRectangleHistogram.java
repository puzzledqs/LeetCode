import java.util.*;
public class LargestRectangleHistogram {
	public int largestRectangleArea(int[] height) {
    	if (height == null || height.length == 0) return 0;
    	
    	int[] h = Arrays.copyOf(height, height.length + 1);
    	h[h.length - 1] = 0;
    	Stack<Integer> stk = new Stack<Integer>();
    	stk.push(0);
    	int max = 0;
    	for (int i = 1; i < h.length; i++) {
    		if (h[i] >= h[stk.peek()]) {
    		    stk.push(i);
    		    continue;
    		}
    		int j = 0;
    		while (!stk.isEmpty()) {
    			if (h[stk.peek()] < h[i])
    				break;
    			j = stk.pop();
    			int s = (i - j) * h[j];
    			if (s > max)
    				max = s;
    		}
    		h[j] = h[i];
    		stk.push(j);
    	}
    	return max;
    }
}