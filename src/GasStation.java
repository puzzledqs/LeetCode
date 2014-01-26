public class GasSation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
    	if (gas == null || gas.length == 0) return 0;
    	
    	int start = 0;
    	int cnt = 0;
    	while (true) {
    		int tank = 0;
    		int pos = start;
    		while (tank >= 0) {
    			tank += gas[pos] - cost[pos];
    			cnt++;
    			pos++;
    			pos = pos % gas.length;
    			if (pos == start && tank >= 0)
    				return start;
    		}
    		start = pos;
    		if (cnt >= gas.length)
    			break;
    	}
    	return -1;
    }
}