package copytest;

import java.io.*;

/**
 * @author He.H
 * @date 2019/3/25 21:04
 **/


public class Outer implements Serializable {
    private static final long serialVersionUID = 369285298572941L;  //最好是显式声明ID
    public Inner inner = new Inner("djfh");


    //Discription:[深度复制方法,需要对象及对象所有的对象属性都实现序列化]　
    public Outer myclone() {
        Outer outer = null;
        try { // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            // 将流序列化成对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            outer = (Outer) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return outer;
    }
}
class TestS{
    public static void main(String[] args){
        Outer o1 = new Outer();
        Outer o2 = o1.myclone();
        System.out.println(o1.inner.toString());
//        System.out.println(o2.inner.toString());

        System.out.println("是否是一个对象?" + (o1 == o2));


    }
}
