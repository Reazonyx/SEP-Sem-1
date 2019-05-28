import java.util.ArrayList;
public class PlayerListV2
{
   private ArrayList<PlayerV2> players;
   private PlayerV2 player;

   public PlayerListV2()
   {
      players = new ArrayList<PlayerV2>();
   }
   
   public PlayerV2 getPlayer() {
      return player;
   }
   
   public void addPlayer(PlayerV2 player) {
      players.add(player);
   }
   
   public void removePlayer(PlayerV2 player) {
      players.remove(player);
   }

   public PlayerV2[] getAllPlayers()
   {
      PlayerV2[] temp = new PlayerV2[players.size()];
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
