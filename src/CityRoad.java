import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/9/9
 */
public class CityRoad {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        HashMap<Integer,char[]> imap = new HashMap<>();
        for (int t = 0; t<n; t++){
            String input0 = in.nextLine();
            char[] input1 = input0.toCharArray();
            imap.put(t,input1);
        }

    }
}