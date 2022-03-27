import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LZWDecode {
    static ArrayList<NodeDecodeArray.DecodeListItem> AL;
    public static void main(String[] args)
    {
        NodeDecodeArray nda = new NodeDecodeArray();
        AL = nda.list();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String something = "";
        ArrayList<String> stringArray = new ArrayList<String>();
        while(input != null)
        {
            try
            {
                input = br.readLine();
                System.out.println(input);
                if(input != null)
                {
                    stringArray.add(input);
                }
            }
            catch(Exception e){}
        } 
        String fullInput = "";
        for(int i = 0; i < stringArray.size(); i++)
        {
            AL.add(nda.newNode(AL.size(), Integer.parseInt(stringArray.get(i)) ,AL.get(Integer.parseInt(stringArray.get(i))).character()));
        }
        for(int i = 0; i < stringArray.size(); i++)
        {
            fullInput += Decode(Integer.parseInt(stringArray.get(i)),AL.get(i));
        }
        System.out.println(fullInput);
    }
    public static String Decode(int index, NodeDecodeArray.DecodeListItem dn)
    {
        if(index != 0)
        {
            dn = AL.get(index);
            return dn.character() + Decode(dn.phraseNumbers(), dn);
        }
        return "";
    }
}