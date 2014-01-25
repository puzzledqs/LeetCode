public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    	int max = 0;
    	int[] hist = new int[matrix[0].length];
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < hist.length; j++) {
    			if (matrix[i][j] == '1')
    				hist[j]++;
    			else
    				hist[j] = 0;
    		}
    		int area = maxRegion(hist);
    		if (area > max)
    			max = area;
    	}
    	return max;
    }
    
    int maxRegion(int[] height) {
    	int[] h = Arrays.copyOf(height, height.length + 1);
    	h[h.length - 1] = 0;
    	Stack<Integer> stk = new Stack<Integer>();
    	stk.push(0);
    	int max = 0;
    	for (int i = 1; i < h.length; i++) {
    		if (h[i] > h[stk.peek()]) {
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