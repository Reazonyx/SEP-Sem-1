import java.io.FileNotFoundException;
import java.io.IOException;

public class PlayerListFileAdapter
{
   private MyFileIO mfio2;
   private String fileName2;
   
   public PlayerListFileAdapter(String fileName2)
   {
      mfio2 = new MyFileIO();
      this.fileName2 = fileName2;
   }
   
   public PlayerList getAllPlayers()
   {
      PlayerList players = new PlayerList();
      
      try
      {
         players = (PlayerList)mfio2.readObjectFromFile(fileName2);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class not found");
      }
      System.out.println(players);
      return players;
   }
   
   public PlayerList getPlayersFrom(String fromName)
   {
      PlayerList players = new PlayerList();
      
      try
      {
         PlayerList result = (PlayerList)mfio2.readObjectFromFile(fileName2);
         
         for(int i = 0; i < result.getNumOfPlayers(); i++)
         {
            if(result.getPlayer(i).getName().equals(fromName))
            {
               players.addPlayer(result.getPlayer(i));
            }
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }

      return players;
   }
   
   public void savePlayers(PlayerList players)
   {
      
      try
      {
         mfio2.writeToFile(fileName2, players);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
   }
   
  
}