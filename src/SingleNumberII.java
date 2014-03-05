public class Solution {
    public int singleNumber(int[] A) {
        int[] bitV = new int[32];
    
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < 32; j++) {
                if (((1 << j) & A[i]) != 0)
                    bitV[j]++;
            }
        }
        int single = 0;
        for (int j = 0; j < 32; j++) {
            if (bitV[j] % 3 != 0)
                single |= (1 << j);
        }
        return single;
    }
}
