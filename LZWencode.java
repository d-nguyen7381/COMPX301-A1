import java.io.*;

public class LZWencode {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // Buffered reader for reading input
        Trie dictionary = new Trie();   // Trie dictionairy for LZW algorithm
        String hexStr = ""; // Stores the hex digit inputs as a string
        
        String input = ""; 
        while(input != null) {  // Loop that reads the standard input and stores it
            try {
                hexStr += input;    
                input = br.readLine();   
            }
            catch(Exception e) {}
        }

        char[] hexArr = hexStr.toCharArray();   // Splits hexStr into an array of char's.

        int i = 0;  // counter that keeps track of which index the algo is up to.
        int j = 1;  // used to increment the counter

        while(i < hexArr.length - 1) {  // will add comments later i cbf
            dictionary.resetCurrNode();
            if(dictionary.searchCurrNode(hexArr[i])) {
                while(true) {
                    if(!dictionary.searchCurrNode(hexArr[i+j])) {
                        dictionary.insertAtCurrNode(hexArr[i+j]);         
                        i += j;
                        j = 1;
                        break;
                    }
                    else if (i + j < hexArr.length - 1) {
                        dictionary.searchCurrNode(hexArr[i+j]);
                        j++;
                    }
                }
            }
            System.out.println(dictionary.getCurrNode().getPhrase());
        }

        /* The LWZ loop won't print out at the last phrase number unless it belongs to a sequence.
        This if statment is here to make sure that it does get printed out. (will probably fix loop later)
        */
        if(hexArr[hexArr.length - 1] != dictionary.getCurrNode().getChar()) {
            dictionary.resetCurrNode();
            dictionary.searchCurrNode(hexArr[hexArr.length - 1]);
            System.out.println(dictionary.getCurrNode().getPhrase());
        }

    }
}
