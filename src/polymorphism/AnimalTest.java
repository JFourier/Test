package polymorphism;

/**
 * @author He.H
 * @date 2019/1/11 16:42
 **/


public class AnimalTest {
    public static void main(String[] args){
        Animal a1 = new Animal();
        Animal a2 = new Cat();
        Animal a3 = new Dog();

        Dog d = new Dog();

        a1.eat();
        a2.eat();
        a3.eat();
        ((Dog) a3).hale();
        a3.eat();
        d.eat();
        d.hale();
    }
}
