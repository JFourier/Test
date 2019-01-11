package polymorphism;

/**
 * @author He.H
 * @date 2019/1/11 16:40
 **/


public class Dog extends Animal {
    @Override
    public void run() {
        System.out.println("dog run");
    }

    @Override
    public void eat() {
        System.out.println("dog eat");
    }
    public void hale(){
        System.out.println("wu~~~~~~");
    }
}

