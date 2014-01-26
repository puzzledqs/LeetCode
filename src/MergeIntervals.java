public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0)
            return result;
            
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval v1, Interval v2) {
                return v1.start - v2.start;
            }
        };
        
        Collections.sort(intervals, comp);
        
        Interval v0 = intervals.get(0);
        for (Interval v : intervals) {
            if (v.start > v0.end) {
                result.add(v0);
                v0 = v;
                continue;
            }
            if (v.end > v0.end)
                v0.end = v.end;
        }
        result.add(v0);
        return result;
    }
}