public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] A, int[] B) {
		int total = A.length + B.length;
		if (total % 2 == 1)
			return findKth(A, 0, A.length, B, 0, B.length, total/2 + 1);
		else
			return (findKth(A, 0, A.length, B, 0, B.length, total/2)
					+ findKth(A, 0, A.length, B, 0, B.length, total/2 + 1)) / 2;
	}
	
	double findKth(int[] A, int sta, int eda, int[] B, int stb, int edb, int k) {
		int lena = eda - sta;
		int lenb = edb - stb;
		if (lena > lenb)
			return findKth(B, stb, edb, A, sta, eda, k);
		if (lena == 0) // no elements in A
			return B[stb + k-1];
		if (k == 1)
			return A[sta] < B[stb] ? A[sta] : B[stb];
		int pa = k/2 < lena ? k/2 : lena;
		int pb = k - pa;
		if (A[sta + pa - 1] < B[stb + pb - 1]) // eliminate lower part of A and upper part of B
			return findKth(A, sta + pa, eda, B, stb, stb + pb, k - pa );
		if (A[sta + pa - 1] > B[stb + pb - 1]) // eliminate lower part of B and upper part of A
			return findKth(A, sta, sta + pa, B, stb + pb, edb, k - pb);
		else
			return B[stb + pb - 1];
	}
}