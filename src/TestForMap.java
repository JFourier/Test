import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/9/15
 */
public class TestForMap {
    public static void main(String[] args){
//        int sum = 0;
//        for (int i = 0; i<=10 ; i++){
//            sum += i;
//        }
//        System.out.println(sum);
        HashMap<Integer, Integer> imap = new HashMap<>();
        imap.put(1,2);
        imap.put(2,3);
        int a = imap.get(1);
        int b = imap.getOrDefault(3,9);
    }
}