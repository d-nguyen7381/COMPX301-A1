import java.util.ArrayList;

import javax.swing.text.PlainDocument;
//this class is responsuble for assigning
//a decode array
class NodeDecodeArray
{
    String[] hexChars = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    ArrayList<DecodeNode> list;
    public NodeDecodeArray()
    {
        DecodeNode dn = new DecodeNode(0, 0, "\0");
        list= new ArrayList<DecodeNode>();
        list.add(dn);
        for(int i = 0; i < hexChars.length; i++)
        {
            dn = new DecodeNode(i+1, 0, hexChars[i]);
            list.add(dn);
        }
    }
    public ArrayList<DecodeNode> list()
    {
        return this.list;
    }
    public DecodeNode newNode(int index, int p, String c) {
        return new DecodeNode(index, p, c);
    }
    public class DecodeNode
    {
        int phraseNumber;
        String c;
        int index;
        public DecodeNode(int index, int p, String c)
        {
            this.index = index;
            this.phraseNumber = p;
            this.c = c;
        }
        public int phraseNumbers()
        {
            return this.phraseNumber;
        }
        public String character()
        {
            return this.c;
        }
        public int index()
        {
            return this.index;
        }
    }
}