import java.util.ArrayList;

public class MatchListV2
{
   private ArrayList<MatchV2> matchs;
   
   public MatchListV2()
   {
      matchs = new ArrayList<MatchV2>();
   }
   
   public void addMatch(MatchV2 match)
   {
       matchs.add(match);
      
   }
   
   public void removeMatch(MatchV2 match)
   {
      matchs.remove(match);
   }
   
   public MatchV2 getMatch(int index)
   {
      return matchs.get(index);
   }
   
   public String toString()
   {
      String returnStr = "";

      for(int i = 0; i < matchs.size(); i++)
      {
            returnStr += matchs.get(i) + "\n";
      }
      
      return returnStr;
   }
}


