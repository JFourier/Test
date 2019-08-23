import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/1/2 14:34
 **/


public class TestDemo {
    static Scanner input;
    public static void main(String[] args) {
        input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            solve(res);
        }

        for(int i: res){
            System.out.println(i);
        }
    }

    public static void solve(ArrayList<Integer> res) {
        int a = input.nextInt();
        res.add(a);
        res.add(input.nextInt());
    }
}
