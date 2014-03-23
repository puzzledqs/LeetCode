public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int l = m + n;
        m--; n--; l--;
        while (n >= 0) {
            if (m >= 0 && A[m] > B[n])
                A[l--] = A[m--];
            else
                A[l--] = B[n--];
        }
    }
}
