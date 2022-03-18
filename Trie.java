import java.util.Currency;

public class Trie {
    final private char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private int newPhrase;
    private Node root;
    private Node currNode;

    public Trie() {
        newPhrase = hexDigits.length + 1;
        root = new Node('\0', 0);
        currNode = root;

        for(int i = 0; i < hexDigits.length; i++) { // loop that initializes the children of the root node
            root.children[i] = new Node(hexDigits[i], i+1);
        }
    }

    class Node {
        private char c;
        private int phrase;
        protected Node[] children = new Node[hexDigits.length];
        
        public Node(char c, int p) {
            this.c = c;
            this.phrase = p;
        }

        // Returns the character associated with the node
        public char getChar() { return c; }
        // Returns the phrase of the node
        public int getPhrase() { return phrase; }
    }

    // Returns the current node
    public Node getCurrNode() { return currNode; }

    /**
     * Resets the current node pointer to the root
     */
    public void resetCurrNode() { currNode = root; }

    /**
     * Searches if the current node has a child that has the value of the given char.
     * @param c the specified value we want to find
     * @return
     */
    public boolean searchCurrNode(char c) {
        try {
            for(int i = 0; i < root.children.length; i++) { // loop that checks all the currNode's children
                if(currNode.children[i].getChar() == c) {   // if the child has the specified value, set currNode pointer to that child.
                    currNode = currNode.children[i];
                    return true;
                }
            }
        }
        catch(Exception e){
            return false;
        }
        return false;
    }
    /**
     * Inserts a new child/node at the current node.
     * @param c the specified value we want to insert
     */
    public void insertAtCurrNode(char c) {
        for(int i = 0; i < currNode.children.length; i++) {
            // checks for the next empty space in currNode's children, and inserts the new node
            if(currNode.children[i] == null) {
                currNode.children[i] = new Node(c, newPhrase);
                newPhrase++;    // increments the value of the new phrase for the next insert
                System.out.println(currNode.children[i].getChar() + "," + currNode.children[i].getPhrase());
                break;
            } 
        }
    }
}
