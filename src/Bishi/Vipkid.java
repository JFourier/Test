package Bishi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/3 17:00
 **/


public class Vipkid {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] tmparr = str.split(",");
        List<Long> list = new ArrayList<>();
        for(int i=0;i<tmparr.length;i++){
            list.add(Long.parseLong(tmparr[i].trim()));
        }
        int ans = 0;
        Collections.sort(list);
        int i = 0;
        int j = list.size()-1;
        while(i<j){
            if(list.get(i)+list.get(j)<0){
                i++;
            }else if(list.get(i)+list.get(j)>0){
                j--;
            }else{
                ans++;
                i++;
                j--;
            }
        }
        System.out.println(ans);
    }
}
