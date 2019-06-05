import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Match objects.
 * @author krogh
 * @version 
 */

public class MatchList implements Serializable
{
   private ArrayList<Match> matchs;
   
   /**
    * No-argument constructor initializing the MatchList.
    */

   public MatchList()
   {
      matchs = new ArrayList<Match>();
   }
   
   /**
    * Adds a Match to the list.
    * @param match the match to add to the list.
    */

   public void addMatch(Match match)
   {
      matchs.add(match);
   }
   
   /**
    * Removes a match from the list.
    * @param match the match to be removed from the list.
    */

   public void removeMatch(Match match)
   {
      matchs.remove(match);
   }
   
   /**
    * Returns the size of the array list.
    * @return int of size of the array list.
    */

   public int getSize() {
      return matchs.size();
   }
   
   /**
    * Gets a Match object from position index from the list.
    * @param index the position in the list of the Match object.
    * @return the Match object at position index.
    */

   public Match getMatch(int index)
   {
      return matchs.get(index);
   }
   
   /**
    * Gets a String representation of the MatchList
    * @return a String containing information about all Match objects in the list - each Match object is continued on a new line, with the new line charater.
    */

   public int getNumOfMatches() {
      return matchs.size();
   }
   
   public Match[] getAllMatches()
   {
      Match[] temp = new Match[matchs.size()];
      return matchs.toArray(temp);
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
