public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[j]) {
                j++;
                A[j] = A[i];
            }
        }
        return j + 1;
    }
}
