/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;
public class IntertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			result.add(newInterval);
			return result;
		}
		if (newInterval == null) return intervals;
		
		for (Interval v : intervals) {
			if (v.end < newInterval.start) {
				result.add(v);
				continue;
			}
			if (v.start > newInterval.end) {
				result.add(newInterval);
				newInterval = v;
				continue;
			}
			newInterval.start = newInterval.start < v.start ? newInterval.start : v.start;
			newInterval.end = newInterval.end > v.end ? newInterval.end : v.end;
		}
		result.add(newInterval);
		
		return result;
	}
}