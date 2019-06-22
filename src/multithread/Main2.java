package multithread;

/**
 * @author He.H
 * @date 2019/2/25 16:53
 **/


class Thread2 implements Runnable{
    private String name;

    public Thread2(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
public class Main2 {

    public static void main(String[] args) {
        new Thread(new Thread2("C")).start();//把实现了Runnable接口的子类对象作为参数传递给Thread类的构造方法
        new Thread(new Thread2("D")).start();
    }
}
