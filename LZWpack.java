import java.io.*;
import java.util.ArrayList;

public class LZWpack {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // Buffered reader for reading input
        ArrayList<Integer> phraseArr = new ArrayList<Integer>();    // Stores the phrase numbers piped in from stdout
        String input = "";  // Stores the result of each readLine()

        while(input != null) {  // Loop that reads the piped output and stores it
            try {
                input = br.readLine(); 
                phraseArr.add(Integer.parseInt(input));   
            }
            catch(Exception e) {}
        }

        
        int numPhases = 16; // Stores the number of phrases (16 by default)       
        int store = 0;  // Used to store bytes and operate on them
        int shiftValue = 0; // Stores how much it should left shift the phrase number for storing
        int bitsUsed = 0;   // Stores how many bits are being used in the 'int store'
        int number; // Stores the phrase number

        for(int i = 0; i < phraseArr.size(); i++) { // Loops through all the phrase numbers
            /*
            Outputs a byte and right shifts the store if the next
            number is too big to be stored
            */
            while(bitsUsed + (int)Math.ceil(log2(numPhases+1)) > 32) {  
                System.out.println((byte)store);
                store = store >>> 8;
                shiftValue -= 8;
                bitsUsed -= 8;
            }
            /* 
            Gets the phrase number from the current index of phraseArr
            and shifts it by how many bits was used for the last phrase number
            */
            number = phraseArr.get(i); 
            number = number << shiftValue;
            /*
            Updates the shift value and the number of bits being used
            */
            shiftValue += (int)Math.ceil(log2(numPhases+1));
            bitsUsed += (int)Math.ceil(log2(numPhases+1));
            
            store |= number;    // Adds the phrase number to the store
            numPhases++;
        }

        // Spits out the remaining bytes left in the store
        while(store != 0) {
            System.out.println((byte)store);
            store = store >>> 8;
        }
    }


    /**
     * Log Base 2 function.
     * @param x 
     * @return
     */
    public static double log2(int x) {
        return Math.log(x) / Math.log(2);
    }
}
