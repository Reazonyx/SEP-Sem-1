import java.util.ArrayList;

public class PlayerListV1
{
   private ArrayList<PlayerV1> players;
   
   public PlayerListV1()
   {
      players = new ArrayList<PlayerV1>();
   }
   
   public void addPlayer(PlayerV1 player)
   {
      players.add(player);
   }
   
   public void removePlayer(PlayerV1 player)
   {
      players.remove(player);
   }
   
   public PlayerV1 getPlayer(int index)
   {
      return players.get(index);
   }
   
   public PlayerV1[] getAllPlayers()
   {
      PlayerV1[] temp = new PlayerV1[players.size()];
      return players.toArray(temp);
   }
   
   public int getNumberOfPlayers()
   {
      return players.size();
   }
   
   public PlayerV1 getNote(PlayerV1 note)
   {
      return note;
   }
   
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
