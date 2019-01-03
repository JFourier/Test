/**
 * @author He.H
 * @date 2019/1/2 14:34
 **/


public class TestDemo{
    private int count;
    public static void main(String[] args) {
        TestDemo test=new TestDemo(88);
        System.out.println(test.count);
    }
    private TestDemo(int a) {
        count=a;
    }
}
