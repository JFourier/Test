/**
 * @author He.H
 * @date 2019/7/17 19:45
 **/


public class MySqrt {

    private static final double PROCISION =0.0000000001;

    public static void main(String[] args) {
        //二分查找,已知 ：sqrt(2)约等于1.414，要求不使用Math库，精确到小数点后10位
        System.out.println(Math.sqrt(2));
        double value=sqrt(1.414,2);
        System.out.println(value);
    }
    /*
     * 截取小数点任意位数的小数，可以求1.41和1.42之间的近似值
     */
    private static double sqrt(double d,int a) {
        String str  =Double.toString(d);
        int index =str.indexOf(".");
        int length =str.length();
        if(index!=0 && (length-(index+1))>0 && (length-(index+1))>a){
            str=str.substring(0, index+a+1);
            double low= Double.parseDouble(str);
            double high =low+Math.pow(0.1,a);
            double middle =(low +high)/2;
            /*
             * 二分查找
             */
            while(high-low>PROCISION){
                if(middle *middle >2)
                    high=middle;
                else
                    low =middle;
                middle=(low+high)/2;
            }
            return middle;
        }else{
            System.out.println("不符合截取条件");
            return 0;
        }
    }


    public float sqrt_search(float n){
        float mid = 0.0f;
        if(n < -1e-6){
            // 小于0，抛异常
            throw new IllegalArgumentException();
        }else if(Math.abs(n) >= -1e-6 && Math.abs(n) <= 1e-6){
            return mid;
        }else{
            // 逐次逼近，默认平方根的不会超过n的一半
            float high = n / 2.0f;
            float low = 0.0f;
            while(Math.abs(high - low) > 1e-6){
                // 首先找到中间值
                mid = low + (high - low) / 2;
                float tmp = mid * mid;
                // 比较并更新 high和low
                if((tmp - n) > 1e-6){
                    high = mid;
                }else if((tmp -n) < -1e-6){
                    low = mid;
                }else{
                    return mid;
                }
            }
        }
        return mid;
    }
}
