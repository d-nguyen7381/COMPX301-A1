import java.util.ArrayList;

import javax.swing.text.PlainDocument;
//this class is responsuble for assigning
//a decode array
class NodeDecodeArray
{
    char[] hexChars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    public NodeDecodeArray()
    {
        ArrayList<DecodeNode> list= new ArrayList<DecodeNode>();
        for(int i = 0; i < hexChars.length; i++)
        {
            DecodeNode dn = new DecodeNode(i, hexChars[i]);
            list.add(dn);
        }
    }    
    class DecodeNode
    {
        int phraseNumber;
        char c;
        DecodeNode(int p, char c)
        {
            this.phraseNumber = p;
            this.c = c;
        }
        public int phraseNumbers()
        {
            return this.phraseNumber;
        }
        public char character()
        {
            return this.c;
        }
    }
}