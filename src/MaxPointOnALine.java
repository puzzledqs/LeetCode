/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
import java.util.*;

public class MaxPointOnALine {
	public int maxPoints(Point[] points) {
		int max_found = 0;
		if (points == null) return 0;
		for (int i = 0; i < points.length; i++) {
			int tmp_max = 0;
			int dup = 1;
			int cx = points[i].x;
			int cy = points[i].y;
			HashMap<Double, Integer> count = new HashMap<Double, Integer>();
			for (int j = i+1; j < points.length; j++) {
				if (points[j].x == cx && points[j].y == cy) {
					dup++;
					continue;
				}
				Double slope;
				if (points[j].x == cx)
					slope = Double.MAX_VALUE;
				else if (points[j].y == cy)
				    slope = 0.;
				else
					slope = (double)(points[j].y - cy) / (double)(points[j].x - cx);
				int tmp = 0;
				if (count.containsKey(slope))
					tmp = count.get(slope);
				tmp++;
				count.put(slope, tmp);
				if (tmp > tmp_max)
					tmp_max = tmp;
			}
			tmp_max += dup;
			if (tmp_max > max_found)
				max_found = tmp_max;
		}
		return max_found;
	}
}