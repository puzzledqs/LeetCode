public class GasSation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int[] net = new int[gas.length];
		int accum = 0;
		for (int i = 0; i < net.length; i++) {
			net[i] = gas[i] - cost[i];
			accum += net[i];
		}
		if (accum < 0)
			return -1;
		
		int start = 0;
		while (true) {
			int step = 0;
			accum = 0;
			while (step < net.length) {
				if (start + step < net.length)
					accum += net[start + step];
				else
					accum += net[start + step - net.length];
				step++;
				if (accum < 0)
					break;
			}
			if (accum >= 0)
				return start;
			
			start = start + step;
		}
	}
}