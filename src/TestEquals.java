
/**
 * describe difference equles and ==
 *
 * @author He.H
 * @date 2018/12/17 16:34
 **/

/****************
 * == 比较两个变量的地址是否相同，若比较对象为基本变量，则比较值
 * 基本数据类型（也称原始数据类型） ：byte,short,char,int,long,float,double,boolean。他们之间的比较，应用双等号（==）,比较的是他们的值。
 * 引用数据类型：当他们用（==）进行比较的时候，比较的是他们在内存中的存放地址（确切的说，是堆内存地址）
 *
 *
 * equals 方法比较两个变量的引用，即是否为同一引用，可根据需要重写
 * 引用类型：默认情况下，比较的是地址值。
 * 注：不过，我们可以根据情况自己重写该方法。一般重写都是自动生成，比较对象的成员变量值是否相同
 * ****************/
public class TestEquals {
    public static void main(String[] args){
        int n=3;
        int m=3;
        //8种基本类型变量直接存储的值
        System.out.println(n==m);

        String str = new String("hello");
        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println(str1==str2);
        // == 比较的是地址

        System.out.println(str1.equals(str2));
        //String 重写了equals方法，比较值的相等性

        str1 = str;
        str2 = str;
        //此时指向同一对象，即地址相同
        System.out.println(str1==str2);
    }
}
