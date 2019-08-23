/**
 * @author He.H
 * @date 2019/8/18 15:55
 **/


public class Q44 {
    public static void main(String[] args) {
        String numStr = "";
        for(int i=0;i<120;i++) {
            String temp = i + "";
            numStr = numStr + temp;
        }

        for(int i=0;i<200;i++) {
            System.out.printf("i:%d  %c——%d\n",i,numStr.charAt(i),findDigits(i));
        }
    }


    // 是指向第几位的数字
    public static int findDigits(int x) {
        if(x<10) {
            return x;
        }else {
            x = x-10;
        }

        int digit = 2;
        int loc = 10;
        while(x>9*digit*loc) {
            x = x-9*digit*loc;
            digit ++;
            loc *=loc;
        }

        // 定位第n位是对应的这个x位数的哪个数字
        int current = loc + x/digit;
        //System.out.printf("digit:%d,loc:%d,x:%d,current:%d\n", digit,loc,x,current);
        String re = current+"";

        //定位是这个数字的第几个位置的数字
        return re.charAt(x%digit)-48;
    }
}
