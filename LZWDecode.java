import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LZWDecode {
    static ArrayList<String> characterDictionary;
    static ArrayList<Integer> phraseNumbers;
    static String globalString="";
    public static void main(String[] args)
    {
        try {
            //if you want to decode, use this
            //String content = Files.readString(Paths.get(args[0]));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //puts the outputted phrase numbers into an array
            //if you want to decode, use this
            //String input = br.readLine();//content.split("\n");
            ArrayList<Integer> integerArrayInput = new ArrayList<Integer>();

            //create new ArrayList for this project
            characterDictionary = new ArrayList<String>();
            phraseNumbers = new ArrayList<Integer>();
            String[] hexSymbols = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

            //0th index is a blank character
            characterDictionary.add("");
            phraseNumbers.add(0);

            //instantiate the beginning list
            for(int hexDigits = 0; hexDigits < hexSymbols.length; hexDigits++)
            {
                characterDictionary.add(hexSymbols[hexDigits]);
                phraseNumbers.add(0);
            }
            String input;
            while((input = br.readLine())!= null)
            {
                if(input != null) {
                    integerArrayInput.add(Integer.parseInt(input));
                }
            }
            //adds the inputted phrase numbers to arraylist
            //if you want to decode, use this
//            for(String s: input)
//            {
//                if(input != null) {
//                    integerArrayInput.add(Integer.parseInt(s));
//                }
//            }
            //setting lookahead
            Integer i = 1;
            //while list is not yet at the end
            for(Integer indexArrayInput: integerArrayInput) {

                int newPhraseNumber = integerArrayInput.get(i);
                int oldPhraseNumber = indexArrayInput;
                //adds the current phrase number to its phraseNumber list
                phraseNumbers.add(oldPhraseNumber);

                //output the full string
                String fullOutput = Decode(oldPhraseNumber,indexArrayInput);
                System.out.println(fullOutput);

                //while the phrase number is not 0
                int checkPhrase = phraseNumbers.get(newPhraseNumber);
                //this is used to check if the letter we are looking at is the first character available
                //since if the phraseNumber being pointed to is 0, then nothing it returns nothing
                //this is how I coded it because there are times where the indices and phrase numbers are the same
                //this means that the new index must be the same as the first character of current index
                while(checkPhrase != 0)
                {
                    newPhraseNumber = checkPhrase;
                    checkPhrase = phraseNumbers.get(checkPhrase);
                }
                //adds the new character to the list
                String currentChar = characterDictionary.get(newPhraseNumber);
                characterDictionary.add(currentChar);
                i++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //outputs the full string concatenated
    public static String Decode(int index, int curr)
    {
        //create an arrayList for the amount of activity the list will do
        ArrayList<Integer> arrayInt = new ArrayList<Integer>();
        globalString = "";
        String charString="";
        //while the counter doesnt point to indexes 0 to 16
        //add the phraseNumber to the arrayList
        while(index != 0)
        {
            arrayInt.add(index);
            index = phraseNumbers.get(index);
        }
        //while the arrayList is not empty, add character to a globalString
        System.out.println("currently printing out the Index of " + curr);
        while(arrayInt.size()!= 0)
        {
            Integer currIndex = arrayInt.get(arrayInt.size()-1);
            charString = characterDictionary.get(currIndex);

            globalString+= currIndex + " " + charString+"\n";
            //remove the activity once done
            arrayInt.remove(arrayInt.size()-1);
        }
        return globalString;
    }
}