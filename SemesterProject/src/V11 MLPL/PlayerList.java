import java.io.Serializable;
import java.util.ArrayList;
public class PlayerList implements Serializable
{
   private ArrayList<Player> players;

   public PlayerList()
   {
      players = new ArrayList<Player>();
   }
   
   public Player getPlayer(int index) {
      return players.get(index);
   }
   
   public int getNumOfPlayers()
   {
      return players.size();
   }
   
   public void addPlayer(Player player) {
      players.add(player);
   }
   
   public void removePlayer(Player player) {
      players.remove(player);
   }

   public Player[] getAllPlayers()
   {
      Player[] temp = new Player[players.size()];
      return players.toArray(temp);
   }
   
   public String getNoteFrom(int index) {
     return players.get(index).getNote();
   }
   
   public boolean contains(Player player)
   {
      return players.contains(player);
   }
   
   public String toString() {
       String returnStr = "";

      for(int i = 0; i < players.size(); i++)
      {
            returnStr += players.get(i) + "\n";
      }
      
      return returnStr;
   }
   
}
