import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LZWDecode {
    static ArrayList<NodeDecodeArray.DecodeListItem> AL;
    public static void main(String[] args)
    {
        NodeDecodeArray nda = new NodeDecodeArray();
        AL = nda.list();
        try {
            //String content = Files.readString(Paths.get(args[0]));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = "";
            ArrayList<String> stringArray = new ArrayList<String>();
            int stringArrayIndex = 0;
            // for(stringArrayIndex = 0; stringArrayIndex < input.length; stringArrayIndex++)
            // {
            //     try
            //     {
            //         stringArray.add(input[stringArrayIndex]);
            //     }
            //     catch(Exception e){}
            // }
            while(br.readLine()!=null)
            {
                input = br.readLine();
                if(input != null)
                {
                    stringArray.add(input);
                }
            }
            String fullInput = "";
            for(int i = 0; i < stringArray.size(); i++)
            {
                try
                {
                    //if previous index is not the same as the phrase number
                    System.out.println(Integer.parseInt(stringArray.get(i)));
                    if(Integer.parseInt(stringArray.get(i+1))!=AL.size()) {
                        AL.add(nda.newNode(AL.size(), Integer.parseInt(stringArray.get(i)), AL.get(Integer.parseInt(stringArray.get(i + 1))).character()));
                    }
                    else
                    {
                        AL.add(nda.newNode(AL.size(), Integer.parseInt(stringArray.get(i)), AL.get(Integer.parseInt(stringArray.get(i))).character()));
                    }

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

        System.out.println(AL.size());
        //System.out.print(index);
        if(index != 0)
        {
            dn = AL.get(index);
            return Decode(dn.phraseNumbers(), dn) + dn.character();
        }
        return "";
    }
}