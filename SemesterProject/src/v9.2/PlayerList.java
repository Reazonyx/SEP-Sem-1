import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Player objects
 * @author Smilte
 * @version
 */
public class PlayerList implements Serializable
{
   private ArrayList<Player> players;

   /**
    * No-argument constructor initializing the PlayerList
    */
   public PlayerList()
   {
      players = new ArrayList<Player>();
   }
   
   /**
    * Gets number of players in Player ArrayList
    * @return player number from arrayList (size of arrayList)
    */
   public int getNumOfPlayers()
   {
      return players.size();
   }
   
   /**
    * Adds a player to the Player list 
    * @param player adds to arrayList players
    */
   public void addPlayer(Player player) 
   {
      players.add(player);
   }
   
   /**
    * Removes player from Player list
    * @param player removes from players arrayList
    */   
   public void removePlayer(Player player) 
   {
      players.remove(player);
   }
   
   /**
    * Converts from arrayList to array
    * @return players arrayList in array 
    */
   public Player[] getAllPlayers()
   {
      Player[] temp = new Player[players.size()];
      return players.toArray(temp);
   }
   
   /**
    * Gets note
    * @param index
    * @return
    */
   public String getNoteFrom(int index) 
   {
     return players.get(index).getNote();
   }
   
   /**
    * 
    * @param player
    * @return
    */
   public boolean contains(Player player)
   {
      return players.contains(player);
   }
   
   /**
    * Gets player from Player class
    * @param index
    * @return
    */
   public Player getPlayer(int index)
   {
      if(index < players.size())
      {
         return players.get(index);
      }
      else
      {
         return null;
      }
   }
   
   /**
    * Gets a String representation of the PlayerList
    * @return a String containing information about all Player objects in the list - each Player object is continued on a new line, with the new line charater.
    */
   public String toString() 
   {
      String returnStr = "";
       
      for(int i = 0; i < players.size(); i++)
      {
            returnStr += players.get(i) + "\n";
      }
      
      return returnStr;
   }
}