public class JumpGame {
	public boolean canJump(int[] A) {
		int reach = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > reach) 
				return false;
			int tmp = i + A[i];
			reach = tmp > reach ? tmp : reach;
			if (reach >= A.length - 1) 
				return true;
		}
		return true;
	}
}