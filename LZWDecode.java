import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LZWDecode {
    static ArrayList<NodeDecodeArray.DecodeNode> AL;
    public static void main(String[] args)
    {
        NodeDecodeArray nda = new NodeDecodeArray();
        AL = nda.list();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String something = "";
        NodeDecodeArray.DecodeNode dn;
        while(input != null)
        {
            try
            {
                something += input;
                input = br.readLine();
            }
            catch(Exception e){}
        }
        String[] stringArray = something.split(" ");
        String fullInput = "";
        for(int i = 0; i < stringArray.length; i++)
        {
            System.out.println(AL.size() + "," +  stringArray[i] + "," + AL.get(Integer.parseInt(stringArray[i])).character());
            AL.add(nda.newNode(AL.size(), Integer.parseInt(stringArray[i]) , AL.get(Integer.parseInt(stringArray[i])).character()));
        }
        for(int i = 0; i < stringArray.length; i++)
        {
            fullInput += Decode(Integer.parseInt(stringArray[i]),AL.get(i));
        }
        System.out.println(fullInput);
    }
    public static String Decode(int index, NodeDecodeArray.DecodeNode dn)
    {
        String fullPhrase="";
        if(index != 0)
        {
            dn = AL.get(index);
            return fullPhrase += dn.character() + Decode(dn.phraseNumbers(), dn);
        }
        return fullPhrase;
    }
}