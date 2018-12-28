import java.util.LinkedList;
import java.util.Queue;

/**
 * @author He.H
 * @date 2018/12/28 19:47
 **/


public class Leetcode649 {
    public String predictPartyVictory(String senate) {
        Queue<Integer> QR = new LinkedList<>();
        Queue<Integer> QD = new LinkedList<>();
        char[] a = senate.toCharArray();
        for (int i = 0; i < a.length; i++){
            if (a[i] == 'R') {
                QR.offer(i);
            } else {
                QD.offer(i);
            }
        }
        while (!QR.isEmpty()&&!QD.isEmpty()){
            int r = QR.poll();
            int d = QD.poll();
            if (r > d) {
                QD.offer(d+a.length);
            } else {
                QR.offer(r+a.length);
            }
        }
        return String.valueOf(QR.isEmpty()? "Dire": "Radiant");
    }
}
