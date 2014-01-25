public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if (A == null || A.length == 0) return 0;
		
		int max = A[0];
		int accum = 0;
		for (int i = 0; i < A.length; i++) {
			if (accum < 0)
				accum = A[i];
			else
				accum = accum + A[i];
			
			if (accum > max)
				max = accum;
		}
		return max;
	}
}