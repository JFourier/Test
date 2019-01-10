package polymorphism;

/**
 * 〈〉
 *
 * @author He.H
 * @Time 2018/9/4
 */
public class A {
    public String show(D obj){
        return ("A and D");
    }

    public String show(A obj){
        return ("A and A");
    }
}
