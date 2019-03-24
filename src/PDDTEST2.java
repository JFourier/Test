import java.util.*;

/**
 * @author He.H
 * @date 2019/3/10 16:49
 **/


public class PDDTEST2 {

    public static int solve(String s1, String s2) {
        ArrayList<String> result = new ArrayList<String>();
        String res = "";
        dfs(result,res,s1,s2,0,0);
        return result.size();
    }
    public static void dfs(ArrayList<String> result, String res, String s1, String s2,int index1, int index2) {
        if(index1 == s1.length()-1 &&index2 == s2.length()-1) {
            result.add(res);
        }
    }



    public static boolean isValid(String s) {
        Stack<Character> S=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='('){
                S.push(')');
            }else if(c=='{'){
                S.push('}');
            }else if(c=='['){
                S.push(']');
            }else if(S.empty()||S.pop()!=c){
                return false;
            }
        }
        return S.empty();
    }
}
