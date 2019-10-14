package FileRW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author He.H
 * @date 2019/10/14 9:41
 **/


public class BufffromKeyboard {
    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(
                new InputStreamReader(System.in));
        String str = null;
        System.out.println("请输入内容");
        try{
            str = buf.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("你输入的内容是：" + str);
    }
}
