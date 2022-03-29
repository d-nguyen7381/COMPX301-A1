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
            String input ="";
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
           while((input = br.readLine()) != null)
           {
               if(input != null) {
                   integerArrayInput.add(Integer.parseInt(input));
               }
           }
            // for(String s: input)
            // {
            //     if(input != null) {
            //         integerArrayInput.add(Integer.parseInt(s));
            //     }
            // }

            //read a character k
            Integer i = 1;
            //get the first input code

            //puts the next start character as the character
            for(Integer indexArrayInput: integerArrayInput) {

                int newPhraseNumber = 0;
                int oldPhraseNumber = indexArrayInput;
                System.out.println(Decode(oldPhraseNumber));

                if(i < integerArrayInput.size())
                {
                    newPhraseNumber = integerArrayInput.get(i);
                }

                phraseNumbers.add(oldPhraseNumber);
                int checkPhrase = phraseNumbers.get(newPhraseNumber);
                //while the phrase number is not 0
                while(checkPhrase != 0)
                {
                    newPhraseNumber = checkPhrase;
                    checkPhrase = phraseNumbers.get(checkPhrase);
                }
                String currentChar = characterDictionary.get(newPhraseNumber);
                characterDictionary.add(currentChar);
                i++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String Decode(int index)
    {
        ArrayList<Integer> arrayInt = new ArrayList<Integer>();
        globalString = "";
        String charString="";
        while(index != 0)
        {
            //globalString += charString;
            arrayInt.add(index);
            index = phraseNumbers.get(index);
        }
        while(arrayInt.size()!= 0)
        {
            Integer currIndex = arrayInt.get(arrayInt.size()-1);
            charString = characterDictionary.get(currIndex);
            globalString+= charString;
            arrayInt.remove(arrayInt.size()-1);
        }
        return globalString;
    }
}