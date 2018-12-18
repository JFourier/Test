package polymorphism;

/**
 * @author He.H
 * @date 2018/12/18 10:07
 **/


public class B extends A{
    public String show(B obj){
        return ("B and B");
    }

    public String show(A obj){
        return ("B and A");
    }
}
