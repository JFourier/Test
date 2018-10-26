import java.util.Scanner;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/10/15
 */
public class Beike {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] inputArray = new int[n][6];
        for(int i=0;i<n;i++){
            for(int j=0;j<6;j++){
                inputArray[i][j]=scanner.nextInt();//给数组赋值
            }
        }
        for(int i=0;i<n;i++){
            int X = inputArray[i][0];
            int A = inputArray[i][1];
            int C = inputArray[i][2];
            int Y = inputArray[i][3];
            int B = inputArray[i][4];
            int D = inputArray[i][5];
            if ((X/B)*D > (Y/A)*C){
                System.out.println("XIAOZHI");
            }else if ((X/B)*D < (Y/A)*C){
                System.out.println("XIAOCHUN");
            }else if ((X/B)*D == (Y/A)*C){
                System.out.println("TIE");
            }
        }
    }
}