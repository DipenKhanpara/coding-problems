class WordDictionary {

    Node first;

    public WordDictionary() {
        first = new Node('#');
    }

    public void addWord(String word) {
        Node node = first;
        for(char c: word.toCharArray()){
            if(node.next[c-'a'] == null){
                node.next[c-'a'] = new Node(c);
            }
            node = node.next[c-'a'];
        }
        node.eow = true;
    }

    public boolean search(String word) {
        return search(first, 0, word);
    }

    public boolean search(Node node, int i, String word){
        if(node == null) return false;
        if(i == word.length()){
            return node.eow;
        }
        char c = word.charAt(i);        
        if(c != '.'){
            return search(node.next[c-'a'], i+1, word);
        }
        for(Node next : node.next){
            if(search(next, i+1, word)) return true;
        }
        return false;
    }

    static class Node {
        char c;
        boolean eow;
        Node[] next = new Node[26];
        Node(char c){
            this.c = c;
        }
    }
}