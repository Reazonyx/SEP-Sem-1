import java.io.FileNotFoundException;
import java.io.IOException;

public class PlayerFileAdapter
{
   private MyFileIO mfio;
   private String fileName;
   
   public PlayerFileAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }
   
   public PlayerList getAllPlayers()
   {
      PlayerList players = new PlayerList();
      
      try
      {
         players = (PlayerList)mfio.readObjectFromFile(fileName);
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
      return players;
   }
   
   public PlayerList getPlayersFrom(String fromName)
   {
      PlayerList players = new PlayerList();
      
      try
      {
         PlayerList result = (PlayerList)mfio.readObjectFromFile(fileName);
         
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
         mfio.writeToFile(fileName, players);
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
