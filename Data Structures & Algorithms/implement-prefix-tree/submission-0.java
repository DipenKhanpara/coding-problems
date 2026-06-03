class PrefixTree {

    Node first;

    public PrefixTree() {
        first = new Node();     
    }

    public void insert(String word) {
        Node node = first;
        for(char c : word.toCharArray()){
            if(node.child[c-'a'] == null){
                node.child[c-'a'] = new Node();
            }
            node = node.child[c-'a'];
        }
        node.eow = true;
    }

    public boolean search(String word) {
        Node node = first;
        for(char c : word.toCharArray()){
            if(node.child[c-'a'] == null) return false;
            node = node.child[c-'a'];
        }
        return node.eow;
    }

    public boolean startsWith(String prefix) {
        Node node = first;
        for(char c : prefix.toCharArray()){
            if(node.child[c-'a'] == null) return false;
            node = node.child[c-'a'];
        }
        return true;
    }
}

class Node {
    Node[] child = new Node[26];
    boolean eow;
}
