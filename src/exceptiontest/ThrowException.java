package exceptiontest;

/**
 * @author He.H
 * @date 2019/1/17 9:58
 **/


public class ThrowException {
    private static void divide(int one, int two) throws Exception {
        if (two == 0) {
            throw new Exception("除数不能为0");
        } else {
            System.out.println("Result:"+one/two);
        }
    }
    public static void main(String[] args){
        try {
            divide(2,1);
            divide(5,0);
            divide(5,2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println();
        }
    }
}
