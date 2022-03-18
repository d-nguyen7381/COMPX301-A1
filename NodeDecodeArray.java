import java.util.ArrayList;

import javax.swing.text.PlainDocument;
//this class is responsuble for assigning
//a decode array
class NodeDecodeArray
{
    String[] hexChars = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    ArrayList<DecodeListItem> list;
    public NodeDecodeArray()
    {
        DecodeListItem dn = new DecodeListItem(0, 0, "\0");
        list= new ArrayList<DecodeListItem>();
        list.add(dn);
        for(int i = 0; i < hexChars.length; i++)
        {
            dn = new DecodeListItem(i+1, 0, hexChars[i]);
            list.add(dn);
        }
    }
    public ArrayList<DecodeListItem> list()
    {
        return this.list;
    }
    public DecodeListItem newNode(int index, int p, String c) {
        return new DecodeListItem(index, p, c);
    }
    public class DecodeListItem
    {
        int phraseNumber;
        String c;
        int index;
        public DecodeListItem(int index, int p, String c)
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