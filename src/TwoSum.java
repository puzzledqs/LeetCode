public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				int pos = map.get(target - numbers[i]);
				if (pos != i) {
					result[0] = i + 1;
					result[1] = pos + 1;
					break;
				}
			}
		}
		return result;
	}
}