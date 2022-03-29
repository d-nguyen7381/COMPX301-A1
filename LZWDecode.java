import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LZWDecode {
    static ArrayList<NodeDecodeArray.DecodeListItem> AL;
    static String fullInput = "";
    static ArrayList<String> characterDictionary;
    static ArrayList<Integer> phraseNumbers;
    static String globalString="";
    public static void main(String[] args)
    {
        NodeDecodeArray nda = new NodeDecodeArray();
        AL = nda.list();
        try {
            String content = Files.readString(Paths.get(args[0]));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //String input="";
            String[] input = content.split("\n");
            //br.readLine().split("\n");
            ArrayList<Integer> integerArrayInput = new ArrayList<Integer>();
            characterDictionary = new ArrayList<String>();
            phraseNumbers = new ArrayList<Integer>();
            String[] hexSymbols = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
            characterDictionary.add("");
            phraseNumbers.add(0);
            for(int hexDigits = 0; hexDigits < hexSymbols.length; hexDigits++)
            {
                characterDictionary.add(hexSymbols[hexDigits]);
                phraseNumbers.add(0);
            }
//            while((input = br.readLine()) != null)
//            {
//                if(input != null) {
//                    integerArrayInput.add(Integer.parseInt(input));
//                }
//            }
            for(String s: input)
            {
                if(input != null) {
                    integerArrayInput.add(Integer.parseInt(s));
                }
            }

            //OLD = first input code
//            int oldPhraseNumber= integerArrayInput.get(0);
//            //output translation of OLD
//            String c = "";
//            String oldTranslation = characterDictionary.get(oldPhraseNumber);
//            String S = "";
//            String newTranslation = oldTranslation;
//            for(int i = 1; i < integerArrayInput.size(); i++) {
//                //get next input code
//                int newPhraseNumber = integerArrayInput.get(i);
//                //if the index is not in the dictionary
//                if(!characterDictionary.contains(newPhraseNumber))
//                {
//                    S = characterDictionary.get(oldPhraseNumber);
//                    S = S + c;
//                }
//                else
//                {
//                    newTranslation = characterDictionary.get(newPhraseNumber);
//                    S = newTranslation;
//                }
//                //S = characterDictionary.get(oldPhraseNumber);
//                c = "" + S.charAt(0);
//                phraseNumbers.add(oldPhraseNumber);
//                oldTranslation = oldTranslation + c;
//                characterDictionary.add(oldTranslation);
//                newTranslation = characterDictionary.get(newPhraseNumber);
//                oldPhraseNumber = newPhraseNumber;
//                oldTranslation = newTranslation;
//            }
            //read a character k
            Integer i = 1;
            //get the first input code

            //puts the next start character as the character
            for(Integer indexArrayInput: integerArrayInput) {

//                int newPhraseNumber = 0;
//                int oldPhraseNumber = indexArrayInput;
//                if(i < integerArrayInput.size())
//                {
//                    newPhraseNumber = integerArrayInput.get(i);
//                }
//
//                phraseNumbers.add(oldPhraseNumber);
//                int checkPhrase = phraseNumbers.get(newPhraseNumber);
//                //while the phrase number is not 0
//                while(checkPhrase!= 0)
//                {
//                    newPhraseNumber = checkPhrase;
//                    checkPhrase = phraseNumbers.get(checkPhrase);
//                }
//                String currentChar = characterDictionary.get(newPhraseNumber);
//                characterDictionary.add(currentChar);
//                i++;
            }
//                if(i < 13)
//                {
//                    String full = characterDictionary.get(indexArrayInput) + characterDictionary.get(integerArrayInput.get(i));
//                    characterDictionary.set(characterDictionary.size()-1, full.substring(0, full.length()-1));
//                }
//                i++;


                //read character k
                //entry = dictionary entry for k
                //output entry
                //add w + first char of entry to the dictionary
                //w = entry
            //endloop
//            for(int integerArrayInputIndex =0; integerArrayInputIndex < integerArrayInput.size(); integerArrayInputIndex++)
//            {
//                int index = integerArrayInput.get(integerArrayInputIndex);
//                fullInput+= Decode(index);
//            }
//            System.out.print(fullInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String Decode(int index)
    {
//        ArrayList<Integer> arrayInt = new ArrayList<Integer>();
//        int thing = phraseNumbers.get(index);
//        globalString = "";
//        String charString="";
//        while(index != 0)
//        {
//            //globalString += charString;
//            arrayInt.add(index);
//            index = phraseNumbers.get(index);
//        }
//        while(arrayInt.size()!= 0)
//        {
//            Integer currIndex = arrayInt.get(arrayInt.size()-1);
//            charString = characterDictionary.get(currIndex);
//            globalString+= charString;
//            arrayInt.remove(arrayInt.size()-1);
//        }
//        return globalString;
    }
}