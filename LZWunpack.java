import java.io.*;
import java.util.ArrayList;

public class LZWunpack
{
    public static void main(String args[])
    {
        final int byteMask = 255; // Byte mask used to extract the byte value when the byte gets turned into an int
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // Buffered reader for reading input
        ArrayList<Byte> byteList = new ArrayList<Byte>();   // Used to temporarily store the bytes piped in
        String input = "";  // Stores the result of each readLine()

        while(input != null) {  // Loop that reads the standard input and stores it
            try {
                input = br.readLine(); 
                byteList.add(Byte.parseByte(input));   
            }
            catch(Exception e) {}
        }

        // Turns the byteList into an array and then gets cleared out.
        Byte[] byteArr = byteList.toArray(new Byte[0]);
        byteList = null;

        int numPhases = 16; // Stores the number of phrases (16 by default)   
        int store = 0;  // Used to temporarily store bytes and operate on them

        /*
         Stores how much a byte should be left shifted when turned into int for storing.
         Also used to know how many bits are used in the store.
        */
        int shiftValue = 0;

        /* 
        Initializes the number of bits used for a phrase and
        a mask used to extract it from the store
        */
        int numSize = (int)Math.ceil(log2(numPhases+1));
        int maskSize = (int)Math.pow(2, numSize) - 1;

        int val;    // Stores the int value of the byte

        for(int i = 0; i < byteArr.length; i++) {   // Loops through all the byte values
            /*
            Outputs a phrase number and right shifts the store if the next
            number is too big to be stored
            */
            if(shiftValue + 8 >= 32) {
                System.out.println(store & maskSize);
                store = store >> numSize;
                shiftValue -= numSize;
                numPhases++;
            }
            
            /* 
            Stores the byte value at the current index of byteArr and stores it
            as an int. It then gets left shifted by how many bits are already used in the store.
            */
            val = byteArr[i] & byteMask;    
            val = val << shiftValue;

            // Adds the byte value to the store and increase shift value by 8 (bits)
            store = store | val;    
            shiftValue += 8;    
            
            /* 
            Outputs a phrase number if current number of bits used in the store exceeds
            the number of bits used for the next phrase number
            */
            if(shiftValue > numSize) {
                System.out.println(store & maskSize);
                store = store >> numSize;
                shiftValue -= numSize;
            }
            
            // Increments numPhases and updates numSize and maskSize
            numPhases++;
            numSize = (int)Math.ceil(log2(numPhases+1));
            maskSize = (int)Math.pow(2, numSize) - 1;
        }

        // Spits out the remaining phrases left in the store
        while (store != 0) {
            System.out.println(store & maskSize);
            store = store >> numSize;
            numPhases++;
            numSize = (int)Math.ceil(log2(numPhases+1));
            maskSize = (int)Math.pow(2, numSize) - 1;
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