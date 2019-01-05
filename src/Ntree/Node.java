package Ntree;

import java.util.List;

/**
 *       N叉数
 * @author He.H
 * @date 2019/1/5 9:37
 **/


public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
