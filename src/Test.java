import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.*;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/9/4
 */
public class Test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int [][] inputArray = new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                inputArray[i][j]=scanner.nextInt();//给数组赋值
                }
        }
        List<Integer> outNum = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
                if (inputArray[i][1]<t && inputArray[i][2]>t){
                    outNum.add(inputArray[i][0]);
                }
        }
        Collections.<Integer>sort(outNum);
        for (int i : outNum){
            System.out.println(i);
        }
    }
}


