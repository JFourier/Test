import static java.lang.System.*;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/9/4
 */

class Animal{
    void go(){
        out.println("animal go");
    }
    void eat(){
        out.println("animal eat");
    }
}

class Dog extends Animal{
    void go(){
        //调用父类方法
        super.go();
    }
    @Override
    void eat (){
        out.println("dog eat");
    }
    void run(){
        out.println("123");
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