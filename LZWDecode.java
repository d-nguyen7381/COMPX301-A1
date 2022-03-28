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
    public static void main(String[] args)
    {
        NodeDecodeArray nda = new NodeDecodeArray();
        AL = nda.list();
        try {
            //String content = Files.readString(Paths.get(args[0]));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input="";
            //String[] input = br.readLine().split("\r\n");//content.split("\r\n");
            ArrayList<Integer> integerArrayInput = new ArrayList<Integer>();
            characterDictionary = new ArrayList<String>();
            phraseNumbers = new ArrayList<Integer>();
            String[] hexSymbols = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
            characterDictionary.add("\n");
            phraseNumbers.add(null);
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
//            for(String s: input)
//            {
//
//            }
//             while(br.readLine()!=null)
//             {
//                 input = br.readLine();
//                 if(input != null)
//                 {
//                     stringArray.add(input);
//                 }
//             }
            //OLD = first input code
            int oldPhraseNumber= integerArrayInput.get(0);
            //output translation of OLD
            String c = "";
            String oldTranslation = characterDictionary.get(oldPhraseNumber);
            String S = "";
            String newTranslation = oldTranslation;
            for(int i = 1; i < integerArrayInput.size(); i++) {
                //get next input code
                int newPhraseNumber = integerArrayInput.get(i);
                if(!characterDictionary.contains(newTranslation))
                {
                    S = characterDictionary.get(oldPhraseNumber);
                    S = S + c;

                }
                else
                {
                    newTranslation = characterDictionary.get(newPhraseNumber);
                    S = newTranslation;
                }
                c = "" + S.charAt(0);
                phraseNumbers.add(oldPhraseNumber);
                oldTranslation = oldTranslation + c;
                characterDictionary.add(oldTranslation);
                newTranslation = characterDictionary.get(newPhraseNumber);
                oldPhraseNumber = newPhraseNumber;
                oldTranslation = newTranslation;
            }
            for(int i =0; i < integerArrayInput.size(); i++)
            {
                int index = integerArrayInput.get(i);
                fullInput+= Decode(index);
            }
            System.out.print(fullInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String Decode(int index)
    {
        if(index != 0) {
            return Decode(phraseNumbers.get(index)) + characterDictionary.get(index).charAt(characterDictionary.get(index).length()-1);
        }
        return "";
    }

}