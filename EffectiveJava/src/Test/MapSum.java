package Test;

import java.util.HashMap;

public class MapSum {

   private TrieNode root ;
    public MapSum(){
        root = new TrieNode('*');
    }

    public void insert(String key, int val){
        TrieNode node = root;
        for(char c: key.toCharArray()){
            TrieNode n = node.children.get(c);
            if(n == null){
                n = new TrieNode(c);
                node.children.put(c,n);
            }
            node.children.get(c).sum+=val;
            node = n;
        }
    }

    public int sum(String prefix){
        TrieNode n =root;
        for(char c : prefix.toCharArray()){
            if(n.children.containsKey(c))
                n = n.children.get(c);
            else
                return 0;
        }
        return n.sum;
    }

}

class TrieNode{
    private char c;
    int sum;
    HashMap<Character, TrieNode> children;

    public TrieNode(char c) {
        this.c = c;
        children = new HashMap<Character, TrieNode>();
    }
}
