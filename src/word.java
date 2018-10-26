import java.util.*;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/9/8
 */
public class word {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        HashMap<Integer,char[]> imap = new HashMap<>();
        for (int t = 0; t<n; t++){
            String input0 = in.nextLine();
            char[] input1 = input0.toCharArray();
            imap.put(t,input1);
        }
        int c=0;
        while (c<n) {

            HashSet<Integer> lable = new HashSet<>();
            char[] input = imap.get(c);
            for (int i = 1; i < input.length-2; i++) {
                if (input[i]-input[i-1]==1&&input[i+1]-input[i]==1&&input[i+2]-input[i]==2) {
                    lable.add(i);
                    lable.add(i+1);
                }
            }
            ArrayList<Object> out= new ArrayList<>();
            for (int i = 0; i < input.length; i++){
                if (!lable.contains(i)){
                    out.add(String.valueOf(input[i]));
                }else if (lable.contains(i)){
                    if (out.get(out.size()-1).equals('-')){
                        continue;
                    }
                    out.add('-');
                }
            }
            for(int i = 0 ; i<out.size();i++){
                System.out.print(out.get(i));
            }
            lable.clear();
            out.clear();
            System.out.println();
            c++;
        }
    }
}