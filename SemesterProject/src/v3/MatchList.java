import java.util.ArrayList;

public class MatchList
{
   private ArrayList<Match> matchs;

   public MatchList()
   {
      matchs = new ArrayList<Match>();
   }

   public void addMatch(Match match)
   {
      matchs.add(match);
   }

   public void removeMatch(Match match)
   {
      matchs.remove(match);
   }

   public Match getMatch(int index)
   {
      return matchs.get(index);
   }

   public String toString()
   {
      String returnStr = "";

      for (int i = 0; i < matchs.size(); i++)
      {
         returnStr += matchs.get(i) + "\n";
      }

      return returnStr;
   }

}
