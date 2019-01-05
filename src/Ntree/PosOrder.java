package Ntree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author He.H
 * @date 2019/1/5 9:49
 **/


public class PosOrder {
    /*List<Integer> res = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        if(root == null)
            return res;
        if(root.children.size()>0){
            for(Node child : root.children){
                postorder(child);
            }
        }
        res.add(root.val);
        return res;
    }*/

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<Node> stack = new Stack<Node>();
        Node pre = null;
        stack.push(root);
        while(!stack.isEmpty()){
            Node curr = stack.peek();
            if((curr.children.size() == 0)||(pre != null && (curr.children.contains(pre)))){
                res.add(curr.val);
                pre = curr;
                stack.pop();
            }else{
                for(int i = curr.children.size()-1;i>=0;i--){
                    stack.push(curr.children.get(i));
                }
            }
        }
        return res;
    }
}
