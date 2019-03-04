package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode  648
 *
 * @author He.H
 * @date 2018/12/27 19:21
 **/


public class Leetcode648 {
//    public String replaceWords(List<String> dict, String sentence) {
//        Set<String> set = new HashSet<>(dict);
//        StringBuilder sb = new StringBuilder();
//        String[] word = sentence.split(" ");
//        for(int i = 0;i<word.length;i++) {
//            for (int j = 1; j <= word[i].length(); j++) {
//                if (set.contains(word[i].substring(0, j)))
//                    word[i] = word[i].substring(0, j);
//            }
//            sb.append(word[i] +" ");
//        }
//        return sb.substring(0,sb.length()-1);
//    }
    private class Node {
        private char val;
        private Node[] next;
        private boolean isEnd;
        public Node(char val) {
            this.val=val;
            this.next = new Node[26];
            this.isEnd = false;
        }
    }
    public void insert(Node curNode,String word) {
        for (char c : word.toCharArray()) {
            if (curNode.next[c - 'a'] == null) {
                curNode.next[c - 'a'] = new Node(c);
            }
            curNode = curNode.next[c - 'a'];
        }
        curNode.isEnd = true;
    }
    public String search(Node curNode, String word){
        StringBuilder cur = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (curNode.next[c-'a'] == null) {
                break;
            }
            cur.append(c);
            curNode = curNode.next[c-'a'];
            if (curNode.isEnd) {
                return cur.toString();
            }
        }
        return word;
    }
    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0 || sentence == null || sentence.length() == 0) {
            return "";
        }
        Node root=new Node(' ');
        for (String word : dict) {
            insert(root, word);
        }
        StringBuilder res = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            res.append(search(root,word));
            res.append(" ");
        }
        return res.toString().trim();
    }
}
