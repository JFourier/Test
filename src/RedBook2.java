import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 〈幼儿园分班问题，前两个数字为人数和要求数量，后面是不想在一起的成对的学生，问能否完美分为两个班〉
 *
 * @author He.H
 * @create 2018/9/15
 */
public class RedBook2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int [][] inputArray = new int[t][2];
        for(int i=0;i<t;i++){
            for(int j=0;j<2;j++){
                inputArray[i][j]=scanner.nextInt();//给数组赋值
            }
        }
        HashMap<Integer, ArrayList<Integer>> imap = new HashMap<>();

        for(int i=0;i<t;i++){
            for(int j=0;j<2;j++){
                if (imap.containsKey(inputArray[i][0])) {
                    imap.get(inputArray[i][0]).add(inputArray[i][1]);
                }else {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(inputArray[i][1]);
                    imap.put(inputArray[i][0],tmp);
                    tmp.clear();
                }
            }
        }
        boolean flag = true;
        outterLoop: for(int i=0;i<t;i++){
            int ta = inputArray[i][0];
            int tb = inputArray[i][1];
            for (Integer key : imap.keySet()) {
                if (imap.get(key).contains(ta)&&imap.get(key).contains(tb)){
                    System.out.println(0);
                    flag = false;
                    break outterLoop;
                }
            }
        }
        if (flag ==true)
            System.out.println(1);
    }
}