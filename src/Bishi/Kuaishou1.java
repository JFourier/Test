package Bishi;

/**
 * @author He.H
 * @date 2019/8/25 16:26
 **/

import java.util.Scanner;

public class Kuaishou1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String[][] str = new String[n][2];
        for (int i = 0; i < n; i++) {
            str[i][0]=sc.next();
            str[i][1]=sc.next();
        }

        for (int i = 0; i < n; i++) {
            boolean result=solve(str[i][0],str[i][1]);
            System.out.println(result);
        }
    }

    public static boolean solve(String str1,String str2){
        boolean flag = true;
        String[] str1s = str1.split("\\.");
        String[] str2s = str2.split("\\.");

        int[] iCur = new int[str1s.length];
        int[] iSper = new int[str2s.length];

        for(int i = 0;i < str1s.length;i++){
            iCur[i] = Integer.parseInt(str1s[i]);
        }
        for(int i = 0;i < str2s.length;i++){
            iSper[i] = Integer.parseInt(str2s[i]);
        }

        int iFlag = 0;
        if(str1s.length < str2s.length){
            iFlag = validata(iSper, iCur);
            if(iFlag > 0){
                flag = true;
            }else{
                flag = false;
            }
        }else{
            iFlag = validata(iCur, iSper);
            if(iFlag >= 0){
                flag = false;
            }else{
                flag = true;
            }
        }
        return flag;
    }

    public static int validata(int[] bigOne,int[] smallOne){
        int flag = 0;
        int temp = 0;
        for(int i = 0;i < bigOne.length;i++){
            if(i > smallOne.length-1){
                temp = 0;
            }else{
                temp = smallOne[i];
            }
            if(temp < bigOne[i]){
                flag = 1;
                return flag;
            }else if(temp > bigOne[i]){
                flag = -1;
                return flag;
            }else{
                if(i == bigOne.length-1){
                    flag = 0;
                }else{
                    continue;
                }
            }
        }
        return flag;
    }
}
