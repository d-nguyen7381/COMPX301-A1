import java.io.*;

public class byte2hex {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String str = "";

        // Loop that reads the standard input
        while(input != null) {
            try {
                str += input;
                input = br.readLine();
            }
            catch(Exception e) {}
        }

        byte[] strBytes = str.getBytes();   // Converts the given input into an array of bytes
        char[] strHex = bytesToHex(strBytes);    // Converts the array of bytes into a stream of hex values
//         for (char hex : strHex) {   // Loop that outputs the hex values
//             System.out.println(hex);
//         }
        System.out.print(strHex);
    }

    /**
     * Takes in an array of bytes and turns it into a stream of hexadecimal values
     * @param bytesArr 
     * @return an array of the stream of hexadecimal values
     */
    private static char[] bytesToHex(byte[] bytesArr) {
        final char hexChars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char[] hexArr = new char[bytesArr.length * 2];

        // Loop that converts each byte value into its two hexadecimal values, and its it to array
        for(int i = 0; i < bytesArr.length; i++) {
            hexArr[i*2] = hexChars[(bytesArr[i] & 0xf0) >> 4];
            hexArr[i*2 + 1] = hexChars[bytesArr[i] & 0x0f];
        }
        return hexArr;
    }
}

