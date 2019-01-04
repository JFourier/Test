//import static java.lang.System.*;

/**
 *
 *
 * @author He.H
 * @date 2018/9/4
 */

class Animal{
    void go(){
        System.out.println("animal go");
    }
    void eat(){
        System.out.println("animal eat");
    }
}

class Dog extends Animal{
    void go(){
        //调用父类方法
        super.go();
    }
    @Override
    void eat (){
        System.out.println("dog eat");
    }
    void run(){
        System.out.println("123");
    }
}

    //驱动函数
public class lala {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.go();
        dog.eat();
        ((Dog) dog).run();
        ((Dog) dog).run();
    }
}