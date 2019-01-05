package Ntree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author He.H
 * @date 2019/1/5 9:42
 **/


public class PreOrder {
    public List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if(root == null)
            return res;
        res.add(root.val);
        for(Node child : root.children){
            preorder(child);
        }
        return res;
    }
    /*public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<Node> stack = new Stack<Node>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            res.add(node.val);
            for(int i = node.children.size()-1;i >= 0;i--){
                stack.add(node.children.get(i));
            }
        }
        return res;
    }*/
}
