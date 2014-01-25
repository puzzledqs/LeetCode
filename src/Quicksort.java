import java.util.*;
public class Quicksort {
	public static void qsort(int[] a, int low, int high) {
		if (low >= high) return;
		int val = a[low];
		int left = low;
		int right = high;
		
		while (left < right) {
			while (a[right] >= val && left < right)
				right--;
			a[left] = a[right];
			while (a[left] <= val && left < right)
				left++;
			a[right] = a[left];
			if (left == right)
				a[left] = val;
		}
		qsort(a, low, left-1);
		qsort(a, left+1, high);
	}
	
	public static void main(String args[]) {
		int[] a = {1, 2, 5, 3, 9, 10, 7, 4};
		qsort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
}