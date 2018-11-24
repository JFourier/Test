import java.util.Arrays;
import java.util.Scanner;
import java.math.BigDecimal;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/9/9
 */
public class Mid {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        float[] input = new float[n];
        for(int i=0;i<n;i++){
                input[i]=in.nextFloat();//给数组赋值
            }
        Arrays.sort(input);
        int l = input.length;
        if (input.length%2==1){
            System.out.println(input[(input.length-1)/2]);
        }else{
            float o =  ((input[(input.length-1)/2])+(input[(input.length)/2])) /2;
            double f1 = new BigDecimal(o).setScale(100, BigDecimal.ROUND_HALF_UP).doubleValue();
            String s = String.valueOf(f1);
            if(s.indexOf(".") > 0){
                s = s.replaceAll("0+?$", "");//去掉后面无用的零
                s = s.replaceAll("[.]$", "");//如小数点后面全是零则去掉小数点
            }
            System.out.println(s);
        }
    }
}