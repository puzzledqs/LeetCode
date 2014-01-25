public class JumpGameII {
	public int jump(int[] A) {
		if (A == null || A.length <= 1) return 0;
		
		int pos = 0;
		int range = A[0];
		int newrange = range;
		int step = 1;
		while (range < A.length - 1) {
            while (pos <= range) {
                if (pos + A[pos] > newrange)
                    newrange = pos + A[pos];
                pos++;
            }
            if (newrange == range)
                break;
            range = newrange;
            step++;
		}
		if (range < A.length - 1)
		    return  -1;
		return step;
	}
}