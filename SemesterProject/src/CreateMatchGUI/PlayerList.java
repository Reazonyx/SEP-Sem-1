import java.io.Serializable;
import java.util.ArrayList;

public class PlayerList implements Serializable
{

   /**
    * A class representin the Player List with array of Player objects.
    * 
    * @author David Nguyen
    * @version
    */

   private ArrayList<Player> players;

   /**
    * No-argument constructor.
    * 
    * @param arraylist
    *           of player objects
    */

   public PlayerList()
   {
      players = new ArrayList<Player>();
   }

   /**
    * Gets object Player from arraylist
    * 
    * @param index
    * @return the Payer from position index in the ArrayList
    */

   public Player getPlayer(int index)
   {
      return players.get(index);
   }

   /**
    * @return
    */

   public int getNumOfPlayers()
   {
      return players.size();
   }

   /**
    * @param players2
    */

   public void addPlayer(Player player)
   {
      players.add(player);
   }

   /**
    * @param player
    */

   public void removePlayer(Player player)
   {
      players.remove(player);
   }

   /**
    * @return
    */

   public Player[] getAllPlayers()
   {
      Player[] temp = new Player[players.size()];
      return players.toArray(temp);
   }

   /**
    * @param index
    * @return
    */

   public String getNoteFrom(int index)
   {
      return players.get(index).getNote();
   }

   /**
    * @param player
    * @return
    */

   public boolean contains(Player player)
   {
      return players.contains(player);
   }

   /**
    * 
    */
   public String toString()
   {
      String returnStr = "";

      for (int i = 0; i < players.size(); i++)
      {
         returnStr += players.get(i) + "\n";
      }

      return returnStr;
   }

}
