package topK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author He.H
 * @date 2019/2/28 10:54
 **/


public class TopKQuick {
    /*
     * p[]为待查找数组，L,R分别为数组下标，k表示第k大数
     * */
    public static int findKth(int[] p,int L,int R,int k){
        if(L > R || k < 1)//检查输入参数是否合法
            return -1;
        if(L == R)//如果L等于R说明已找到，直接返回
            return p[R];
        int temp = quickSort(p,L,R);//进行一次快排，返回下标
        if(k+L == temp+1)//如果k+L等于返回的下标加１（L不一定从０开始）
            return p[temp];//则直接返回
        if(k+L < temp+1)//如果k+L小于返回的下标加１
            return findKth(p,L,temp-1,k);//在temp的左边查找第k大数
        else//否则，在temp的右边部分查找第k-(temp-L+1)大数。这里，右边的第
            //k-(temp-L+1)大数就是整个数组的第k大数
            return findKth(p,temp+1,R,k-(temp-L+1));
    }
    /*
     * 一次快速排序
     ＊以p[L]为比较对象，比p[L]大或等于的在其左边，否则在其右边
     */
    public static int quickSort(int[] p ,int L,int R){
        if(L >= R)
            return -1;
        int i = L;
        int j = R;
        int temp = p[L];
        while(i < j){
            while(i < j && p[j] < temp) j--;
            if(i < j){
                p[i] = p[j];
                i++;
            }
            while(i < j && p[i] > temp) i++;
            if(i < j){
                p[j] = p[i];
                j--;
            }
        }
        p[i] = temp;
        //去掉以下两句注释，再将return注释掉，并且将返回值改为void，
        //就是一个完整的快速排序
        //quickSort(p ,L,i-1);
        //quickSort(p ,i+1,R);
        return i;
    }

    public static void main(String[] args){
        int[] n = {2,1,4,0,5,3};
        int k = 2;
        int soe = findKth(n,0,n.length-1,k);
        System.out.println(soe);
        System.out.println(Arrays.toString(n));
        ArrayList a = new ArrayList(Arrays.asList(n));
    }
}
