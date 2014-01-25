public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length < 3) return 0;
		
		int closest = num[0] + num[1] + num[2];
		Arrays.sort(num);
		int i = 0;
		while (i < num.length - 2) {
			int t = target - num[i];
			int left = i + 1;
			int right= num.length - 1;
			while (left < right) {
				int sum = num[left] + num[right];
				if (sum == t)
					return target;
				if (sum < t) {
					if (t - sum < Math.abs(target - closest)) {
						closest = sum + num[i];
					}
					left++;
				}
				else {
					if (sum - t < Math.abs(target - closest)) {
						closest = sum + num[i];
					}
					right--;
				}
			}
			i++;
		}
		return closest;
	}
}