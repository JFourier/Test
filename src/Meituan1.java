import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/22 16:05
 **/


public class Meituan1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < line.length(); i++) {
                map.put(line.charAt(i), i);
            }
            int index = 0;
            int count = 0;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                count = Math.max(count, map.get(c));
                if (i == count) {
                    if (count == line.length() - 1) {
                        System.out.println(count + 1 - index);
                        break;
                    } else {
                        System.out.println(count + 1 - index + "");
                        index = count + 1;
                    }
                }
            }
        }
}
