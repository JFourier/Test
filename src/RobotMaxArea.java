/**
 * @author He.H
 * @date 2019/3/5 14:17
 **/


public class RobotMaxArea {
    /*
    * 机器人从原点开始移动，不能到大行数与列数各数字之和超过阈值的
    * */
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return countingSteps(threshold,rows,cols,0,0,visited);
    }
    public int countingSteps(int limit,int rows,int cols,int r,int c,boolean[][] visited){
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || bitSum(r) + bitSum(c) > limit)
            return 0;
        visited[r][c] = true;
        return countingSteps(limit,rows,cols,r - 1,c,visited)
                + countingSteps(limit,rows,cols,r,c - 1,visited)
                + countingSteps(limit,rows,cols,r + 1,c,visited)
                + countingSteps(limit,rows,cols,r,c + 1,visited)
                + 1;
    }
    public int bitSum(int t){
        int count = 0;
        while (t != 0){
            count += t % 10;
            t /= 10;
        }
        return  count;
    }
}
