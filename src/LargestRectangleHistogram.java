import java.util.*;
public class LargestRectangleHistogram {
	
    public int largestRectangleArea(int[] height) {
    	int max = 0;
    	Stack<Integer> stk = new Stack<Integer>();
    	for (int i = 0; i <= height.length; i++) {
    	    int h = 0;
    	    if (i < height.length)
    	        h = height[i];
    	    while (!stk.isEmpty() && height[stk.peek()] >= h) {
    	        int a = height[stk.pop()];
    	        int b = i;
    	        if (!stk.isEmpty())
    	            b = b - stk.peek() - 1;
    	        max = Math.max(max, a * b);
    	    }
    	    stk.push(i);
    	}
    	return max;
    }
    
    public int largestRectangleArea2(int[] height) {
        int max = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            int l = i;
            while (l > 0 && height[l - 1] >= height[i])
                l = left[l - 1];
            left[i] = l;
        }
        for (int i = height.length - 1; i >= 0; i--) {
            int r = i;
            while (r < height.length - 1 && height[r + 1] >= height[i])
                r = right[r + 1];
            right[i] = r;
            max = Math.max(max, height[i] * (r - left[i] + 1));
        }
        return max;
    }
}
