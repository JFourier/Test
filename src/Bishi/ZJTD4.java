package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/11 17:09
 **/


public class ZJTD4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int[][] array = new int[rows][rows];
        for(int i = 0; i< rows -1; i++) {
            int temp1 = scanner.nextInt();
            int temp2 = scanner.nextInt();
            array[temp1-1][temp2-1] = array[temp2-1][temp1-1] = 1;
            array[i][i] = -1;
        }
        array[rows -1][rows -1] = -1;

        while(true) {
            for(int row = 0 ; row < rows ;row ++) {
                for(int col = 0; col < rows;col++) {
                    if(array[row][col] != -1 && array[row][col] != 0) {
                        for(int j  = 0 ; j < rows; j++) {
                            if(array[col][j] != -1 && array[col][j] != 0 && array[row][j] == 0) {
                                array[j][row] = array[row][j] = array[col][j] + array[row][col];
                            }
                        }
                    }
                }
            }
            if(stop(array)) {
                break;
            }
        }

        int zero = 0;
        int one = 0;
        int two = 0;

        for(int i = 0; i< array.length; i++) {
            for(int j = i + 1; j < array.length;j++) {
                if(array[i][j] % 3 == 0) {
                    zero += array[i][j];
                }
                else if(array[i][j] % 3 == 1) {
                    one+= array[i][j];
                }else if(array[i][j] % 3 == 2) {
                    two+= array[i][j];
                }
            }
        }

        System.out.println(zero+" "+one +" "+two+" ");
    }

    public static boolean stop(int[][] array) {
        boolean result = true;
        for(int i = 0; i< array.length; i++) {
            for(int j = 0; j < array.length;j++) {
                if(array[i][j] == 0) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}

