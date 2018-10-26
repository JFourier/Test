import java.util.Scanner;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/10/9
 */
public class Region {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Long l = scanner.nextLong();
        Long r = scanner.nextLong();
        if (l>r){
            System.out.println(0);
        }else if (l==r){
            String tmp = l+"";
            char[] tmpArray = tmp.toCharArray();
            if (tmpArray[0]==tmpArray[tmpArray.length-1])
                System.out.println(1);
        }
        int res = 0;
        for (Long i = l; i<=r;i++){
            if (i<10){
                res++;
            }else{
                int count = 0;
                Long t = i;
                while (t > 0) {
                    t = t / 10;
                    count++;
                }
                if (i/Math.pow(10,count)==i%Math.pow(10,count)){
                    res++;
                }
            }
            }
        System.out.println(res);
    }
}