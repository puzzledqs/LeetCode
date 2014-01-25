public class SingleNumberII {
	public int singleNumber(int[] A) {
		int[] bitvector = new int[32];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < 32; j++) {
				if ((1 & A[i] >> j) == 1 )
					bitvector[j] = (bitvector[j] + 1) % 3;
			}	
		}
		int single = 0;
		for (int j = 0; j < 32; j++)
			single |= bitvector[j] << j;
		
		return single;
	}
}