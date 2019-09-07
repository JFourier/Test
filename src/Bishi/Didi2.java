package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/27 19:24
 **/


public class Didi2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            char[] str = new char[n - 1];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
                if (i < n - 1) {
                    str[i] = in.next().charAt(0);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    // 比较交换
                    if (nums[j] > nums[j + 1] ) {
                        if (str[j] == '+') {
                            if (j == n - 2) {
                                if ((str[j - 1] == '+' || str[j - 1] == '-')) {
                                    int tmp = nums[j];
                                    nums[j] = nums[j + 1];
                                    nums[j + 1] = tmp;
                                }
                            } else if (j > 0) {
                                if ((str[j + 1] == '+' || str[j + 1] == '-') && (str[j - 1] == '+' || str[j - 1] == '-')) {
                                    int tmp = nums[j];
                                    nums[j] = nums[j + 1];
                                    nums[j + 1] = tmp;
                                }
                            } else if (str[j + 1] == '+' || str[j + 1] == '-') {
                                int tmp = nums[j];
                                nums[j] = nums[j + 1];
                                nums[j + 1] = tmp;
                            }
                        }

                        if (str[j] == '-') {
                            if (j > 0) {
                                if (str[j - 1] == '-') {
                                    int tmp = nums[j];
                                    nums[j] = nums[j + 1];
                                    nums[j + 1] = tmp;
                                }
                            }
                        }
                        if (str[j] == '/') {
                            if (j > 0) {
                                if (str[j - 1] == '/') {
                                    int tmp = nums[j];
                                    nums[j] = nums[j + 1];
                                    nums[j + 1] = tmp;
                                }
                            }
                        }
                        if (str[j] == '*') {
                            if (j > 0) {
                                if (str[j - 1] != '/') {
                                    int tmp = nums[j];
                                    nums[j] = nums[j + 1];
                                    nums[j + 1] = tmp;
                                }
                            } else {
                                int tmp = nums[j];
                                nums[j] = nums[j + 1];
                                nums[j + 1] = tmp;
                            }
                        }


                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (i != n - 1) {
                    System.out.print(nums[i]);
                    System.out.print(' ');
                    System.out.print(str[i]);
                    System.out.print(' ');
                } else {
                    System.out.println(nums[i]);
                }
            }
        }

    }

}