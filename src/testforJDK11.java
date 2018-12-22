import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/11/14
 */
public class testforJDK11 {
    public static void main(String[] args){
        for(int i = 0; i<10; i++){
            if(i == 5)
                continue;
            System.out.println(i);
        }
    }
}