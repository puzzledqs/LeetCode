public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
        int l = m + n;
        l--; m--; n--;
        while (n >= 0) {
            int tmp = B[n];
            if (m >= 0 && A[m] > B[n]) {
                A[l] = A[m];
                m--;
            }
            else {
                A[l] = B[n];
                n--;
            }
            l--;
        }
    }
}