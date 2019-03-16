/**
 * @author He.H
 * @date 2019/1/2 14:34
 **/


public class TestDemo{
    public static void main(String[] args){
        String a = "hellloo";
        String res = change(a);
        System.out.println(res);
    }
    public static String change(String s) {
        StringBuilder in = new StringBuilder(s);
        for (int i = 0; i < in.length() - 2; i++) {
            String tmp = in.substring(i, i + 3);
            char[] arr = tmp.toCharArray();
            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                String res = tmp.substring(0, 2);
                in.replace(i,i+3,res);
            }
        }
        for (int i = 0; i <in.length()-3; i++) {
            String tmp = in.substring(i, i + 4);
            char[] arr = tmp.toCharArray();
            if (arr[0] == arr[1] && arr[3] == arr[2]) {
                String res = tmp.substring(0, 3);
                in.replace(i,i+4,res);
            }
        }
        return String.valueOf(in);
    }
}
