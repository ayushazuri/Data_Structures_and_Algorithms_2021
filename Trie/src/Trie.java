class Node{
    Node[] link = new Node[26];
    boolean flag = false;

    public boolean containsKey(char ch){
        return link[ch-'a'] != null;
    }

    public void put(char ch, Node node){
        link[ch-'a'] = node;
    }

    public Node get(char ch){
        return link[ch-'a'];
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i)))
                node.put(word.charAt(i), new Node());

            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;

        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i)))
                return false;

            node = node.get(word.charAt(i));
        }

        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;

        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i)))
                return false;

            node = node.get(prefix.charAt(i));
        }
        return true;
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apps");
        trie.insert("alse");
        trie.insert("bat");

        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("appsd"));

        System.out.println(trie.startsWith("ap"));
        System.out.println(trie.startsWith("sp"));
        System.out.println(trie.startsWith("apps"));
    }
}

