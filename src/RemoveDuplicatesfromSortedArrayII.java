public class RemoveDuplicatesfromSortedArrayII {
    public static int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        
        int j = 0;
        boolean flag = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[j]) {
                j++;
            	A[j] = A[i];
                flag = false;
            }
            else {
                if (!flag) {
                	j++;
                    A[j] = A[i];
                    flag = true;
                }
            }
        }
        return j + 1;
    }
}
