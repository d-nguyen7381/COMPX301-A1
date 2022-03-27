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
            String w= AL.get(Integer.parseInt(stringArray.get(0))).character();
            int entry = 0;
            for(int i = 1; i < stringArray.size(); i++)
            {
                try
                {
                    //if previous index is not the same as the phrase number
//                    System.out.println(Integer.parseInt(stringArray.get(i)));
//                    if(AL.get(Integer.parseInt(stringArray.get(i+1))).character()!=AL.get(AL.get(Integer.parseInt(stringArray.get(i))).phraseNumbers()).character()) {
//                        AL.add(nda.newNode(AL.size(), Integer.parseInt(stringArray.get(i)), AL.get(Integer.parseInt(stringArray.get(i + 1))).character()));
//                    }
//                    else
//                    {
//                        AL.add(nda.newNode(AL.size(), Integer.parseInt(stringArray.get(i)), AL.get(Integer.parseInt(stringArray.get(i))).character()));
//                    }
                    AL.add(nda.newNode(AL.size(), entry, w));
                    w = w + AL.get(AL.get(Integer.parseInt(stringArray.get(i))).phraseNumbers()).character();
                    System.out.println(w);
                    entry = Integer.parseInt(stringArray.get(i));
                    w = AL.get(entry).character();
                    //AL.add(nda.newNode(AL.size(), Integer.parseInt(stringArray.get(i)), w));
//
                }
                catch(Exception e)
                {

                 }
            }
            for(int i =0; i < stringArray.size(); i++)
            {
                fullInput += Decode(Integer.parseInt(stringArray.get(i)),AL.get(i));
            }
            System.out.println(fullInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String Decode(int index, NodeDecodeArray.DecodeListItem dn)
    {
        //System.out.print(index);
        dn = AL.get(index);
        return dn.character();
    }
}