import java.util.Scanner;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/9/6
 */
public class dynamic {
    public static void main(String[] args){
        int total_time = 120;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] inputArray = new int[n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                inputArray[i][j]=scanner.nextInt();//给数组赋值
            }
        }
        int[] score = new int[n+1];
        for (int i=0;i<score.length;i++){
            score[i]=0;
        }
        for (int i=0;i<n;i++){
            for (int j=score.length-1;j>=inputArray[i][0]&j>=inputArray[i][2];j--){
                score[j]=Math.max(score[j],score[j-inputArray[i][0]]+inputArray[i][1]);
                score[j]=Math.max(score[j],score[j-inputArray[i][2]]+inputArray[i][3]);
            }
        }
    System.out.println(score[score.length-1]);

    }

}