import java.util.ArrayList;
public class PlayerList
{
   private ArrayList<Player> players;
   private Player player;

   public PlayerList()
   {
      players = new ArrayList<Player>();
   }
   
   public Player getPlayer() {
      return player;
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
   
   public String toString() {
       String returnStr = "";

      for(int i = 0; i < players.size(); i++)
      {
            returnStr += players.get(i) + "\n";
      }
      
      return returnStr;
   }
   
}
