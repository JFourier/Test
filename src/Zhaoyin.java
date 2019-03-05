/**
 * @author He.H
 * @date 2019/3/4 16:31
 **/


public class Zhaoyin {
    public static void main(String[] args){
        int n = 3;
        int[] a = new int[]{1,2,2};
//        for ( int i = 0 ; i < a.length ; i++ ){
//            while( a[i] != i ){
//                if( a[i] == a[a[i]] ){
//                    System.out.print(a[i]);
//                    return ;
//                }
//                else{
//                    int temp = a[i] ;
//                    a[i] = a[ a[i]] ;
//                    a[temp] = temp ;
//                }
//            }
//        }

        int i = 0;
        while (i<n){
            int temp = a[i] - 1;//a[i]的位置
            if(temp<0) {
                i++;
                continue;
            }else if(a[temp]>0) {
                a[i]=a[temp];
                a[temp]=-1;
            } else {
                a[temp]--;
                a[i]=0;
            }
        }

        for (int q : a) {
            System.out.println(q);
        }
    }
}
