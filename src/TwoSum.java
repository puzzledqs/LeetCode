public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> num2idx = new HashMap<Integer, Integer>();
        	for (int i = 0; i < numbers.length; i++) {
            	int num = numbers[i];
            	int need = target - num;
            	if (num2idx.containsKey(need)) {
                	result[0] = num2idx.get(need) + 1;
                	result[1] = i + 1;
                	break;
            	}
            	num2idx.put(num, i);
        }
        return result;
    }
}
