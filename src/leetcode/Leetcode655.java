package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * print tree
 *
 * @author He.H
 * @date 2018/12/28 15:56
 **/


public class Leetcode655 {
    String[][] array;
    public int getHeight(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    public void setNode(TreeNode root, int row, int left, int right) {
        if(root == null)
            return;
        int mid = (left + right) / 2;
        array[row][mid] = String.valueOf(root.val);

        setNode(root.left, row + 1, left, mid - 1);
        setNode(root.right, row + 1, mid + 1, right);
    }
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int column = (int)Math.pow(2, height) - 1;
        array = new String[height][column];
        setNode(root, 0, 0, column - 1);
        List<List<String>> result = new LinkedList<List<String>>();
        for(int i = 0; i < height; i++) {
            List<String> list = new LinkedList<>();
            for(int j = 0; j < column; j++) {

                if(array[i][j] == null)
                    list.add("");
                else
                    list.add(array[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}
