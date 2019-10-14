package FileRW;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author He.H
 * @date 2019/10/14 9:27
 **/


public class Atoa {
    /*转换大小写*/
    public static void main(String[] args) throws IOException {
        String str = "ROLLENHOLT";
        ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int temp = 0;
        while ((temp = input.read()) != -1) {
            char ch = (char) temp;
            output.write(Character.toLowerCase(ch));
        }
        String outStr = output.toString();
        input.close();
        output.close();
        System.out.println(outStr);
    }

}
