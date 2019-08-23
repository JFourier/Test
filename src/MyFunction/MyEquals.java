package MyFunction;

/**
 * @author He.H
 * @date 2019/8/19 13:36
 **/


public class MyEquals {
    //第一步，先判断引用值是否相等，此时person1.equals(person1)这样的情况，就可以很快返回结果true。
    //第二步，判断类型是否匹配，如果两个对象等价，前提是它们一定为相同的类型，
    //        此时person1.equals(null)这样的情况，也能进行判断并返回结果false。
    //第三步，按部就班地按照预设的特征值进行对象的等价性判断。
    /*
    * 重写equals方法的要求：
    1、自反性：对于任何非空引用x，x.equals(x)应该返回true。
    2、对称性：对于任何引用x和y，如果x.equals(y)返回true，那么y.equals(x)也应该返回true。
    3、传递性：对于任何引用x、y和z，如果x.equals(y)返回true，y.equals(z)返回true，那么x.equals(z)也应该返回true。
    4、一致性：如果x和y引用的对象没有发生变化，那么反复调用x.equals(y)应该返回同样的结果。
    5、非空性：对于任意非空引用x，x.equals(null)应该返回false。
    * */

}
