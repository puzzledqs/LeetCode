public class NextPermutation {
	public void nextPermutation(int[] num) {
		if (num == null || num.length == 0) return;
		
		boolean found = false;
		int pos1 = 0;
		int pos2 = 0;
		for (pos1 = num.length - 2; pos1 >= 0; pos1--) {
			for (pos2 = num.length - 1; pos2 > pos1; pos2--) {
				if (num[pos1] < num[pos2]) {
					found = true;
					break;
				}
			}
			if (found)
				break;
		}
		if (found) {
			int tmp = num[pos2];
			num[pos2] = num[pos1];
			num[pos1] = tmp;
		}
		int left = pos1 + 1;
		int right = num.length - 1;
		while (left < right) {
			int tmp = num[left];
			num[left] = num[right];
			num[right] = tmp;
			left++; right--;
		}
	}
}