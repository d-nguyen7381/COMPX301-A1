public class Trie {
    final private char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private int newPhrase;
    private Node root;
    private Node currNode;
    

    public Trie() {
        newPhrase = hexDigits.length;
        root = new Node('\0', 0);

        for(int i = 0; i < hexDigits.length; i++) {
            root.children[i] = new Node(hexDigits[i], i);
        }

        currNode = root;
    }

    class Node {
        private char c;
        private int phrase;
        protected Node[] children = new Node[hexDigits.length];
        
        public Node(char c, int p) {
            this.c = c;
            this.phrase = p;
        }

        public char getChar() { return c; }
    }

    public boolean search(char c) {

        for(int i = 0; i < root.children.length; i++) {
            if(currNode.children[i].getChar() == c) return true;
        }

        return false;
    }

    public void insert(char c) {

    }
}
