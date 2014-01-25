public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return intervals;
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval v1, Interval v2) {
				return v1.start - v2.start;
			}
		});
		
		Interval prev = intervals.get(0);
		for (Interval v : intervals) {
			if (prev.end < v.start) {
				result.add(prev);
				prev = v;
			}
			else {
				prev.end = prev.end > v.end ? prev.end : v.end;
			}
		}
		result.add(prev);
		return result;
    }
}