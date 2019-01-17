package exceptiontest;

/**
 * @author He.H
 * @date 2018/12/18 14:39
 **/


public class ExceptionTest {
    public void method()
    {
        try
        {
            System.out.println("进入到try块");
        }
        catch (Exception e)
        {
            System.out.println("异常发生了！");
        }
        finally
        {
            System.out.println("进入到finally块");
        }
        System.out.println("后续代码");
    }
    public static void main(String[] args)
    {
        ExceptionTest test = new ExceptionTest();
        test.method();
    }
}
