package lambda;

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * @author He.H
 * @date 2019/1/11 16:23
 **/


public class LambdaTest {
    public static void main(String[] args){
        String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println("sorted by length");
        Arrays.sort(planets, (f, s)-> f.length()-s.length());
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000, event ->
                System.out.println(" time is" + new Date()));
        t.start();

        JOptionPane.showMessageDialog(null, "QUIT？");

        System.exit(0);
    }
}
