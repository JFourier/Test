package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author He.H
 * @date 2019/5/13 20:53
 **/


public class Leetcode149 {
    public static void main(String[] args) {
        int[][] in = {{1, 1}, {1, 2}, {2, 3}, {2, 2}, {3, 3}};
        Solve149 solve1 = new Solve149();
        int res = solve1.maxPoints(in);
        System.out.println(res);
    }
}


class Solve149 {
    public int maxPoints(int[][] points) {
        if(points.length <= 2)
            return points.length;
        int result = 0;
        int n = points.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.clear(); // clear the map to avoid counting points in different parallel lines
            int samePoints = 1;
            for(int j = i+1; j < n; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                if( dx == 0 && dy == 0) {  // check for the duplicate points
                    samePoints ++;
                    continue;
                }

                // find the greatest common divisor of dx and dy
                int gcd = GCD(dx, dy);
                String slope = (dx / gcd) + "#" + (dy / gcd);

                if(! map.containsKey(slope))
                    map.put(slope, 1);
                else
                    map.put(slope, map.get(slope) + 1);

            }

            if(map.isEmpty()) {
                if(samePoints > result)
                    result = samePoints;
            }else {
                for(int num : map.values()) {
                    if(num + samePoints > result)
                        result = num + samePoints;
                }
            }
        }
        return result;
    }

    private int GCD(int a, int b) {
        return ( b == 0) ? a : GCD(b, a % b);
    }
}
