import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Match objects.
 * @author krogh
 * @version 
 */

public class MatchList implements Serializable
{
   private ArrayList<Match> matches;
   
   /**
    * No-argument constructor initializing the MatchList.
    */

   public MatchList()
   {
      matches = new ArrayList<Match>();
   }
   
   /**
    * Adds a Match to the list.
    * @param match the match to add to the list.
    */

   public void addMatch(Match match)
   {
      matches.add(match);
   }
   
   /**
    * Removes a match from the list.
    * @param match the match to be removed from the list.
    */

   public void removeMatch(Match match)
   {
      matches.remove(match);
   }
   
   /**
    * Returns the size of the array list.
    * @return int of size of the array list.
    */

   public int getSize() {
      return matches.size();
   }
   
   /**
    * Gets a Match object from position index from the list.
    * @param index the position in the list of the Match object.
    * @return the Match object at position index.
    */

   public Match getMatch(int index)
   {
      return matches.get(index);
   }
   
   /**
    * Gets a String representation of the MatchList
    * @return a String containing information about all Match objects in the list - each Match object is continued on a new line, with the new line charater.
    */

   
   public String toString()
   {
      String returnStr = "";

      for (int i = 0; i < matches.size(); i++)
      {
         returnStr += matches.get(i) + "\n";
      }

      return returnStr;
   }
   
   /**
    * Method that returns the number of matches;
    * @return size of the arrayList;
    */
   
   public int getNumOfMatches() {
      return matches.size();
   }
   
   /**
    * Get all the 
    *@param temp represents the temporary array where to store the matches.
    *@return all matches of the arrayList 
    */
   
   public Match[] getAllMatches()
   {
      Match[] temp = new Match[matches.size()];
      return matches.toArray(temp);
   }

}
