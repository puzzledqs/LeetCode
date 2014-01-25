public class TrappingRainWater {
	public int trap(int[] A) {
		if (A == null || A.length == 0) return 0;
		int left = 0;
		int right = A.length - 1;
		int lmax = 0;
		int rmax = 0;
		int water = 0;
		while (left <= right) {
			if (lmax <= rmax) {
				int tmp = lmax - A[left];
				if (tmp > 0)
					water += tmp;
				else
					lmax = A[left];
				left++;
			}
			else {
				int tmp = rmax - A[right];
				if (tmp > 0)
					water += tmp;
				else
					rmax = A[right];
				right--;
			}
		}
		return water;
	}
}