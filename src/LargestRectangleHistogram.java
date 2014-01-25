import java.util.*;
public class LargestRectangleHistogram {
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) return 0;
		int sum = 0;
		Stack<Integer> stk = new Stack<Integer>();
		
		for (int i = 0; i <= height.length; i++) {
			int h = 0;
			if (i < height.length)
				h = height[i];
			
			if (stk.isEmpty() || height[stk.peek()] < h)
				stk.push(i);
			else {
				int idx = stk.pop();
				int area = height[idx] * (stk.isEmpty() ? i : i - 1 - stk.peek());
				sum = area > sum ? area : sum;
				i--;
			}
		}
		
		return sum;
	}
}