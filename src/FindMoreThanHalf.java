/**
 * @author He.H
 * @date 2019/3/5 10:09
 **/


public class FindMoreThanHalf {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length<=0)  return 0;
        int result=array[0];
        int count=1;
        for(int i=1;i<array.length;i++){
            if(array[i]==result){
                count++;
            }else{
                count--;
            }
            if(count==0){
                result=array[i];
                count=1;
            }
        }
        int time=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==result){
                time++;
            }
        }
        if(time>array.length/2){
            return result;
        }else {
            return 0;
        }
    }
}
