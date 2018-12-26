/**
 * 解方程
 *
 * @author He.H
 * @date 2018/12/26 14:04
 **/


public class Leetcode640 {
    public static String solveEquation(String equation) {
        String[] leftAndRight=equation.split("=");
        int[] left=solve(leftAndRight[0]);
        int[] right=solve(leftAndRight[1]);
        int x_xishu=left[0]-right[0];
        int changshu=right[1]-left[1];
        if(x_xishu==0&&changshu!=0){
            return "No solution";
        }
        if(x_xishu==0&&changshu==0){
            return "Infinite solutions";
        }
        int num=changshu/x_xishu;
        return "x="+num;
    }
    public static int[] solve(String s){
        String[] tokens = s.split("(?=[-+])");
        int[] res =  new int[2];
        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x"))
                res[0] += 1;
            else if (token.equals("-x"))
                res[0] -= 1;
            else if (token.contains("x"))
                res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            else
                res[1] += Integer.parseInt(token);
        }
        return res;
    }
    public static void main(String[] args){
        String qu = "x+3=9";
        String res = solveEquation(qu);
        System.out.println(res);
    }
}
