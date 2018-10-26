import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/9/15
 */
public class Souhu2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        ArrayList res = sum(n,9);
        Collections.sort(res);
        String s = String.valueOf(res.get(k-1));
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉后面无用的零
            s = s.replaceAll("[.]$", "");//如小数点后面全是零则去掉小数点
        }
        System.out.println(s);
    }

    public static ArrayList<Double> sum(int n,int i) {
        ArrayList<Double> aa = new ArrayList<>();
        if (i == 0) {
            aa.add((double) 1);
        } else {
            aa.add(Math.pow(n, i));
            aa.addAll(sum(n, i - 1));
            for (Double x : sum(n, i - 1)) {
                aa.add(x + Math.pow(n, i));
            }
        }
        return aa;
    }
}
