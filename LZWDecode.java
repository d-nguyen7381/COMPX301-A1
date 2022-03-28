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
            String content = Files.readString(Paths.get(args[0]));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //String input="";
            String[] input = content.split("\r\n");
            ArrayList<String> stringArray = new ArrayList<String>();
            characterDictionary = new ArrayList<String>();
            phraseNumbers = new ArrayList<Integer>();
            String[] hexChars = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
            characterDictionary.add("\n");
            phraseNumbers.add(null);
            for(int hexDigits = 0; hexDigits < hexChars.length; hexDigits++)
            {
                characterDictionary.add(hexChars[hexDigits]);
                phraseNumbers.add(0);
            }
            int stringArrayIndex = 0;
            for(stringArrayIndex = 0; stringArrayIndex < input.length; stringArrayIndex++)
            {
                try
                {
                    stringArray.add(input[stringArrayIndex]);
                }
                catch(Exception e){}
            }
            // while(br.readLine()!=null)
            // {
            //     input = br.readLine();
            //     if(input != null)
            //     {
            //         stringArray.add(input);
            //     }
            // }

            int OLD= Integer.parseInt(stringArray.get(0));
            System.out.println(OLD);
            String oldCode = characterDictionary.get(OLD);
            System.out.println(oldCode);
            int entry = 0;
            String combined = "";
            for(int i = 1; i < stringArray.size(); i++) {
                int NEW_CODE = Integer.parseInt(stringArray.get(i));
                if(!phraseNumbers.contains(NEW_CODE))
                {
                    combined = characterDictionary.get(OLD);
                    combined += oldCode;
                }
                else
                {
                    combined = characterDictionary.get(NEW_CODE);
                }
                System.out.println(combined);
                phraseNumbers.add(phraseNumbers.size());
                oldCode
                characterDictionary.add(oldCode + combined.charAt(0));
                OLD = NEW_CODE;

            }
            for(int i =0; i < stringArray.size(); i++)
            {
                fullInput += Decode(phraseNumbers.get(Integer.parseInt(stringArray.get(i))),characterDictionary.get(Integer.parseInt(stringArray.get(i))));
            }
            System.out.println(fullInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String Decode(int index, String dn)
    {
        System.out.print(index);
        return Decode(phraseNumbers.get(index), characterDictionary.get(index))+ dn;
    }
//    public static boolean exists(NodeDecodeArray.DecodeListItem dn)
//    {
//        if()
//        {
//            return true
//        }
//        return false;
//    }

}