/**
 * @author He.H
 * @date 2019/1/8 17:04
 **/


public class Leetcode657 {
    public static boolean judgeCircle(String moves) {
        char[] s = moves.toCharArray();
        int U=0, D=0, L=0, R=0;
        for (char x: s) {
            switch (x){
                case 'R': R++; break;
                case 'D': D++; break;
                case 'U': U++; break;
                case 'L': L++; break;
            }
        }
        return (R==L)&&(U==D);
    }
    public static void main(String[] args){
        String a = "UD";
        System.out.println(judgeCircle(a));
    }
}
