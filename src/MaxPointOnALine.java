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
 		int max_num = 0;
 		for (int i = 0; i < points.length; i++) {
 			Point pt0  = points[i];
 			HashMap<Float, Integer> map = new HashMap<Float, Integer>();
 			int cnt_overlap = 1;
 			float slope;
 			int current_max = 0;
 			for (int j = i + 1; j < points.length; j++) {
 				Point pt = points[j];
 				if (pt.x == pt0.x) {
 					if (pt.y == pt0.y) {
 						cnt_overlap++;
 						continue;
 					}
 					else slope = Float.MAX_VALUE;
 				}
 				else if (pt.y == pt0.y) slope = 0.f;
 				else slope = (float)(pt.y - pt0.y) / (float)(pt.x - pt0.x);
 				
 				Integer val = map.get(slope);
 				val = val == null ? 1 : val + 1;
 				map.put(slope, val);
 				if (val > current_max) current_max = val;
 			}
 			current_max += cnt_overlap;
 			if (current_max > max_num) max_num = current_max;
 		}
 		
 		return max_num;
 	}
}